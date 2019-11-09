package web.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import TPZTBCS.Evento;
import TPZTBCS.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.models.AlertModel;
import web.models.altaEventoModel;

public class altaEventoController extends MainController{

	private static EntityManager entityManager;
	private static final String ALTA_EVENTO = "cliente/altaEvento.hbs";
	private static altaEventoModel model;
    private static Usuario currentUser;
    private static AlertModel alert = new AlertModel(false,"",false);
    
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getAltaEventoPath(),altaEventoController::showPagina,engine);
        Spark.post(Router.getAltaEventoPath(), altaEventoController::crearEvento, engine);
        initModel();
    }   
    
    private static ModelAndView showPagina(Request request, Response response) {
    	getCurrentClient(request);
        sessionExist(request, response);
        model.setShowAlert(false);
        return new ModelAndView (model, ALTA_EVENTO);
    }
    
    private static void getCurrentClient(Request request) {
        String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
//        currentUser = uDao.getUsuario(userID);
        currentUser = getUsuarioViaEntity(userID);
        
    }
    
    private static ModelAndView crearEvento(Request request, Response response) {
    	String descripcion = request.queryParams("descripcion");
    	String ciudad = request.queryParams("ciudad");
    	int anio = Integer.parseInt(request.queryParams("anio"));
    	int mes = Integer.parseInt(request.queryParams("mes"));
    	int dia = Integer.parseInt(request.queryParams("dia"));
    	int hora = Integer.parseInt(request.queryParams("hora"));
    	int minutos = Integer.parseInt(request.queryParams("minutos"));
    	int cadaCuanto = Integer.parseInt(request.queryParams("cadaCuanto"));
    	
    	if(cadaCuanto == 0) {
    		Evento evento = currentUser.crearEvento(descripcion, ciudad, anio, mes, dia, hora, minutos);
//    		persist(evento);
    	} else {
    		Evento evento = currentUser.crearEvento(descripcion, ciudad, anio, mes, dia, hora, minutos,cadaCuanto);
//    		persist(evento);
    	}
    	
    	return new ModelAndView (model, ALTA_EVENTO);
    }
    
    public static void persist(Evento evento){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    entityManager = factory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    entityManager.persist(evento);
	    transaction.commit();
    }
    
    private static void initModel() {
        model = new altaEventoModel();
    }
    
    public static Usuario getUsuarioViaEntity(int id) {
 	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
 	   entityManager = factory.createEntityManager();

 	   return entityManager.find(Usuario.class, id);
    }
}
