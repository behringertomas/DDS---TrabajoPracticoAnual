package web.controllers;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TPZTBCS.Atuendo;
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
import web.models.puntajePrendasModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class puntajeController extends MainController {

	
    private static final String HISTORIAL_CALIFICACIONES = "/cliente/listadoPrendasYCalificacion.hbs";
    private static puntajePrendasModel model;
    private static Usuario currentUser;
    private static UsuarioDao uDao = new UsuarioDao();
	private static EntityManager entityManager;
	
	private static List<Prenda> lista_prendas_totales = new ArrayList<>();

    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getHistorialCalificacionesPath(), puntajeController::load, engine);
        Spark.post(Router.getHistorialCalificacionesPath(), puntajeController::modificar, engine);
     //   Spark.delete(Router.bajaDispositivoPath(), SeleccionDispositivoController::delete, engine);
        initModel();

    }
    
    private static void initModel() {
        model = new puntajePrendasModel();
    }
    
    private static ModelAndView load(Request request, Response response) {
        sessionExist(request, response);
        getCurrentClient(request);
        model.setShowAlert(false);
        
        List<Atuendo> lista_atuendo = currentUser.getHistorialAtuendos();
        
        lista_atuendo.forEach(x -> x.getPrendas().addAll(lista_prendas_totales));
        
        model.limpiar_prendas();
        lista_prendas_totales.forEach(d -> model.getPrendas().add(d));
        
        return new ModelAndView(model, HISTORIAL_CALIFICACIONES);
    }

    private static ModelAndView modificar(Request request, Response response) {
    
    	
        return new ModelAndView(model, HISTORIAL_CALIFICACIONES);
    }
    
    
    
    
//    public void armar_prendasTotales(Guardarropa listaGuardarropas) 
//    {
//    	listaGuardarropas.forEach(g -> g.getAllPrendas());
//    }
//    
    
    
    
    private static void getCurrentClient(Request request) {
        String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        
    }

    public static Usuario getUsuarioViaEntity(int id) {
 	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
 	   entityManager = factory.createEntityManager();

 	   return entityManager.find(Usuario.class, id);
    }
    


}
