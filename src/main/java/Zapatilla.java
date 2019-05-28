public class Zapatilla extends Prenda implements ICalzado 
{	
	public Zapatilla(String color,String material) 
	{
		super(color, material);
		this.tipo="Zapatilla";
	}

	public String getParteCuerpo() 
	{
		return ICalzado.Parte;
	}
}
