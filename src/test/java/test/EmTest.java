package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

import TPZTBCS.DatosPersonales;
import TPZTBCS.Guardarropa;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import db.EntityManagerHelper;

public class EmTest{
	
	
	private static EntityManager entityManager;


	@Before
    public void before() {
		
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST_PERSISTENCE_UNIT");
        entityManager = factory.createEntityManager();
    }
	
	  
	  @Test
	  public void TestUsuario() {
		  Usuario eze = new Usuario("Ezequiel",27,"ezequiel@gmail.com");
		  	  
		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(eze);
	        transaction.commit();	
	        	 
	        assertNotNull(eze.getId());	        

	        Usuario usuarioPersisted = entityManager.find(Usuario.class, eze.getId());
	        assertEquals(usuarioPersisted, eze);
	  }
	  
	  @Test
	  public void TestGuardarropa() {
		  Usuario tomas = new Usuario("Tomas",21,"behringertomas@gmail.com");
		  tomas.CrearGuardarropa("Guardarropa Primaveral",10);

		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(tomas);
	        transaction.commit();
	         
	        assertNotNull(tomas.getId());
	        assertNotNull(tomas.getGuardarropa("Guardarropa Primaveral").getID());
	        Guardarropa guardarropaPersisted = entityManager.find(Guardarropa.class, tomas.getGuardarropa("Guardarropa Primaveral").getID());
	        
	        assertEquals(tomas.getGuardarropa("Guardarropa Primaveral"),guardarropaPersisted);
	        
	        
	  }
	  
	  @Test
	  public void TestEvento() throws Exception {
		  Usuario tomas = new Usuario("Tomas",21,"behringertomas@gmail.com");
		  tomas.crearEvento("Fiesta de Gala", "Paris", 2021, 10, 7, 15, 26);
		  tomas.crearEvento("Fiesta de Disfraces", "Buenos Aires", 2020, 10, 7, 15, 26);

			
			
		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(tomas);
	        transaction.commit();
	        
	        assertNotNull(tomas.getId());
	        Usuario usuarioPersisted = entityManager.find(Usuario.class, tomas.getId());

	        assertEquals(usuarioPersisted.getEvento("Fiesta de Gala").getDescripcion(),"fiesta de gala");
	        assertEquals(usuarioPersisted.getEvento("Fiesta de Disfraces").getDescripcion(),"fiesta de disfraces");
	  }
	  
	  @Test
	  public void TestPrenda() throws Exception {
		  Usuario tomas = new Usuario("Tomas",21,"behringertomas@gmail.com");
		  tomas.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
		  tomas.CrearGuardarropa("Guardarropa Primaveral",10);
		  tomas.asignarPrenda(tomas.getGuardarropa("Guardarropa Primaveral"), tomas.getGuardarropa("DEFAULT").getAllPrendas().get(0));
		  
		  EntityTransaction transaction = entityManager.getTransaction();
	      transaction.begin();
	      entityManager.persist(tomas);
	      transaction.commit();
	        
	      assertNotNull(tomas.getId());
	      Usuario usuarioPersisted = entityManager.find(Usuario.class, tomas.getId());
	        
        assertEquals(usuarioPersisted.getGuardarropa("Guardarropa Primaveral").getAllPrendas().get(0).getTipo(),"Remera");
	  }
	  
	  @Test
	  public void TestAtuendo() throws Exception {
		  Usuario tomas = new Usuario("Tomas",21,"behringertomas@gmail.com");
		  tomas.CrearGuardarropa("Guardarropa Primaveral",10000);
		  
		  
		  
			tomas.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
			tomas.construirPrenda("Parte Inferior","Pantalon Largo", "Jean", "Azul", "Negro");
			tomas.construirPrenda("Calzado","Runners", "Algodon", "Rojo", "Negro");
			tomas.construirPrenda("Accesorio","Pulsera", "Plata", "Rojo", "Negro");
		  
		    tomas.asignarPrenda(tomas.getGuardarropa("Guardarropa Primaveral"), tomas.getGuardarropa("DEFAULT").getAllPrendas().get(0));
		    tomas.asignarPrenda(tomas.getGuardarropa("Guardarropa Primaveral"), tomas.getGuardarropa("DEFAULT").getAllPrendas().get(1));
		    tomas.asignarPrenda(tomas.getGuardarropa("Guardarropa Primaveral"), tomas.getGuardarropa("DEFAULT").getAllPrendas().get(2));
		    //tomas.asignarPrenda(tomas.getGuardarropa("Guardarropa Primaveral"), tomas.getGuardarropa("DEFAULT").getAllPrendas().get(3));
		    //tomas.crearEvento("Fiesta de Gala", "Paris", 2018, 10, 7, 15, 26);
		    
		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(tomas);
	        transaction.commit();
	        
	        assertNotNull(tomas.getId());
	        Usuario usuarioPersisted = entityManager.find(Usuario.class, tomas.getId());

	        
	  }

	
}	
