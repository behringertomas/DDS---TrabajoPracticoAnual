public class Remera extends Prenda implements IParteSuperior 
{		
	public Remera(String color,String tipo_tela) 
	{
		super(color,tipo_tela);
		this.tipo="Remera";
		this.color_secundario = "Amarillo"; //Ejemplo para pruebas

	}

	public String getParteCuerpo()
	{
		return IParteSuperior.Parte;
	}
	
	public String toString() //??
	{
		return "Remera " + this.color_primario;
	}
	

}
