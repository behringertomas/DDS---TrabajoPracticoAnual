import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.paukov.combinatorics3.Generator;

import junit.framework.Assert;

public class tests
{
//	@Test
//	public void test() throws Exception
//	{		
//		Usuario usuario = new Usuario();
//		Guardarropa guardarropas = new Guardarropa();
//		
//		usuario.agregarGuardarropas(guardarropas);
//		ParteSuperior ps = new ParteSuperior();
//		
//		usuario.setPrendaBuilder(ps);
//		usuario.construirPrenda("Remera", "Algodon", "Rojo", "Negro");
//		usuario.agregarPrendaAGuardarropas(guardarropas, ps.getPrenda());
//		(ps.getPrenda()).mostrarPrenda();
//
//		usuario.construirPrenda("Camisa", "Seda", "Blanco");
//		usuario.agregarPrendaAGuardarropas(guardarropas, ps.getPrenda());
//		guardarropas.getArrayParteSuperior();		
//		(ps.getPrenda()).mostrarPrenda();
//	}
	
//	@Before
//    void init() 
//	{
//		Usuario usuario = new Usuario();
//		ParteSuperior ps = new ParteSuperior();
//		usuario.setPrendaBuilder(ps);
//  }
	
	//@Rule public ExpectedException exception = ExpectedException.none();
	@Test
	public void whenExceptionThrown_thenExpectationSatisfied() throws Exception 
	{
//		exception.expect(IllegalArgumentException.class);
//		exception.expectMessage("ERROR COLOR PRIMARIO");
//		Usuario usuario = new Usuario();
//		ParteSuperior ps = new ParteSuperior();
//		usuario.setPrendaBuilder(ps);
//		usuario.construirPrenda("Remera", "Algodon", "rositaConcha", "Negro");
		
		try {
			Usuario usuario = new Usuario();
			ParteSuperior ps = new ParteSuperior();
			usuario.setPrendaBuilder(ps);
			usuario.construirPrenda("Remera", "Algodon", "Rojo", "Negro");
	    	System.out.println("ANDO");
			
		} catch(IllegalArgumentException e){
//			exception.expect(IllegalArgumentException.class);
//			exception.expectMessage("ERROR COLOR PRIMARIO");
			Assert.fail("ERROR COLOR PRIMARIO");
	    	System.out.println("NO ANDO");
		}
	
	}
}