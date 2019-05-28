
public class Zapatilla extends Prenda implements ICalzado {

	String tipo_tela;
	
	public Zapatilla(String color,String tipo_tela) {
		super(color);
		this.tipo_tela = tipo_tela;
		this.tipo="Zapatilla";
	}

	public String getParteCuerpo() {
		// TODO Auto-generated method stub
		return ICalzado.Parte;
	}

}
