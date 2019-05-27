
public class Short extends Prenda implements IParteInferior {
	
	String tipo_tela;
	
	public Short(String color,String tipo_tela) {
		super(color);
		this.tipo_tela = tipo_tela;
		this.tipo="Short";
	}
	
	public String getParteCuerpo() {
//		 TODO Auto-generated method stub
		return IParteInferior.Parte;
	}
	

}
