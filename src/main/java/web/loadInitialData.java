package web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import JsonPersistido.abrigoJson;
import JsonPersistido.abrigoSecundarioJson;
import JsonPersistido.factoresClimaticosJson;
import TPZTBCS.Usuario;

public class loadInitialData {

    public static void loadJsonAbrigos() {
    	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    EntityManager entityManager = factory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	   
    	abrigoJson abrigo1 = new abrigoJson("Campera", 13); 
    	abrigoJson abrigo2 = new abrigoJson("Sueter", 15);
    	abrigoJson abrigo3 = new abrigoJson("Buzo", 13);
    	abrigoJson abrigo4 = new abrigoJson("Campera Impermeable", 5);
    	abrigoJson abrigo5 = new abrigoJson("Remera cuello redondo manga corta", 5);
    	abrigoJson abrigo6 = new abrigoJson("Remera cuello redondo manga larga", 8);
    	abrigoJson abrigo7 = new abrigoJson("Remera escote V manga corta", 5);
    	abrigoJson abrigo8 = new abrigoJson("Remera escote V manga larga", 8);
	    transaction.begin();
	    entityManager.persist(abrigo1);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo2);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo3);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo4);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo5);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo6);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo7);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo8);
	    transaction.commit();
    	
    	abrigoSecundarioJson abrigoSecundario1 = new abrigoSecundarioJson("Bufanda","Cuello", 10);
    	abrigoSecundarioJson abrigoSecundario2 = new abrigoSecundarioJson("Gorro","Cabeza", 10);
    	abrigoSecundarioJson abrigoSecundario3 = new abrigoSecundarioJson("Guantes","Manos", 10);
    	abrigoSecundarioJson abrigoSecundario4 = new abrigoSecundarioJson("Cuello Polar","Cuello", 10);
    	abrigoSecundarioJson abrigoSecundario5 = new abrigoSecundarioJson("Gorra Sol","Cabeza", 0);
	    transaction.begin();
	    entityManager.persist(abrigoSecundario1);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario2);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario3);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario4);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario5);
	    transaction.commit();
    	
    	factoresClimaticosJson factoresClimaticos1 = new factoresClimaticosJson("Gorra de Sol","Sol");
    	factoresClimaticosJson factoresClimaticos2 = new factoresClimaticosJson("Lentes de Sol","Sol");
    	factoresClimaticosJson factoresClimaticos3 = new factoresClimaticosJson("Campera Impermeable","Lluvia");
    	factoresClimaticosJson factoresClimaticos4 = new factoresClimaticosJson("Paraguas","Lluvia");
	    transaction.begin();
	    entityManager.persist(factoresClimaticos1);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(factoresClimaticos2);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(factoresClimaticos3);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(factoresClimaticos4);
	    transaction.commit();
    	
    	
    }
    
    public static void loadUsuarios() throws Exception {
    	
	    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    	EntityManager entityManager = factory.createEntityManager();
	    	EntityTransaction transaction = entityManager.getTransaction();
    	
    	
    	//	**** USUARIO STANDARD ****
		  Usuario aroco = new Usuario("aroco","aroco@gmail.com","123456","Alejandro Roco",21,0); 
		  String nombreGuardarropaDeAroco = "Guardarropa de Aroco"; 
		  
		  aroco.CrearGuardarropa(nombreGuardarropaDeAroco,16);
		  aroco.construirPrenda("Parte Superior","Remera cuello redondo manga corta", "Algodon", "Negro", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Parte Superior","Remera escote V manga corta", "Lycra", "Blanco", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Parte Superior","Musculosa", "Lycra", "Amarillo", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Parte Superior","Campera", "Cuero", "Blanco", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Parte Superior","Sueter", "Poliester", "Blanco", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Parte Inferior","Bermuda", "Jean", "Celeste", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Parte Inferior","Pantalón largo", "Nylon", "Gris", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Calzado","Zapatillas", "Nylon", "Bordo", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  aroco.construirPrenda("Calzado","Zapatos", "Cuero", "Negro", aroco.getGuardarropa(nombreGuardarropaDeAroco), "");
		  
		  
		  
	    //	**** USUARIO PREMIUM ****
		  Usuario jazul = new Usuario("jazul","jazul@gmail.com","123456","Julieta Azul",21,1);
		  String nombreGuardarropaDeJazul = "Guardarropa de Jazul";
		  
		  jazul.CrearGuardarropa(nombreGuardarropaDeJazul);//ES PREMIUM, NO TIENE LIMITE, ENTONCES NO LE PASO LA CANT
		  jazul.construirPrenda("Parte Superior","Remera cuello redondo manga larga", "Lycra", "Amarillo", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Parte Superior","Remera escote V manga larga", "Algodon", "Blanco", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Parte Superior","Musculosa", "Lycra", "Verde", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Parte Superior","Sueter", "Poliester", "Gris", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Parte Superior","Buzo", "Algodon", "Blanco", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Parte Inferior","Pollera", "Seda", "Negro", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Parte Inferior","Calza", "Nylon", "Negro", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Calzado","Zapatos", "Cuero", "Negro", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  jazul.construirPrenda("Calzado","Sandalias", "Cuero", "Negro", jazul.getGuardarropa(nombreGuardarropaDeJazul), "");
		  
	      transaction.begin();
	      entityManager.persist(aroco);
	      entityManager.persist(jazul);
	      transaction.commit();
		 	  

    }
    	
    
    
}
