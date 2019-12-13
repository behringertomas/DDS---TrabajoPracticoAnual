package web.models.views;

import javax.persistence.Column;

public class listadoPrendasTable {
	
	private String parte;
	private String tipo;
	private String material;
	private String color_primario;
	private String color_secundario;
	private String url_img;
	
	public listadoPrendasTable() {
		
	}
    public listadoPrendasTable(String parte, String tipo,String material,String color_primario,String color_secundario,String parte_especifica, String url_img) 
    {
    	this.parte = parte;
    	this.tipo = material;
    	this.color_primario = color_primario;
    	this.color_secundario  = color_secundario;
    	this.material = material;
    	this.url_img = url_img;
    	
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
	public String getUrl_img() {
		return url_img;
	}
	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}

	
    
    
    

}

