package TPZTBCS.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {

    private static EntityManagerFactory emFactory = null;

    private static EntityManagerFactory getFactory() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory("db");
            }
        return emFactory;
    }

    public static EntityManager getEntityManager(){
        return getFactory().createEntityManager();
    }
}