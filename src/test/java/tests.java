import java.util.Arrays;

import org.junit.Test;
import org.paukov.combinatorics3.Generator;

public class tests {
	@Test
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		
		Guardarropa guardarropa1 = new Guardarropa();
		
		Prenda remeraRoja = new Remera("Roja","Seda");
		Prenda shortNegro = new Short("Negro","Jean");
		Prenda camisa= new Camisa("Negra","Tela");
		Prenda reloj = new Reloj("Dorado","Oro");
		Prenda convers = new Zapatilla("Negra","Cuero");
		Prenda pony = new Zapatilla("Blanca","Cuero");
		
		usuario1.agregarGuardarropas(guardarropa1);
		
		usuario1.agregarPrendasAGuardarropas(guardarropa1,remeraRoja);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,camisa);
		
		usuario1.agregarPrendasAGuardarropas(guardarropa1,shortNegro);
		
		usuario1.agregarPrendasAGuardarropas(guardarropa1,reloj);
		
		usuario1.agregarPrendasAGuardarropas(guardarropa1,convers);
		usuario1.agregarPrendasAGuardarropas(guardarropa1,pony);

		
//		System.out.println(remeraRoja.toString());
//		
//
//		
//		Generator.combination(remeraRoja.toString(), "black", "white", "green", "blue")
//        .simple(4)
//        .stream()
//        .forEach(System.out::println);
        
		guardarropa1.getArrayParteSuperior();
		
//		Generator.cartesianProduct(guardarropa1.getArrayParteSuperior(),guardarropa1.getArrayParteInferior())
//        .stream()
//        .forEach(System.out::println);
//		
//		Generator.cartesianProduct(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
//		.stream()
//		.forEach(System.out::println);
		
		
//		Generator.combination(0, 1, 2, 3, 4, 5)
//		  .simple(3)
//		  .stream()
//		  .forEach(System.out::println);
		
//		Generator.combination(remeraRoja.,guardarropa.pi,guardarropa.a,guardarropa.c)
//		  .simple(4)
//		  .stream()
//		  .forEach(guardarropa.toString());
//		
	}

}
