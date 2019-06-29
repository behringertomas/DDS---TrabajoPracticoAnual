
public class abrigo extends Prenda {
	
	private Prenda PrendaDeAbajo;
	int TemperaturaQueAbriga;
	
	
	@Override
	public int getTemperatura() {
		return PrendaDeAbajo.getTemperatura() + TemperaturaQueAbriga;
		
	}
	@Override
	public void imprimirDescripcion() {
		PrendaDeAbajo.imprimirDescripcion();
		System.out.println(",");
		this.imprimirDescripcion();
		
	}
}
