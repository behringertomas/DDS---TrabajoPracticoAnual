package web.controllers;

<<<<<<< HEAD
import java.util.List;

=======
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.imageio.ImageIO;
>>>>>>> Entrega5
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import TPZTBCS.Guardarropa;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import TPZTBCS.dao.UsuarioDao;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
<<<<<<< HEAD
=======
import web.EntityManagerSingleton;
>>>>>>> Entrega5
import web.Router;
import web.models.altaTiposModel;

public class altaCalzadoController extends MainController {

	private static Usuario currentUser;
<<<<<<< HEAD
    private static UsuarioDao uDao = new UsuarioDao();
=======
>>>>>>> Entrega5
	private static altaTiposModel model;
	private static final String ALTA_CALZADO = "/cliente/altaCalzado.hbs";
	private static final String ALTA_PRENDA = "/cliente/altaPrenda.hbs";
	private static final String PARTE = "Calzado";
	private static EntityManager entityManager;
	
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getAltaCalzado(),altaCalzadoController::load,engine);
        Spark.post(Router.getAltaCalzado(), altaCalzadoController::crearPrenda, engine);
        initModel();
<<<<<<< HEAD
    }   
=======
    }
>>>>>>> Entrega5
    
    private static void initModel() {
        model = new altaTiposModel();        
    }
    
    private static ModelAndView load(Request request, Response response) {
        sessionExist(request, response);
        String userSession = request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0, userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        model.setShowAlert(false);
        
        
        model.limpiarGuardarropas();
        
        List<Guardarropa> guardarropas = (List<Guardarropa>) currentUser.getListaGuardarropas();
<<<<<<< HEAD
        
        for(Guardarropa g : guardarropas) {
        	model.getGuardarropa().add(g);
=======
        int bit_premium = currentUser.getBit_premium();
        
        for(Guardarropa g : guardarropas) {
       	
       	if( (bit_premium == 0) && (g.getIdentificador().equals("DEFAULT"))) {} //si soy standar no agrego el default
       	else 
       	{
       		model.getGuardarropa().add(g);
       	}
     	
>>>>>>> Entrega5
        }

        return new ModelAndView(model, ALTA_CALZADO);
    }
    
    private static ModelAndView crearPrenda(Request request, Response response) {
//		usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
    	try {
<<<<<<< HEAD
=======
    		String url_imagen = request.queryParams("inputImagenPrenda");
    		
>>>>>>> Entrega5
    		String tipoPrenda = request.queryParams("calzado");
    		String material = request.queryParams("material");
    		String colorPrimario = request.queryParams("colorPrimario");
    		String guardarropa = request.queryParams("guardarropa");
    		if(request.queryParams("colorSecundario").equalsIgnoreCase("Ninguno")) {
<<<<<<< HEAD
    			Prenda prendaAPersistir = currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,currentUser.getGuardarropa(guardarropa));
    			persist(prendaAPersistir);
//    			bDao.persist(PrendaAPersistir); no se por que con esta linea no funciona
    		} else {
    			String colorSecundario = request.queryParams("colorSecundario");
    			Prenda prendaAPersistir = currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,colorSecundario,currentUser.getGuardarropa(guardarropa));
    			persist(prendaAPersistir);
//    			bDao.persist(PrendaAPersistir);
=======
    			Prenda prendaAPersistir = currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,currentUser.getGuardarropa(guardarropa),url_imagen);
    			persist(prendaAPersistir);
    		} else {
    			String colorSecundario = request.queryParams("colorSecundario");
    			Prenda prendaAPersistir = currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,colorSecundario,currentUser.getGuardarropa(guardarropa),url_imagen);
    			persist(prendaAPersistir);
    			
>>>>>>> Entrega5
    		}
    		
    	}
    	catch (Exception ex) {
            response.status(400);
            response.body("Ocurrio un error. Intenta nuevamente");
        }
    	
    	return new ModelAndView(model, ALTA_PRENDA);
    }
    
    public static void persist(Prenda prenda){
<<<<<<< HEAD
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    entityManager = factory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
=======
    	EntityManager entityManager = EntityManagerSingleton.getEntityManager();
	    EntityTransaction transaction = EntityManagerSingleton.getEntityManager().getTransaction();
>>>>>>> Entrega5
	    transaction.begin();
	    entityManager.persist(prenda);
	    transaction.commit();
    }
    
    public static Usuario getUsuarioViaEntity(int id) {
<<<<<<< HEAD
 	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
 	   entityManager = factory.createEntityManager();

 	   return entityManager.find(Usuario.class, id);
=======


 	   return EntityManagerSingleton.getEntityManager().find(Usuario.class, id);
>>>>>>> Entrega5
    }
    
}

