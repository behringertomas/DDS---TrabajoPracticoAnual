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
	  
	  @Test
	  public void primerTest() {
		  DatosPersonales eze = new DatosPersonales();
		  
		  eze.setEmail("ezequiel@gmail.com");
		  eze.setEdad(30);
		  eze.setNombre("Ezequiel");

//		  ---------------------- INSERT		  

		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(eze);
	        transaction.commit();
	        
	        // id no es nulo
	        
	        assertNotNull(eze.getId());
	        
	        // comparo identidad
	        DatosPersonales usuarioPersisted = entityManager.find(DatosPersonales.class, eze.getId());
	        assertEquals(usuarioPersisted, eze);
		  
	        
//		  EntityManagerHelper.beginTransaction();
//		  EntityManagerHelper.getEntityManager().persist(eze); //INSERT
//		  EntityManagerHelper.commit(); //commit inserta en la base!
		  
//		  EntityManagerHelper.getEntityManager().merge(eze); //UPDATE
		  
//		  ---------------------- SELECT
//		  Usuario ezeRecuperado = EntityManagerHelper
//				  .getEntityManager()
//				  .find(Usuario.class,0);
//		  System.out.println(ezeRecuperado.getNombre());
	  }
	
//	  @Test public void persistir1UsuarioTest(){ Usuario usuario = new Usuario();
//	  usuario.setNombre("Eze"); usuario.setApellido("Escobar");
//	  usuario.setTelefono(44889966); usuario.setLegajo(1527778);
//	  usuario.setFechaDeNacimiento(LocalDate.of(1995,10,14));
//	  
//	  EntityManagerHelper.beginTransaction();
//	  EntityManagerHelper.getEntityManager().persist(usuario);
//	  EntityManagerHelper.commit(); }
	  
//	  @Test public void recuperandoAEze(){ Usuario eze = (Usuario)
//	  EntityManagerHelper.createQuery("from Usuario where nombre = 'Eze'").
//	  getSingleResult(); Assert.assertEquals("Eze", eze.getNombre()); }
//	  
//	  @Test public void persistir2Aporte(){ 
//		  
//	  Topico topicoApunte = new Topico();
//	  topicoApunte.setNombre("Apunte");
//	  topicoApunte.setDescripcion("Colaboración de un apunte");
//	  
//	  EntityManagerHelper.beginTransaction();
//	  EntityManagerHelper.getEntityManager().persist(topicoApunte);
//	  EntityManagerHelper.commit();
//	  
//	  Aporte unAporte = new Aporte(); unAporte.setTopico(topicoApunte); Usuario eze
//	  = (Usuario)
//	  EntityManagerHelper.createQuery("from Usuario where nombre = 'eze'").
//	  getSingleResult(); unAporte.setUsuario(eze);
//	  unAporte.setNombre("Apunte de diseño");
//	  unAporte.setDescripcion("Taller ORM");
//	  
//	  EntityManagerHelper.beginTransaction();
//	  EntityManagerHelper.getEntityManager().persist(unAporte);
//	  EntityManagerHelper.commit(); }
//	 
}
