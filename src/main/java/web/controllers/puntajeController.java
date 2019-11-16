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
import web.models.AlertModel;
import web.models.puntajePrendasModel;
import web.models.views.listadoPrendasTable;
import web.models.views.modificacionPuntajes;

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
	 private static AlertModel alert = new AlertModel(false,"",false);
	
	private static List<Prenda> lista_prendas_totales = new ArrayList<>();

    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getHistorialCalificacionesPath(), puntajeController::load, engine);
        Spark.post(Router.getHistorialCalificacionesPath(), puntajeController::modificar, engine);
        initModel();

    }
    
    private static void initModel() {
        model = new puntajePrendasModel();
    }
    
    private static ModelAndView load(Request request, Response response) {
    	
    	String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        
        model.setShowAlert(false);
        
        model.limpiar_prendas();
        
        try
        {
            alert.setHideAlert();
            fillListadoAtuendosTable(request,response);
            return new spark.ModelAndView(model,HISTORIAL_CALIFICACIONES);
        }
    catch(Exception e)
        {
            alert.setShowAlertWithMessage("Error");
            return new ModelAndView(alert, HISTORIAL_CALIFICACIONES);
        }

    }
        
//        List<Atuendo> lista_atuendo = currentUser.getHistorialAtuendos();
//        
//        lista_atuendo.forEach(atuendo -> atuendo.getPrendas().addAll(lista_prendas_totales));
//        
//        lista_prendas_totales.forEach(d -> model.getPrendas().add(d));

    private static void fillListadoAtuendosTable(Request request, Response response) {

    	lista_prendas_totales.clear();
        List<modificacionPuntajes> table = new ArrayList<modificacionPuntajes>();        
//        es la vista
        List<Atuendo> lista_atuendo = new ArrayList<Atuendo>();
        
        lista_atuendo = currentUser.getHistorialAtuendos();

        lista_atuendo.forEach(atuendo -> lista_prendas_totales.addAll(atuendo.getPrendas()));
        
       
        
       try{
	       for(int i = 0; i < lista_prendas_totales.size(); i++)
	       {
	    	   modificacionPuntajes row = new modificacionPuntajes();
	    	   
	    	   row.setColor_primario(lista_prendas_totales.get(i).getColorPrimario());
	    	   if(!lista_prendas_totales.get(i).getColorSecundario().isEmpty()) {
	    		   row.setColor_secundario(lista_prendas_totales.get(i).getColorSecundario());
	    	   } else row.setColor_secundario("Sin Color Secundario");
	    	   row.setMaterial(lista_prendas_totales.get(i).getMaterial());
	    	   row.setParte(lista_prendas_totales.get(i).getParte());
	    	   row.setTipo(lista_prendas_totales.get(i).getTipo());

	           table.add(row);
	       }
       }
       catch(Exception e){}

       model.setTable(table);
       
    }

    private static ModelAndView modificar(Request request, Response response) {
    
    	
        return new ModelAndView(model, HISTORIAL_CALIFICACIONES);
    }
    
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
