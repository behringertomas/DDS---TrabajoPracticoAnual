import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.startsWith;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void ExcepcionPrendaYaSeEncuentraEnUnGuardarropa() throws Exception
	{
			Usuario usuario = new Usuario();
			Prenda prenda = usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Verde");
			Guardarropa guardarropa = new Guardarropa("Guardaropa Primavera");
			guardarropa.agregarAGuardarropas(prenda);
			thrown.expect(Exception.class);
			thrown.expectMessage("PRENDA YA SE ENCUENTRA EN UN GUARDARROPA");
			guardarropa.agregarAGuardarropas(prenda);
	}
	
	@Test 
	public void ExcepcionNoSePuedenCompartirPrendas() throws Exception
	{
			Usuario usuario = new Usuario();
			Prenda prenda = usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Verde");
			Guardarropa guardarropa1 = new Guardarropa("Guardaropa Primavera");
			Guardarropa guardarropa2 = new Guardarropa("Guardaropa Verano");
			
			guardarropa1.agregarAGuardarropas(prenda);
			thrown.expect(Exception.class);
			thrown.expectMessage("PRENDA YA SE ENCUENTRA EN UN GUARDARROPA");
			guardarropa2.agregarAGuardarropas(prenda);
	}
	
	@Test 
	public void ExcepcionColorSecundarioErroneo() throws Exception
	{
			Usuario usuario = new Usuario();
			thrown.expect(Exception.class);
			thrown.expectMessage("ERROR COLOR SECUNDARIO");
			usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Azulado");
	}
	
	@Test 
	public void ExcepcionColorPrimarioErroneo() throws Exception
	{
			Usuario usuario = new Usuario();
			thrown.expect(Exception.class);
			thrown.expectMessage("ERROR COLOR PRIMARIO");
			usuario.construirPrenda("Parte Superior","Remera", "Tela", "Azulado", "Negro");
	}

	
	@Test 
	public void ExcepcionConsistenciaPrenda() throws Exception
	{
			Usuario usuario = new Usuario();
			thrown.expect(Exception.class);
			thrown.expectMessage("ERROR MATERIAL");
			usuario.construirPrenda("Parte Superior","Remera", "Oro", "Rojo", "Negro");

	}
	
	@Test 
	public void ExcepcionMismoColor() throws Exception
	{
			Usuario usuario = new Usuario();
			thrown.expect(Exception.class);
			thrown.expectMessage("COLOR PRIMARIO Y SECUNDARIO IGUALES");
			usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Rojo");

	}
	
	
	@Test 
	public void ExcepcionParteEquivocada() throws Exception
	{
			Usuario usuario = new Usuario();
			thrown.expect(Exception.class);
			thrown.expectMessage("NO EXISTE PARTE");
			usuario.construirPrenda("Parte Inexistente","Remera", "Tela", "Rojo", "Negro");
	}
	
	@Test 
	public void ExcepcionInconsistenciaDeTipo() throws Exception
	{
			Usuario usuario = new Usuario();
			thrown.expect(Exception.class);
			thrown.expectMessage("ERROR TIPO");
			usuario.construirPrenda("Calzado","Remera", "Tela", "Rojo", "Negro");
	}
	
	
	@Test 
	public void ExcepcionAtuendoIncompletoQueMePongoTodosLosGuardarropas() throws Exception
	{
			Usuario usuario = new Usuario();
			Guardarropa guardarropa = new Guardarropa("Guardarropa Verano");
			
			Prenda prenda0  =usuario.construirPrenda("Parte Superior","Camisa", "Tela", "Rojo", "Negro");
			Prenda prenda1  =usuario.construirPrenda("Parte Inferior","Short", "Algodon", "Rojo", "Negro");
			Prenda prenda2  =usuario.construirPrenda("Calzado","Zapato", "Cuero", "Rojo", "Negro");
			
			usuario.agregarPrendaAGuardarropas(guardarropa,prenda0);
			usuario.agregarPrendaAGuardarropas(guardarropa,prenda1);
			usuario.agregarPrendaAGuardarropas(guardarropa,prenda2);
			
			thrown.expect(Exception.class);
			thrown.expectMessage("ERROR SIN ATUENDOS");
			usuario.queMePongoATodosLosGuardarropas();
			
	}
	
}