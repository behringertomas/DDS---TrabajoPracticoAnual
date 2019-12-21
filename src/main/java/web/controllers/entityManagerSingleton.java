package web.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class entityManagerSingleton {
	
	private static EntityManager enManager= null; 
	
	public static EntityManager getEntityManager() {
		
		if (enManager == null) {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
			enManager = emFactory.createEntityManager();
		}
		return enManager;
	}
}
