public abstract class Prenda 
{
	String tipo;
	String material;
	String color_primario;

	String color_secundario=null;

	public Prenda(String color, String material) 
	{
		this.color_primario = color;
		this.material = material;

	}
	
	public abstract String getParteCuerpo();
	
	public String getTipo() 
	{
		//System.out.println(this.tipo);
		return this.tipo;
	}
	
	public String getNombre()
	{
		if (color_secundario==null)
		{
			//System.out.println(this.tipo + " de " + this.material + " de " + this.color_primario);
			return this.tipo + " de " + this.material + " " + this.color_primario;
		}
		else
		{
			//System.out.println(this.tipo + " de " + this.material + " de " + this.color_primario + " y " + this.color_secundario);
			return this.tipo + " de " + this.material + " de " + this.color_primario + " y " + this.color_secundario;			
		}
	}
}
