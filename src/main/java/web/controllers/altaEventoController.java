package web.controllers;

<<<<<<< HEAD
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;

>>>>>>> Entrega5
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
<<<<<<< HEAD
import web.Router;
import web.models.AlertModel;
import web.models.altaEventoModel;
=======
import web.EntityManagerSingleton;
import web.Router;
import web.models.AlertModel;
import web.models.altaEventoModel;
import java.util.Date;
>>>>>>> Entrega5

public class altaEventoController extends MainController{

	private static EntityManager entityManager;
	private static final String ALTA_EVENTO = "cliente/altaEvento.hbs";
	private static altaEventoModel model;
    private static Usuario currentUser;
    private static AlertModel alert = new AlertModel(false,"",false);
<<<<<<< HEAD
=======
    private static SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
>>>>>>> Entrega5
    
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
    
<<<<<<< HEAD
    private static ModelAndView crearEvento(Request request, Response response) {
    	String descripcion = request.queryParams("descripcion");
    	String ciudad = request.queryParams("ciudad");
    	int anio = Integer.parseInt(request.queryParams("anio"));
    	int mes = Integer.parseInt(request.queryParams("mes"));
    	int dia = Integer.parseInt(request.queryParams("dia"));
=======
    private static ModelAndView crearEvento(Request request, Response response) throws ParseException {
    	String descripcion = request.queryParams("descripcion");
    	String ciudad = request.queryParams("ciudad");
    	String fecha = request.queryParams("fechaEvento");
    	// SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss")

>>>>>>> Entrega5
    	int hora = Integer.parseInt(request.queryParams("hora"));
    	int minutos = Integer.parseInt(request.queryParams("minutos"));
    	int cadaCuanto = Integer.parseInt(request.queryParams("cadaCuanto"));
    	
<<<<<<< HEAD
    	if(cadaCuanto == 0) {
    		Evento evento = currentUser.crearEvento(descripcion, ciudad, anio, mes, dia, hora, minutos);
    		persist(evento);
    	} else {
    		Evento evento = currentUser.crearEvento(descripcion, ciudad, anio, mes, dia, hora, minutos,cadaCuanto);
    		persist(evento);
=======
    	String fecha_concatenada = fecha + " " + hora + ":" + minutos + ":00";
    	SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	Date fecha_evento = formatterDate.parse(fecha_concatenada);

    	if(cadaCuanto == 0) {
	    	Evento evento = currentUser.crearEvento(descripcion, ciudad, fecha_evento, hora, minutos);
	    	persist(evento);
    	} else {
	    	Evento evento = currentUser.crearEvento(descripcion, ciudad, fecha_evento, hora, minutos,cadaCuanto);
	    	persist(evento);
>>>>>>> Entrega5
    	}
    	
    	return new ModelAndView (model, ALTA_EVENTO);
    }
    
    public static void persist(Evento evento){
<<<<<<< HEAD
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    entityManager = factory.createEntityManager();
=======
    	EntityManager entityManager = EntityManagerSingleton.getEntityManager();

>>>>>>> Entrega5
	    EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    entityManager.persist(evento);
	    transaction.commit();
<<<<<<< HEAD
=======

>>>>>>> Entrega5
    }
    
    private static void initModel() {
        model = new altaEventoModel();
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
