package TPZTBCS;

public class ZonaYTemperatura {


		String name;
		double temp;
		
		public ZonaYTemperatura(String nombre, double temperatura) {
			this.name=nombre;
			this.temp=temperatura;
		}
		
		public String toString() {
<<<<<<< HEAD
			System.out.println("Ciudad: " + this.name + " Temperatura: " + this.temp + "°C");
=======
			System.out.println("Ciudad: " + this.name + " Temperatura: " + this.temp);
>>>>>>> Entrega5
			return this.name + this.temp;
	
		}

}
