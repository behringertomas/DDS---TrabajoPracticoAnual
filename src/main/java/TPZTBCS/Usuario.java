package TPZTBCS;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;

import java.util.Timer;

public class Usuario 
{
	
	DatosPersonales Datos= new DatosPersonales();
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	Collection <Evento> listaEvento = new ArrayList<Evento>();
	
	public DatosPersonales getDatos() {
		return this.Datos;
	}
	
	public Usuario(String id,String email) {
		this.getDatos().setID(id);
		this.getDatos().setEmail(email);
	}
	
	private PrendaBuilder prendaBuilder;
	
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
	public void setID(String id) {
		this.Datos.setID(id);
	}
	public void setEmail(String email) {
		this.Datos.setEmail(email);
	}
	
	public String getID() {
		return Datos.getID();
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
	
	public List<Atuendo> queMePongoATodosLosGuardarropas(String ciudad) throws Exception,UnauthorizedException,ApiException
	{
		List<Atuendo> atuendos = listaGuardarropas.stream().map(guardarropa -> {
			try {
				return guardarropa.queMePongo(ciudad,this.Datos);
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
					return guardarropa.queMePongo(ciudad,this.Datos);
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
	public void crearEvento(Date fecha,String descripcion,String ciudad) {
		 
		 Date date = fecha;
		 Timer timer = new Timer();
		 Evento EventoNuevo= new Evento(fecha,this,ciudad,descripcion);
		 this.listaEvento.add(EventoNuevo);
		 timer.schedule(EventoNuevo, date);
		 
	}
	
	public Evento getEvento(String eventoAObtener) {
		return (Evento) this.listaEvento.stream().filter(evento->evento.getDescripcion().equalsIgnoreCase(eventoAObtener)).collect(Collectors.toList());
	}

}