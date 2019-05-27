
public abstract class Prenda {
	
	String tipo;
//	String tipo_tela; CAMBIAR DE CLASE NDEA
	String color_primario;
	String color_secundario="";
	
	public void getTipo() {
		System.out.println(this.tipo);
//		return this.tipo;
	}
	
	public abstract String getParteCuerpo();
	
	
	public Prenda(String color) {
		this.color_primario = color;
	}


}
