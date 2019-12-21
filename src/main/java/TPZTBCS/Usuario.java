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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;

import java.util.Timer;


@Entity
@Table(name = "Usuario")
public class Usuario 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	int ID;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name = "ID_DATOS_PERSONALES")
	DatosPersonales Datos= new DatosPersonales();
	
	@Column (name = "ID_GUARDARROPA")
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	
	@Column (name = "ID_EVENTO")
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	Collection <Evento> listaEvento = new ArrayList<Evento>();
	
	@Column (name = "ID_HISTORIAL")
	@ManyToMany(cascade = {CascadeType.ALL})
	List <Atuendo> historialAtuendos = new ArrayList<Atuendo>();
	
<<<<<<< HEAD
=======
	//----- Bit de Premium ----- Si es 1 es premium, 0 standar
	@Column(name = "Bit_Premium")
	private int bit_premium;
>>>>>>> Entrega5
	
	//----- USERNAME para el DAO -----
	@Column(name = "Username")
	private String user; //El UsuarioDao busca esta variable con el getByPropertyValue
	
	//----- EMAIL para el DAO -----
	@Column(name = "Email")
	private String email;
	
	//----- PASSWORD para el DAO -----
	@Column(name = "Password")
	private String pass;

	@Transient
	private PrendaBuilder prendaBuilder;
	
	
	public void setDatos(DatosPersonales datos) {
		Datos = datos;
	}

	public DatosPersonales getDatos() {
		return this.Datos;
	}
	
	public Usuario() {
		
	}
	
//	CONSTRUCTORES
<<<<<<< HEAD
	public Usuario(String username,String email,String pass, String nombre,int edad,int fMin,int fMax,int fCuello,int fCabeza, int fManos) {
=======
	public Usuario(String username,String email,String pass, String nombre,int edad, int bit, int fMin,int fMax,int fCuello,int fCabeza, int fManos) {
>>>>>>> Entrega5
		
		this.user = username;
		this.email = email;
		this.pass = pass;
<<<<<<< HEAD
=======
		this.bit_premium = bit;
		
>>>>>>> Entrega5
		
		this.getDatos().setNombre(nombre);
		this.getDatos().setEdad(edad);
		this.getDatos().setFrioMinimo(fMin);
		this.getDatos().setFrioMaximo(fMax);
		this.getDatos().setFrioCabeza(fCabeza);
		this.getDatos().setFrioCuello(fCuello);
		this.getDatos().setFrioManos(fManos);
		this.agregarGuardarropas(new Guardarropa("DEFAULT"));
		
	}
	
<<<<<<< HEAD
	public Usuario(String username,String email,String pass, String nombre,int edad) {
		this.user = username;
		this.email = email;
		this.pass = pass;
=======
	public Usuario(String username,String email,String pass, String nombre,int edad, int bit) {
		this.user = username;
		this.email = email;
		this.pass = pass;
		this.bit_premium = bit;
>>>>>>> Entrega5
		
		this.getDatos().setNombre(nombre);
		this.getDatos().setEdad(edad);
		this.getDatos().setFrioMinimo(5);
		this.getDatos().setFrioMaximo(15);
		this.getDatos().setFrioCabeza(5);
		this.getDatos().setFrioCuello(5);
		this.getDatos().setFrioManos(5);
		this.agregarGuardarropas(new Guardarropa("DEFAULT"));
	}
	
//	************ PRENDA BUILDER ************
<<<<<<< HEAD
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario, String colorSecundario,Guardarropa guardarropa) throws Exception
	{
		String nombreGuardarropa = guardarropa.getIdentificador();
		return this.getGuardarropa(nombreGuardarropa).construirPrenda(parte, tipo, material, colorPrimario,colorSecundario,guardarropa);	
	}
	
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario,Guardarropa guardarropa) throws Exception
	{
		String nombreGuardarropa = guardarropa.getIdentificador();
		return this.getGuardarropa(nombreGuardarropa).construirPrenda(parte, tipo, material, colorPrimario,guardarropa);	
=======
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario, String colorSecundario,Guardarropa guardarropa, String img_url) throws Exception
	{
		String nombreGuardarropa = guardarropa.getIdentificador();
		return this.getGuardarropa(nombreGuardarropa).construirPrenda(parte, tipo, material, colorPrimario,colorSecundario,guardarropa, img_url);	
	}
	
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario,Guardarropa guardarropa, String img_url) throws Exception
	{
		String nombreGuardarropa = guardarropa.getIdentificador();
		return this.getGuardarropa(nombreGuardarropa).construirPrenda(parte, tipo, material, colorPrimario,guardarropa, img_url);	
>>>>>>> Entrega5
	}
//	****************************************
	
	public String getUsername() {
		return user;
	}

	public void setUsername(String user) {
		this.user = user;
	}
	
	
	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

	

	
	
	public void CrearGuardarropa(String Identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(Identificador);
		listaGuardarropas.add(guardarropaNuevo);
	}
	public void CrearGuardarropa(String Identificador,int capacidad) {
		Guardarropa guardarropaNuevo= new Guardarropa(Identificador,capacidad);
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
		this.email = email;
	}
	public void setEdad(int edad) {
		this.Datos.setEdad(edad);
	}
	public void setNombre(String nombre) {
		this.Datos.setNombre(nombre);
	}
	public void setListaGuardarropas(Collection<Guardarropa> listaGuardarropas) {
		this.listaGuardarropas = listaGuardarropas;
	}
	
<<<<<<< HEAD
	
	
=======
	public int getBit_premium() {
		return bit_premium;
	}

	public void setBit_premium(int bit_premium) {
		this.bit_premium = bit_premium;
	}

>>>>>>> Entrega5
	public Collection<Guardarropa> getListaGuardarropas() {
		return listaGuardarropas;
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
		return this.email;
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
	


	
//	public void asignarPrenda(Guardarropa guardarropaAsignar, Prenda prendaDefault) throws Exception  {
//		Guardarropa Default = this.getGuardarropa("DEFAULT");
//		if(Default.getAllPrendas().contains(prendaDefault) && this.listaGuardarropas.contains(guardarropaAsignar)) {
//			
//			guardarropaAsignar.agregarAGuardarropas(prendaDefault);
//			this.getGuardarropa("DEFAULT").TodasLasPrendas.remove(prendaDefault);
//			
//		}else throw new Exception("ERROR AL ASIGNAR PRENDA");
//		
//		
//	}
	
	
	public List<Atuendo> getHistorialAtuendos() {
		return historialAtuendos;
	}

	public void setHistorialAtuendos(List<Atuendo> historialAtuendos) {
		this.historialAtuendos = historialAtuendos;
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
				guardarropa.TodasLasPrendas.forEach(prenda->{
					//meto las prendas en sus respectivas listas.
					try {
						guardarropa.reacomodarEnGuardarropas(prenda);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
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
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Collection<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(Collection<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}
<<<<<<< HEAD

//	************ CREACION EVENTO ************
	public Evento crearEvento(String descripcion,String ciudad,int anio,int mes,int dia,int hora,int minutos) {
		 
		Calendar myCalendar = new GregorianCalendar(anio, mes-1, dia);
		myCalendar.set(Calendar.HOUR_OF_DAY, hora);
		myCalendar.set(Calendar.MINUTE, minutos);
		Date fechaDeEvento = myCalendar.getTime();
		myCalendar.add(Calendar.MINUTE, -1);
		Date fechaDeSugerencia = myCalendar.getTime();
		String fecha = fechaDeSugerencia.toString();
=======
	
	

//	************ CREACION EVENTO ************
	@SuppressWarnings("deprecation")
	public Evento crearEvento(String descripcion,String ciudad,Date fechaDeEvento,int hora,int minutos) {
		 
		Date fechaDeSugerencia = new java.util.Date();
		fechaDeSugerencia.setDate(fechaDeSugerencia.getDate() + 3);
>>>>>>> Entrega5
		 
		Evento EventoNuevo= new Evento(fechaDeEvento,fechaDeSugerencia,this,ciudad,descripcion);
		
		this.listaEvento.add(EventoNuevo);
		return EventoNuevo;
<<<<<<< HEAD
		
		//System.out.print(fecha);
		
		 
	}
	public Evento crearEvento(String descripcion,String ciudad,int anio,int mes,int dia,int hora,int minutos,int CadacuantosDias) {
		 
		Calendar myCalendar = new GregorianCalendar(anio, mes-1, dia);
		myCalendar.set(Calendar.HOUR_OF_DAY, hora);
		myCalendar.set(Calendar.MINUTE, minutos);
		 Date fechaDeEvento = myCalendar.getTime();
		 myCalendar.add(Calendar.DATE, -1);
		 Date fechaDeSugerencia = myCalendar.getTime();
		 String fecha = fechaDeSugerencia.toString();
		 Evento EventoNuevo= new Evento(fechaDeEvento,fechaDeSugerencia,this,ciudad,descripcion,CadacuantosDias);
=======
		 
	}
	
	@SuppressWarnings("deprecation")
	public Evento crearEvento(String descripcion,String ciudad,Date fechaDeEvento,int hora,int minutos,int CadacuantosDias) {
		 
		Date fechaDeSugerencia = new java.util.Date();
		fechaDeSugerencia.setDate(fechaDeSugerencia.getDate() + 3);
		
		Evento EventoNuevo= new Evento(fechaDeEvento,fechaDeSugerencia,this,ciudad,descripcion,CadacuantosDias);
>>>>>>> Entrega5
		
		this.listaEvento.add(EventoNuevo);
		return EventoNuevo;
		
	}
	
	public Evento getEvento(String eventoAObtener) {
		return (Evento) this.listaEvento.stream().filter(evento->evento.getDescripcion().equalsIgnoreCase(eventoAObtener)).collect(Collectors.toList()).get(0);
	}

	public Guardarropa getGuardarropa(String guardarropaAObtener) {
		return (Guardarropa) this.listaGuardarropas.stream().filter(x->x.getIdentificador().equalsIgnoreCase(guardarropaAObtener)).collect(Collectors.toList()).get(0);
	}
	public void puntuarPrenda(Prenda prenda,int puntaje)
	{
		prenda.setPuntaje(this,puntaje);
	}
	
	public void addAtuendoHistorial(Atuendo atuendo)
	{
		this.historialAtuendos.add(atuendo);
	}
	
    public String userSession() {
        return getId() + "-" + getUsername();
    }

}
	