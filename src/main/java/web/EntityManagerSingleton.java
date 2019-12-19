package web;

import javax.persistence.EntityManager;

import TPZTBCS.factory.EntityFactory;

public class EntityManagerSingleton {

	public static EntityManager entityManager = null;
	
	public static EntityManager getEntityManager(){
		
		if (entityManager == null) {
			EntityFactory factory = new EntityFactory();
			entityManager = factory.getEntityManager();
			
		}
		
		return entityManager;
	}
	
}
