package TPZTBCS;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;

import java.util.Timer;


@Entity
@Table(name = "Usuario")
public class Usuario 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USR_ID")
    Long ID;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name = "DATOS_PERSONALES_ID")
	DatosPersonales Datos= new DatosPersonales();
	
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	
//	@OneToMany (mappedBy = "evento",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Collection <Evento> listaEvento = new ArrayList<Evento>();
	private PrendaBuilder prendaBuilder;
	
	
	public DatosPersonales getDatos() {
		return this.Datos;
	}
	
	public Usuario(String email) {
		this.getDatos().setEmail(email);
	}
	
	public Usuario() {
		
	}
	
	public void CrearGuardarropa(String Identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(Identificador);
		listaGuardarropas.add(guardarropaNuevo);
	}
	
	public void setFrioMaximo(int cantidadFrio) {
		this.Datos.setFrioMaximo(cantidadFrio);
	}
	public void setFrioMinimo(int cantidadFrio) {
		this.Datos.setFrioMinimo(cantidadFrio);
	}
	public void setFrioCuello(int cantidadFrio) {
		this.Datos.setFrioCuello(cantidadFrio);
	}
	public void setFrioManos(int cantidadFrio) {
		this.Datos.setFrioManos(cantidadFrio);
	}
	public void setFrioCabeza(int cantidadFrio) {
		this.Datos.setFrioCabeza(cantidadFrio);
	}
	public void setEmail(String email) {
		this.Datos.setEmail(email);
	}
	public void setEdad(int edad) {
		this.Datos.setEdad(edad);
	}
	public void setNombre(String nombre) {
		this.Datos.setNombre(nombre);
	}
	
	public int getId() {
        return ID;
    }
	public String getNombre() {
		return this.Datos.getNombre();
	}
	public int getEdad() {
		return this.Datos.getEdad();
	}
	public String getEmail() {
		return Datos.getEmail();
	}
	public int getFrioMaximo() {
		return Datos.getFrioMaximo();
	}
	public int getFrioMinimo() {
		return Datos.getFrioMinimo();
	}
	public int getFrioManos() {
		return Datos.getFrioManos();
	}
	public int getFrioCuello() {
		return Datos.getFrioCuello();
	}
	public int getFrioCabeza() {
		return Datos.getFrioCabeza();
	}

	
	public PrendaBuilder setPrendaBuilder(String parteCuerpo) throws Exception 
	{
		switch(parteCuerpo) 
		{
			case "Parte Superior":
				ParteSuperior ps = new ParteSuperior();
				return ps;
			case "Parte Inferior": 
				ParteInferior pi = new ParteInferior();
				return pi;
			case "Accesorio":
				Accesorio ac = new Accesorio();
				return ac;
			case "Calzado": 
				Calzado cz = new Calzado();
				return cz;
			default:
				throw new Exception("NO EXISTE PARTE");
		}
	}
	
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario, String colorSecundario) throws Exception
	{
		prendaBuilder = this.setPrendaBuilder(parte); 
		
		prendaBuilder.verificarColoresDistintos(colorPrimario,colorSecundario);
		prendaBuilder.crearPrenda();
		prendaBuilder.buildParte();		
		prendaBuilder.buildTipo(tipo);
		prendaBuilder.buildMaterial(material);
		prendaBuilder.buildColorPrimario(colorPrimario);
		prendaBuilder.buildColorSecundario(colorSecundario);
		return prendaBuilder.getPrenda();	
	}
	
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario) throws Exception
	{
		prendaBuilder = this.setPrendaBuilder(parte); 
		
		prendaBuilder.crearPrenda();
		prendaBuilder.buildParte();
		prendaBuilder.buildTipo(tipo);
		prendaBuilder.buildMaterial(material);
		prendaBuilder.buildColorPrimario(colorPrimario);
		return prendaBuilder.getPrenda();
	}
	
	public void agregarGuardarropas(Guardarropa guardarropa) 
	{
		this.listaGuardarropas.add(guardarropa);
	}

	public void agregarPrendaAGuardarropas(Guardarropa guardarropa, Prenda prenda) throws Exception 
	{
		guardarropa.agregarAGuardarropas(prenda);
	}
//	
	
	public List<Atuendo> queMePongoATodosLosGuardarropas(String descripcion, double temp) throws Exception,UnauthorizedException,ApiException
	{
		List<Atuendo> atuendos = listaGuardarropas.stream().map(guardarropa -> {
			try {
				return guardarropa.queMePongo(descripcion,this.Datos,temp);
			} catch (UnauthorizedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
        if (atuendos.size()>0)
        {
            return listaGuardarropas.stream().map(guardarropa -> {
				try {
					return guardarropa.queMePongo(descripcion,this.Datos,temp);
				} catch (UnauthorizedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toList());
        }
        else
        {
        	throw new Exception("ERROR SIN ATUENDOS");
        }
	}
	//este lo hace solo una vez
	public void crearEvento(String descripcion,String ciudad,int año,int mes,int dia,int hora,int minutos) {
		 
		Calendar myCalendar = new GregorianCalendar(año, mes-1, dia);
		myCalendar.set(Calendar.HOUR_OF_DAY, hora);
		myCalendar.set(Calendar.MINUTE, minutos);
		 Date fechaDeEvento = myCalendar.getTime();
		 myCalendar.add(Calendar.MINUTE, -1);
		 Date fechaDeSugerencia = myCalendar.getTime();
		 String fecha = fechaDeSugerencia.toString();
		 Evento EventoNuevo= new Evento(fechaDeEvento,fechaDeSugerencia,this,ciudad,descripcion);
		
		this.listaEvento.add(EventoNuevo);
		//System.out.print(fecha);
		
		 
	}
	public void crearEvento(String descripcion,String ciudad,int año,int mes,int dia,int hora,int minutos,int CadacuantosDias) {
		 
		Calendar myCalendar = new GregorianCalendar(año, mes-1, dia);
		myCalendar.set(Calendar.HOUR_OF_DAY, hora);
		myCalendar.set(Calendar.MINUTE, minutos);
		 Date fechaDeEvento = myCalendar.getTime();
		 myCalendar.add(Calendar.DATE, -1);
		 Date fechaDeSugerencia = myCalendar.getTime();
		 String fecha = fechaDeSugerencia.toString();
		 Evento EventoNuevo= new Evento(fechaDeEvento,fechaDeSugerencia,this,ciudad,descripcion,CadacuantosDias);
		
		this.listaEvento.add(EventoNuevo);
		//System.out.print(fecha);
		
		 
	}
	public Evento getEvento(String eventoAObtener) {
		return (Evento) this.listaEvento.stream().filter(evento->evento.getDescripcion().equalsIgnoreCase(eventoAObtener)).collect(Collectors.toList());
	}

	public void puntuarPrenda(Prenda prenda)
	{
		prenda.setPuntaje(this);
	}

}
	