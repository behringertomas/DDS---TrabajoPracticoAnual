
public abstract class Prenda {
	
	String tipo;
//	String tipo_tela; CAMBIAR DE CLASE NDEA
	String color_primario;
	String color_secundario="";
	
	public String getTipo() {
		return this.tipo;
//		return this.tipo;
	}
	
	public abstract String getParteCuerpo();
	
	
	public Prenda(String color) {
		this.color_primario = color;
	}


}
