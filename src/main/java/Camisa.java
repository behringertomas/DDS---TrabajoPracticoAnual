
public class Camisa extends Prenda implements IParteSuperior {
	
	String tipo_tela;

	public Camisa(String color,String tipo_tela) {
		super(color);
		this.tipo_tela = tipo_tela;
		this.tipo="Camisa";
		
	}

	public String getParteCuerpo() {
		// TODO Auto-generated method stub
		return IParteSuperior.Parte;
	}
}
