
public class UsuarioPremium extends Usuario {
	int limiteDePrendasXGuardarroa= 80;
	
	public void CrearGuardarropa(String Identificador) {
		Guardarropa guardarropaNuevo= new Guardarropa(Identificador, limiteDePrendasXGuardarroa);
		listaGuardarropas.add(guardarropaNuevo);
		
	}

}
