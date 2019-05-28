public class Camisa extends Prenda implements IParteSuperior 
{
	public Camisa(String color,String tipo_tela)
	{
		super(color,tipo_tela);
		this.tipo="Camisa";		
	}

	public String getParteCuerpo() 
	{
		return IParteSuperior.Parte;
	}
}
