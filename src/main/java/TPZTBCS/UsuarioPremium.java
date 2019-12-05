package TPZTBCS;

public class UsuarioPremium extends Usuario {

	
	public UsuarioPremium(String username,String email,String pass, String nombre,int edad,int fMin,int fMax,int fCuello,int fCabeza, int fManos) {
		super(username, email, pass, nombre, edad,fMin,fMax,fCuello,fCabeza,fManos);
		// TODO Auto-generated constructor stub
	}

	public UsuarioPremium(String username,String email,String pass, String nombre,int edad) {
		super(username, email, pass, nombre, edad);
		// TODO Auto-generated constructor stub
	}

	static int limiteDePrendasXGuardarroa= 80;
	
	public void CrearGuardarropa(String identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(identificador,limiteDePrendasXGuardarroa);
		listaGuardarropas.add(guardarropaNuevo);
	}

}
