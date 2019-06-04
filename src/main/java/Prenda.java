public class Prenda 
{
	private boolean enGuardarropa=false;
    private String parte = "";
    private String tipo = "";
    private String material = "";
    private String colorPrimario = "";
    private String colorSecundario = "";

    public void setParte(String parte)	
    {this.parte = parte;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setMaterial(String material)	{ this.material = material; }
    public void setColorPrimario(String colorPrimario)	{ this.colorPrimario = colorPrimario; }
    public void setColorSecundario(String colorSecundario)	{ this.colorSecundario = colorSecundario; }	
    
    public Prenda getPrenda() { return this; }
    
    public String getParteCuerpo() {return this.parte;}
    public String getTipo() {return this.tipo;}

    public void meterEnGuardarropa() {
    	this.enGuardarropa=true;
    }
    public boolean estaEnGuardarropa() {
    	return this.enGuardarropa;
    }
    public void mostrarPrenda()
    {
    	System.out.println(this.parte);
    	System.out.println(this.tipo);
    	System.out.println(this.material);
    	System.out.println(this.colorPrimario);
    	System.out.println(this.colorSecundario);
    }
    
    public String getColorSecundario() {
    	return this.colorSecundario;
    }
    
    public void imprimirDescripcion() {
    	if(this.colorSecundario == "") {
    		System.out.println(this.tipo + " de " + this.material + this.colorPrimario);
    	} else {
    		System.out.println(this.tipo + " de " + this.material + this.colorPrimario + " y " + this.colorSecundario);
    	}
    }
    
    
}