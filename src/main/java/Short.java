public class Short extends Prenda implements IParteInferior 
{
	public Short(String color,String tipo_tela) 
	{
		super(color,tipo_tela);
		this.tipo="Short";
	}
	
	public String getParteCuerpo() 
	{
		return IParteInferior.Parte;
	}
}
