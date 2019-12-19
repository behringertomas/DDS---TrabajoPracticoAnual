package TPZTBCS;

public class ZonaYTemperatura {


		String name;
		double temp;
		
		public ZonaYTemperatura(String nombre, double temperatura) {
			this.name=nombre;
			this.temp=temperatura;
		}
		
		public String toString() {
			System.out.println("Ciudad: " + this.name + " Temperatura: " + this.temp);
			return this.name + this.temp;
	
		}

}
