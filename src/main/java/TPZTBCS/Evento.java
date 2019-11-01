package TPZTBCS;
import java.time.LocalDate;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.TimerTask;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hamcrest.core.IsNull;

import com.krds.accuweatherapi.ApiSession;
import com.krds.accuweatherapi.CurrentConditionsApi;
import com.krds.accuweatherapi.DayPeriod;
import com.krds.accuweatherapi.ForecastApi;
import com.krds.accuweatherapi.LocationApi;
import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;
import com.krds.accuweatherapi.model.GeoPositionSearchResult;
import com.proveedores.openweather.OpenWeather;
import com.weatherlibraryjava.WeatherApixu;

import interfacesZTBCS.ITargetAPI;
import interfacesZTBCS.comando;

import java.util.Scanner;
import java.util.Timer; 

@Entity
@Table(name = "Evento")
public class Evento extends TimerTask implements comando {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EVENTO")
	int ID;
	
	@Column(name = "HS_CHEQUEO_CAMBIOBRUSCO")
	public int horasChequeoCambioBrusco = 6;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Usuario usuario; 
	
	@Transient
	public CambioBruscoClimatico cambioAlerta = null;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ATUENDO_ELEGIDO")
	public Atuendo AtuendoElegido=null; 
	
	@Transient
	public Atuendo Sugerencia=null; 
	
	
	@Column(name = "FECHA_EVENTO")
	public Date FechaDelEvento;
	@Column(name = "FECHA_SUGERENCIA")
	public Date FechaSugerencia;
	@Column(name = "EVENTO_CIUDAD")
	public String ciudad;
	@Column(name = "EVENTO_DESCRIPCION")
	public String Descripcion;
	@Transient
	Timer timer;
	@Transient
	Timer timerAlerta;
	
	@Transient
	ITargetAPI target = new AdapterAPI( new WeatherApixu() ); //apixu
	
	@Column(name = "EVENTO_REPETICION")
	int tiempoRepeticion=0;
	@Column(name = "EVENTO_TEMPERATURA")
	double temp=100;
	@Column(name = "EVENTO_DESCRIPCION_CLIMA")
	public String DescripcionClima =null;
	
	public Evento(Date fechaEvento,Date fechaSugerencia,Usuario ID, String ciudad,String Descripcion) {
		this.FechaDelEvento=fechaEvento;
		this.FechaSugerencia=fechaSugerencia;
		this.usuario = ID;
		this.ciudad = ciudad;
		this.Descripcion= Descripcion.toLowerCase();
		//pruebaCron	prueba=new pruebaCron();
		timer = new Timer();
		//System.out.print(fechaSugerencia.toString());
		timer.schedule(this, fechaSugerencia);
	}
	public Evento(Date fechaEvento,Date fechaSugerencia,Usuario ID, String ciudad,String Descripcion,int cadaCuantosDias) {
		this.FechaDelEvento=fechaEvento;
		this.FechaSugerencia=fechaSugerencia;
		this.usuario = ID;
		this.ciudad = ciudad;
		this.Descripcion= Descripcion.toLowerCase();
		//pruebaCron	prueba=new pruebaCron();
		timer = new Timer();
		this.tiempoRepeticion = cadaCuantosDias;
		//System.out.print(fechaSugerencia.toString());
		timer.schedule(this, fechaSugerencia,this.transformardiasamilisegundis(cadaCuantosDias));
	}
	
	@Override
	public void ejecutar() {

//		this.verificarAlerta();
		this.Sugerencia.bloquear(this.FechaDelEvento); //bloquear las prendas del atuendo para que otro usuario no las pueda usar al mismo tiempo
		this.usuario.addAtuendoHistorial(this.Sugerencia);
		
		this.AtuendoElegido=this.Sugerencia;
		System.out.println("Atuendo Asignado");
		
		this.AtuendoElegido.repuntuarPrendas(this.usuario);
		this.AtuendoElegido.setPuntaje(this.usuario);
		
		//SUMARLE CALIFICACION.
		this.cambioAlerta= new CambioBruscoClimatico(this);
		this.timerAlerta= new Timer();
		
		timerAlerta.schedule(this.cambioAlerta, convertirHorasAMilisegundos(this.horasChequeoCambioBrusco));
	}

	@Override
	public void deshacer() {
	//	this.verificarAlerta();
		
		this.Sugerencia.repuntuarPrendas(this.usuario);
		this.Sugerencia.setPuntaje(this.usuario);
		
		usuario.listaEvento.remove(this);
		
		System.out.println("Evento rechazado");
		timer.cancel();		
	}

	@Override
	public void rechazar() {
		
		this.Sugerencia.repuntuarPrendas(this.usuario);
		this.Sugerencia.setPuntaje(this.usuario);
		
		System.out.println("Atuendo rechazado");
		this.run();
		//RESTARLE CALIFICACION.
	}

	@Override
	public void cancelar() {
		
		usuario.listaEvento.remove(this);
		
		System.out.println("Evento cancelado por falta de atuendo");
		timer.cancel();		
	}

	@Override
	public void run() {
		try {

		OpenWeather apiOpenW = new OpenWeather();
		//obtener descripcion
		//String descripcion = this.requestDescripcionClima();
		String descripcion = "soleado";
		this.setDescripcionClima(descripcion);
		//obtener temp
//		double temp = apiOpenW.obtenerTemperaturATalDia(convertToLocalDateViaInstant(this.FechaSugerencia), this.ciudad);
		double temp = 15;

		this.setTemp(temp);
		
		List<Atuendo>listaSugerencias =usuario.queMePongoATodosLosGuardarropas(descripcion,temp);
		listaSugerencias= listaSugerencias.stream().filter(x->x!=null).collect(Collectors.toList());

//		int rnd = new Random().nextInt(listaSugerencias.size());
//		Atuendo atuendoElegido = listaSugerencias.get(rnd);
		
		this.Sugerencia = this.getMejorAtuendo(listaSugerencias);
		
		if(this.Sugerencia == null) {this.deshacer();}
		
		this.Sugerencia.imprimirPrendas();
		
		NotificacionEmail sender =new NotificacionEmail();
    	sender.enviarNotificacion(this.usuario.getEmail());
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Te parece bien el atuendo?: (SI/NO)");
		String respuesta = myObj.nextLine();
		if (respuesta.toUpperCase().equals("SI")) {
		
			this.ejecutar();
			
		}
		 if (respuesta.toUpperCase().equals("NO")) {
		 System.out.println("DESEA OTRA SUGERENCIA?: (SI/NO)");
		 String respuesta2 = myObj.nextLine();
		 if (respuesta2.toUpperCase().equals("SI")) {
				this.rechazar();
		 }
		 if (respuesta2.toUpperCase().equals("NO")) {
				this.deshacer();		
		 }
		 
		 }
		 
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
  public long transformardiasamilisegundis(int dias) {
	  long milisegundos= dias *24*60*60*1000;
	  return milisegundos;
  }
  
  public Atuendo getMejorAtuendo(List<Atuendo>listaSugerencias) //falta recibir fecha
  {
	  //REVISAR
	  listaSugerencias.sort((A1,A2)-> A1.getPuntaje(this.usuario) - A2.getPuntaje(this.usuario));
	  int cantAtuendos = listaSugerencias.size();
	  
	  for(int i = 0; i < cantAtuendos; i++)
	  {
		  if (listaSugerencias.get(i).isNotBlocked(this.FechaDelEvento))
		  {
			  return listaSugerencias.get(i);			  
		  }
	  }
	  return null;
	  //no se encontraron atuendos disponibles, entonces se debera cancelar el evento.
  }
  
  public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
  
  public void setDescripcionClima(String DescripcionClima) {
	  this.DescripcionClima = DescripcionClima;
  }
  public String getDescripcionClima() {
	  return this.DescripcionClima;
  }
  
  public void setTemp(double temp) {
	  this.temp = temp;
  }
  
  @Override
	public String toString() {
		return "Evento [ID=" + ID + ", usuario=" + usuario + ", FechaDelEvento=" + FechaDelEvento + ", ciudad=" + ciudad
				+ ", Descripcion=" + Descripcion + "]";
	}
  
  public double getTemp() {
	  return this.temp;
  }
  public String getDescripcion() {
	  return this.Descripcion;
  }
  public String getCiudad() {
	  return this.ciudad;
  }
  public Date getFechaDelEvento() {
	  return this.FechaDelEvento;
  }
  public int getHorasCambioBrusco() {
	  return this.horasChequeoCambioBrusco;
  }
  public void setHorasCambioBrusco(int horasCambio) {
	  this.horasChequeoCambioBrusco = horasCambio;
  }
  
  public String requestDescripcionClima() throws UnauthorizedException, ApiException {
	  
    ApiSession session = new ApiSession.Builder("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf").build();
	LocationApi locationApi = session.getLocationApi();
	CurrentConditionsApi current = session.getCurrentConditionsApi("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf");
	Optional <GeoPositionSearchResult> geoLocation = locationApi.geoPosition(target.getLat(this.ciudad),target.getLong(this.ciudad));
	ForecastApi forecastapi= session.getForecastApi(geoLocation.get().getKey());
	
	String descripcion = forecastapi.getDailyXdays(DayPeriod.DAYS_5).get().getHeadline().getCategory();
	forecastapi.getDailyXdays(DayPeriod.DAYS_5).map(x->x.getHeadline().getCategory());
	return descripcion;
	//ES UN SOLO HEADLINE, POR ESO NO FUNCA CON EL MAP-.
  }
  
  public LocalDate obtenerLocalDateHoyCambioBrusco() {
	   LocalDate localDate = LocalDate.now(); 
	   return localDate;
  }
  public int convertirHorasAMilisegundos(int hora) {
	  return hora*60*60*1000;
  }
  public void verificarAlerta() {
	  if (!this.cambioAlerta.equals(null)) {
		this.cambioAlerta = null;  
		timerAlerta.cancel();
	  } 
		  
  }
  
}
