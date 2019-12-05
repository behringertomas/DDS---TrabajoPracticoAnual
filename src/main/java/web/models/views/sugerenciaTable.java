package web.models.views;

public class sugerenciaTable {

	private String parte;
	private String tipo;
	private String material;
	private String color_primario;
	private String color_secundario;
	private String Descripcion;
	
	public sugerenciaTable() {
		
	}
	
    public sugerenciaTable(String parte, String tipo,String material,String color_primario,String color_secundario,String parte_especifica) 
    {
    	this.parte = parte;
    	this.tipo = material;
    	this.color_primario = color_primario;
    	this.color_secundario  = color_secundario;
    	this.material = material;
    	
    }
    
	public String getEvento() {
		return Descripcion;
	}
	public void setEvento(String evento) {
		this.Descripcion = evento;
	}
	public String getParte() {
		return parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor_primario() {
		return color_primario;
	}

	public void setColor_primario(String color_primario) {
		this.color_primario = color_primario;
	}

	public String getColor_secundario() {
		return color_secundario;
	}

	public void setColor_secundario(String color_secundario) {
		this.color_secundario = color_secundario;
	}

}
