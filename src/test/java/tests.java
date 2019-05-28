import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.paukov.combinatorics3.Generator;

public class tests
{
	@Test
	public void test1()
	{
		Usuario usuario1 = new Usuario();

		Guardarropa guardarropa1 = new Guardarropa();

		Prenda remeraRoja = new Remera("Roja","Seda");
		Prenda camisa= new Camisa("Negra","Tela");
		
		Prenda shortNegro = new Short("Negro","Jean");
		
		Prenda reloj = new Reloj("Dorado","Oro");
		
		Prenda convers = new Zapatilla("Negra","Cuero");
		Prenda pony = new Zapatilla("Blanca","Cuero");

		usuario1.agregarGuardarropas(guardarropa1);

		usuario1.agregarPrendaAGuardarropas(guardarropa1,remeraRoja);
		usuario1.agregarPrendaAGuardarropas(guardarropa1,camisa);

		usuario1.agregarPrendaAGuardarropas(guardarropa1,shortNegro);

		usuario1.agregarPrendaAGuardarropas(guardarropa1,reloj);

		usuario1.agregarPrendaAGuardarropas(guardarropa1,convers);
		usuario1.agregarPrendaAGuardarropas(guardarropa1,pony);

//		System.out.println("Elementos PARTE SUPERIOR");
//		guardarropa1.getArrayParteSuperior();
//
//		System.out.println("Elementos PARTE INFERIOR");
//		guardarropa1.getArrayParteInferior();
//		
//		System.out.println("Elementos de ACCESORIOS");
//		guardarropa1.getArrayAccesorios();
//
//		System.out.println("Elementos de CALZADO");
//		guardarropa1.getArrayCalzado();
		
		usuario1.queMePongo(guardarropa1);
	}
}
