package web.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TPZTBCS.Atuendo;
import TPZTBCS.Evento;
import TPZTBCS.Usuario;
import TPZTBCS.dao.EventoDao;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.EntityManagerSingleton;
import web.Router;
import web.models.altaEventoModel;
import web.models.calendarioModel;
import web.models.puntajePrendasModel;

public class calendarioController extends MainController{
	
	  private static Usuario currentUser;
	  private static EntityManager entityManager;
	  private static EventoDao eDao;
	  private static final String CALENDARIO = "/cliente/calendario.hbs";
	
	    public static void init() {
	        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
	        Spark.get(Router.getCalendarioPath(), calendarioController::mostrarEventos,engine);
	    }  
	  
	  

	  
	  public static ModelAndView mostrarEventos(Request req, Response res) {
		  
	    	String userSession =  req.session().attribute("user");
	        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
	        currentUser = getUsuarioViaEntity(userID);

	        List<Evento> eventos = (List<Evento>) currentUser.getListaEvento();
	        HashMap<String, Object> model = new HashMap();
	        model.put("eventos", eventos);

	        return new ModelAndView(model, CALENDARIO);
	    }


	    public static ModelAndView mostrarEvento(Request req, Response res) {
	        int id = Integer.parseInt(req.params("id"));
	        Evento evento = eDao.getEvento(id); 
	       
	        HashMap<String, Object> model = new HashMap();
	        model.put("evento", evento);
	       
	        // FALTA PONER EL EVENTO.HBS!! un hbs aparte con solo el evento. preguntarle a german
	        return new ModelAndView(model, "evento.hbs");
	    }

//	    public ModelAndView showFormularioNuevoEvento(Request req, Response res) {
//	        Usuario usuario = RepositorioDeUsuarios.getInstance().getUsuario(LoginValidator.getAuthenticatedUser(req));
//	        HashMap<String, Object> model = new HashMap();
//	        model.put("modoOscuroActivado", usuario.isModoOscuroActivado());
//	        return new ModelAndView(model, "nuevoevento.hbs");
//	    }

//	    public ModelAndView crearEvento(Request req, Response res) {
//
//	        Long userId = LoginValidator.getAuthenticatedUser(req);
//	        Usuario usuario = RepositorioDeUsuarios.getInstance().getUsuario(userId);
//
//	        String descripcion = req.queryParams("descripcion");
//
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//	        String f = req.queryParams("fecha").replace('T', ' ');
//	        LocalDateTime fecha = LocalDateTime.parse(f , formatter);
//
//
//	        Evento evento = new Evento(fecha,ciudad,descripcion);
//	        
//
//	        res.redirect("/eventos");
//	        return null;
//	    }
	
	
//	private static calendarioModel model;
	
	
//	
//    public static void init() {
//        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
//        Spark.get(Router.getCalendarioPath(),calendarioController::showPagina,engine);
//        initModel();
//    }  
//    private static ModelAndView showPagina(Request request, Response response) {
//    	
//    	String userSession =  request.session().attribute("user");
//        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
//        currentUser = getUsuarioViaEntity(userID);
//        model.limpiarEventos();
//        
//        List<Evento> evento = (List<Evento>) currentUser.getListaEvento();
//        
//        for(Evento e : evento) {
//        	model.getLstEvento().add(e);
//        }
//        return new ModelAndView (model, CALENDARIO);
//    }
//    
//    private static void initModel() {
//        model = new calendarioModel();
//    }
//    
    public static Usuario getUsuarioViaEntity(int id) {

  	   return EntityManagerSingleton.getEntityManager().find(Usuario.class, id);
     }
	
	
	
    
}
