import java.util.ArrayList;
import java.util.Collection;
public class Usuario 
{
	String ID; //Identificador del usuario	
	Collection <Guardarropa> listaGuardarropas = new ArrayList<Guardarropa>(); //Lista de Guardarropas que contiene el usuario
	
	public Usuario() {}
	
	public void queMePongo(Guardarropa guardarropa)
	{
		guardarropa.queMePongo();
	}
	
	public void crearGuardarropas(String nombreGuardarropas) //FALTA AGREGARLE NOMBRE AL GUARDARROPAS
	{
		Guardarropa guardarropa = new Guardarropa();
	}
	
	public void agregarGuardarropas(Guardarropa guardarropa) 
	{
		this.listaGuardarropas.add(guardarropa);
	}
	
	public void agregarPrendaAGuardarropas(Guardarropa guardarropa, Prenda prenda) 
	{
		guardarropa.agregarAGuardarropas(prenda);
	}
}
