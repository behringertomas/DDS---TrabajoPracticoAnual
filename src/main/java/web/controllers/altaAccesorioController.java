package web.controllers;

import java.util.List;

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
import web.Router;
import web.models.altaTiposModel;

public class altaAccesorioController extends MainController {

	private static Usuario currentUser;
    private static UsuarioDao uDao = new UsuarioDao();
	private static altaTiposModel model;
	private static final String ALTA_ACCESORIO = "/cliente/altaAccesorio.hbs";
	private static final String ALTA_PRENDA = "/cliente/altaPrenda.hbs";
	private static final String PARTE = "Accesorio";
	private static EntityManager entityManager;
	
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getAltaAccesorio(),altaAccesorioController::load,engine);
        Spark.post(Router.getAltaAccesorio(), altaAccesorioController::crearPrenda, engine);
        initModel();
    }   
    
    private static void initModel() {
        model = new altaTiposModel();
    }
    
    private static ModelAndView load(Request request, Response response) {
        sessionExist(request, response);
        String userSession = request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0, userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        model.setShowAlert(false);
        
        model.getGuardarropa().clear();
        
        List<Guardarropa> guardarropa = (List<Guardarropa>) currentUser.getListaGuardarropas();
        
        for(Guardarropa g : guardarropa) {
        	model.getGuardarropa().add(g);
        }
        return new ModelAndView(model, ALTA_ACCESORIO);
    }
    
    private static ModelAndView crearPrenda(Request request, Response response) {
//		usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
    	try {
    		String tipoPrenda = request.queryParams("accesorio");
    		String material = request.queryParams("material");
    		String colorPrimario = request.queryParams("colorPrimario");
    		String guardarropa = request.queryParams("guardarropa");
    		if(request.queryParams("colorSecundario").equalsIgnoreCase("Ninguno")) {
    			Prenda prendaAPersistir = currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,currentUser.getGuardarropa(guardarropa));
    			persist(prendaAPersistir);
//    			bDao.persist(PrendaAPersistir); no se por que con esta linea no funciona
    		} else {
    			String colorSecundario = request.queryParams("colorSecundario");
    			Prenda prendaAPersistir = currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,colorSecundario,currentUser.getGuardarropa(guardarropa));
    			persist(prendaAPersistir);
//    			bDao.persist(PrendaAPersistir);
    		}
    		
    	}
    	catch (Exception ex) {
            response.status(400);
            response.body("Ocurrio un error. Intenta nuevamente");
        }
    	
    	return new ModelAndView(model, ALTA_PRENDA);
    }
    
    public static void persist(Prenda prenda){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    entityManager = factory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    entityManager.persist(prenda);
	    transaction.commit();
    }
    
    public static Usuario getUsuarioViaEntity(int id) {
  	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
  	   entityManager = factory.createEntityManager();

  	   return entityManager.find(Usuario.class, id);
     }
    
}

