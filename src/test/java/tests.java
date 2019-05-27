import org.junit.Test;
import org.paukov.combinatorics3.Generator;

public class tests {
	@Test
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		
		Guardarropa guardarropa1 = new Guardarropa();
		
		Prenda remeraRoja = new Remera("Rojo");
		Prenda shortcito = new Short();
		Prenda camisa= new Camisa();
		Prenda reloj = new Reloj();
		Prenda convers = new Zapatilla();
		Prenda pony = new Zapatilla();
		
		usuario1.agregarGuardarropas(guardarropa1);
		
		usuario1.agregarPrendasAGuardarropas(guardarropa1,remeraRoja);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,shortcito);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,camisa);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,reloj);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,convers);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,pony);
			
		Guardarropa.generate(6, 4);
//		Generator.combination(remeraRoja.,guardarropa.pi,guardarropa.a,guardarropa.c)
//		  .simple(4)
//		  .stream()
//		  .forEach(guardarropa.toString());
//		
	}

} 
