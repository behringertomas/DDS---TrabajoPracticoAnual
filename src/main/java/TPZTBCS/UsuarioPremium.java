package TPZTBCS;

public class UsuarioPremium extends Usuario {
	public UsuarioPremium(String id, String email) {
		super(id, email);
	}

	int limiteDePrendasXGuardarroa= 80;
	
	@Override
	public void CrearGuardarropa(String Identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(Identificador, limiteDePrendasXGuardarroa);
		listaGuardarropas.add(guardarropaNuevo);
	}

}