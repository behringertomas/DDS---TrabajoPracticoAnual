public class Prenda 
{
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

    public void mostrarPrenda()
    {
    	System.out.println(this.parte);
    	System.out.println(this.tipo);
    	System.out.println(this.material);
    	System.out.println(this.colorPrimario);
    	System.out.println(this.colorSecundario);
    }
}