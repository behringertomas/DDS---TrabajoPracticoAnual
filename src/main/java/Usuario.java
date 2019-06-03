import java.util.ArrayList;
import java.util.Collection;
public class Usuario 
{
	String ID = ""; //Identificador del usuario	
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	
	public Usuario() {}
	 
	private PrendaBuilder prendaBuilder;
	
	public void setPrendaBuilder(PrendaBuilder pb) 
	{
		prendaBuilder = pb;
	}
	
	public void construirPrenda(String tipo, String material, String colorPrimario, String colorSecundario) throws Exception
	{
		try 
		{
			prendaBuilder.crearPrenda();
			prendaBuilder.buildParte();		
			prendaBuilder.buildTipo(tipo);
			prendaBuilder.buildMaterial(material);
			prendaBuilder.buildColorPrimario(colorPrimario);
			prendaBuilder.buildColorSecundario(colorSecundario);
			
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());			
		}
	}
	
	public void construirPrenda(String tipo, String material, String colorPrimario) throws Exception
	{
		try 
		{
			prendaBuilder.crearPrenda();
			prendaBuilder.buildParte();
			prendaBuilder.buildTipo(tipo);
			prendaBuilder.buildMaterial(material);
			prendaBuilder.buildColorPrimario(colorPrimario);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());			
		}
	}
	
	public void agregarGuardarropas(Guardarropa guardarropa) 
	{
		this.listaGuardarropas.add(guardarropa);
	}

	
	public void agregarPrendaAGuardarropas(Guardarropa guardarropa, Prenda prenda) 
	{
		guardarropa.agregarAGuardarropas(prenda);
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