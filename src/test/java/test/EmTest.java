package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

import TPZTBCS.DatosPersonales;
import TPZTBCS.Guardarropa;
import TPZTBCS.Usuario;
import db.EntityManagerHelper;



//package test;
//
//import db.EntityManagerHelper;
//import entities.Aporte;
//import entities.BuenaReputacion;
//import entities.Topico;
//import entities.Usuario;
//import org.junit.Assert;
//import org.junit.Test;
//import java.time.LocalDate;
//
public class EmTest{

	@Before
    public void before() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST_PERSISTENCE_UNIT");
        entityManager = factory.createEntityManager();
    }
	
	  private static EntityManager entityManager;
	  
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
		  Guardarropa guardarropa1 = new Guardarropa("Guardarropa Primaveral",10);
		  tomas.agregarGuardarropas(guardarropa1);
		  
//		  ---------------------- INSERT		  
		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(tomas);
	        transaction.commit();
	         
	        assertNotNull(tomas.getId());
	        assertNotNull(guardarropa1.getID());
	        Guardarropa guardarropaPersisted = entityManager.find(Guardarropa.class, guardarropa1.getID());
	        
	        assertEquals(Iterables.get(tomas.getListaGuardarropas(), 0),guardarropaPersisted);
//	        Iterables.get(yourC, indexYouWant)
	        
	  }
	  
	  @Test
	  public void TestEvento() {
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

	
}
