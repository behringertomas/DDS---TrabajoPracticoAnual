

public class Reloj extends Prenda implements IAccesorios{
	String material;
	
	public Reloj(String color,String material) {
		super(color);
		this.material = material;
		this.tipo="Accesorio";
	}
	
	

	public String getParteCuerpo() {
		return IAccesorios.Parte;
	}

}
