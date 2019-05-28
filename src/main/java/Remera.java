

public class Remera extends Prenda implements IParteSuperior {
	String tipo_tela;
	
	
	public String toString() {
		return "Remera " + this.color_primario;
	}
	
	public Remera(String color,String tipo_tela) {
		super(color);
		this.tipo_tela = tipo_tela;
		this.tipo="Remera";

	}
	

	public String getParteCuerpo() {
		// TODO Auto-generated method stub
		return IParteSuperior.Parte;
	}

}
