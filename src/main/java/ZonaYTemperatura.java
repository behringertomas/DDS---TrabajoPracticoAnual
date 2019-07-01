
public class ZonaYTemperatura {
	String name;
	double temp;
	
	
	public ZonaYTemperatura(String nombre, double temperatura) {
		this.name=nombre;
		this.temp=temperatura;
	}
	
	public String toString() {
		return this.name + this.temp;
	}
	
}
