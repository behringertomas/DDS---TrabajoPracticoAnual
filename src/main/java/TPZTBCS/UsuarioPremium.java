package TPZTBCS;

public class UsuarioPremium extends Usuario {

	
	public UsuarioPremium(String nombre, int edad, String email, int fMin, int fMax, int fCuello, int fCabeza,
			int fManos) {
		super(nombre, edad, email, fMin, fMax, fCuello, fCabeza, fManos);
		// TODO Auto-generated constructor stub
	}

	public UsuarioPremium(String nombre, int edad, String email) {
		super(nombre, edad, email);
		// TODO Auto-generated constructor stub
	}

	static int limiteDePrendasXGuardarroa= 80;
	
	public void CrearGuardarropa(String identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(identificador,limiteDePrendasXGuardarroa);
		listaGuardarropas.add(guardarropaNuevo);
	}

}
