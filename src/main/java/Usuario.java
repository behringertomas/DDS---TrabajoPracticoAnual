import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Usuario 
{
	String ID = ""; //Identificador del usuario	
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	
	public Usuario() {}
	 
	private PrendaBuilder prendaBuilder;
	
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
		
//		try 
//		{
			prendaBuilder = this.setPrendaBuilder(parte); 
			
			prendaBuilder.verificarColoresDistintos(colorPrimario,colorSecundario);
			prendaBuilder.crearPrenda();
			prendaBuilder.buildParte();		
			prendaBuilder.buildTipo(tipo);
			prendaBuilder.buildMaterial(material);
			prendaBuilder.buildColorPrimario(colorPrimario);
			prendaBuilder.buildColorSecundario(colorSecundario);
		return prendaBuilder.getPrenda();
		
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());			
//		}
	}
	
	public Prenda construirPrenda(String parte,String tipo, String material, String colorPrimario) throws Exception
	{
//		try 
//		{
			prendaBuilder = this.setPrendaBuilder(parte); 
			
			prendaBuilder.crearPrenda();
			prendaBuilder.buildParte();
			prendaBuilder.buildTipo(tipo);
			prendaBuilder.buildMaterial(material);
			prendaBuilder.buildColorPrimario(colorPrimario);
			
		return prendaBuilder.getPrenda();
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());			
//		}
	}
	
	public void agregarGuardarropas(Guardarropa guardarropa) 
	{
		this.listaGuardarropas.add(guardarropa);
	}

	
	public void agregarPrendaAGuardarropas(Guardarropa guardarropa, Prenda prenda) throws Exception 
	{
		guardarropa.agregarAGuardarropas(prenda);
	}
	
	public List<Atuendo> queMePongoATodosLosGuardarropas(){
		
			return listaGuardarropas.stream().map(guardarropa -> guardarropa.queMePongo()).collect(Collectors.toList());
			
	}
	
	
//	public void queMePongo(Guardarropa guardarropa)
//	{
//		guardarropa.queMePongo();
//	}
	
//	public void crearGuardarropas(String nombreGuardarropas) //FALTA AGREGARLE NOMBRE AL GUARDARROPAS
//	{
//		Guardarropa guardarropa = new Guardarropa();
//	}


}