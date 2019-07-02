package TPZTBCS;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Timer;

public class Usuario 
{
	String ID = ""; //Identificador del usuario	
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	Collection <Evento> listaEvento = new ArrayList<Evento>();
	public Usuario() {}
	public Usuario(String id) {this.ID = id;}
	
	private PrendaBuilder prendaBuilder;
	
	public void CrearGuardarropa(String Identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(Identificador);
		listaGuardarropas.add(guardarropaNuevo);
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
	
	public List<Atuendo> queMePongoATodosLosGuardarropas(String ciudad) throws Exception
	{
		List<Atuendo> atuendos = listaGuardarropas.stream().map(guardarropa -> guardarropa.queMePongo(ciudad)).collect(Collectors.toList());
        if (atuendos.size()>0)
        {
            return listaGuardarropas.stream().map(guardarropa -> guardarropa.queMePongo(ciudad)).collect(Collectors.toList());
        }
        else
        {
        	throw new Exception("ERROR SIN ATUENDOS");
        }
	}
	public void crearEvento(Date fecha) {
		 
		 Date date = fecha;
		 Timer timer = new Timer();
		 Evento EventoNuevo= new Evento(fecha,this);
		 this.listaEvento.add(EventoNuevo);
		 timer.schedule(EventoNuevo, date);
		 
	}


}