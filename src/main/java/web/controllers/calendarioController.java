package web.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TPZTBCS.Atuendo;
import TPZTBCS.Evento;
import TPZTBCS.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.models.altaEventoModel;
import web.models.calendarioModel;

public class calendarioController extends MainController{
	
	private static final String CALENDARIO = "/cliente/calendar.hbs";
	private static calendarioModel model;
	private static Usuario currentUser;
	private static EntityManager entityManager;
	
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getCalendarioPath(),calendarioController::showPagina,engine);
        initModel();
    }  
    private static ModelAndView showPagina(Request request, Response response) {
    	
    	String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        model.limpiarEventos();
        
        List<Evento> evento = (List<Evento>) currentUser.getListaEvento();
        
        for(Evento e : evento) {
        	model.getLstEvento().add(e);
        }
        return new ModelAndView (model, CALENDARIO);
    }
    
    private static void initModel() {
        model = new calendarioModel();
    }
    
    public static Usuario getUsuarioViaEntity(int id) {
  	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
  	   entityManager = factory.createEntityManager();

  	   return entityManager.find(Usuario.class, id);
     }
    
}
