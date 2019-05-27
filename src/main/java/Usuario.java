import java.util.ArrayList;
import java.util.Collection;
public class Usuario {
	String nombre;
	
	Collection <Guardarropa> guardarropas = new ArrayList<Guardarropa>();
	
	public void agregarGuardarropas(Guardarropa guardarropa) {
		this.guardarropas.add(guardarropa);
	}
	
	public void agregarPrendasAGuardarropas(Guardarropa guardarropa, Prenda prenda) {
		guardarropa.agregarAGuardarropas(prenda);
	}
	
	public Usuario() {
		
	}

}
