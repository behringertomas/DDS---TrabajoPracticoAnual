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

import TPZTBCS.DatosPersonales;
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
	
	  @PersistenceContext(unitName = "db")
	  private static EntityManager entityManager;
	  
//	  @Test
//	  public void primerTest() {
//		  DatosPersonales eze = new DatosPersonales();
//		  
//		  eze.setEmail("ezequiel@gmail.com");
//		  eze.setEdad(30);
//		  eze.setNombre("Ezequiel");
//
////		  ---------------------- INSERT		  
//		    EntityTransaction transaction = entityManager.getTransaction();
//	        transaction.begin();
//	        entityManager.persist(eze);
//	        transaction.commit();
//	        
//	        // id no es nulo	 
//	        assertNotNull(eze.getId());	        
//	        // comparo identidad
//	        DatosPersonales usuarioPersisted = entityManager.find(DatosPersonales.class, eze.getId());
//	        assertEquals(usuarioPersisted, eze);
//	  }
	  @Test
	  public void primerTest() {
		  Usuario eze = new Usuario("Ezequiel",27,"ezequiel@gmail.com");
		  
//		  ---------------------- INSERT		  
		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(eze);
	        transaction.commit();
	        
	        // id no es nulo	 
	        assertNotNull(eze.getId());	        
	        // comparo identidad
	        Usuario usuarioPersisted = entityManager.find(Usuario.class, eze.getId());
	        assertEquals(usuarioPersisted, eze);
	  }
	  

	
}
