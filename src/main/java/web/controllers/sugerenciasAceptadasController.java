package web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TPZTBCS.Atuendo;
import TPZTBCS.Evento;
import TPZTBCS.Guardarropa;
import TPZTBCS.Usuario;
import TPZTBCS.dao.UsuarioDao;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.models.AlertModel;
import web.models.listadoGuardarropaModel;
import web.models.sugerenciasAceptadasModel;
import web.models.views.listadoGuardarropaTable;
import web.models.views.listadoPrendasTable;
import web.models.views.sugerenciasAceptadasTable;

public class sugerenciasAceptadasController extends MainController {

	private static EntityManager entityManager;
	private static final String SUGERENCIAS_ACEPTADAS = "cliente/sugerenciasAceptadas.hbs";
	private static sugerenciasAceptadasModel model;
  
    
    private static Usuario currentUser;
    private static UsuarioDao uDao = new UsuarioDao();
    
    
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getSugerenciasAceptadas(), sugerenciasAceptadasController::fillSugerenciasAceptadasTable, engine);
        initModel();
        
    }
    
    private static void initModel() {

        model = new sugerenciasAceptadasModel();
    }
    
    
    private static ModelAndView fillSugerenciasAceptadasTable(Request request, Response response) {

    	getCurrentClient(request);
        sessionExist(request, response);
        
        List<sugerenciasAceptadasTable> table = new ArrayList<sugerenciasAceptadasTable>();
        List<Atuendo> atuendo = currentUser.getHistorialAtuendos();

       
       for(Atuendo a : atuendo) //pide hasta 2 guardarropas.
       {
    	   List<Integer> lstPuntajesAtuendo = a.getListaPuntajes();
    	   for(Integer puntaje : lstPuntajesAtuendo) 
    	   {
    		   sugerenciasAceptadasTable row = new sugerenciasAceptadasTable();
    		   row.setIndex(a.getID());
    		   row.setPuntaje(puntaje);
    		   table.add(row);
    		   
    		   model.setSugerenciasAceptadasTable(table);
    	   }
    
       }
       
       return new spark.ModelAndView(model,SUGERENCIAS_ACEPTADAS);
    }
    
    private static void getCurrentClient(Request request) {
        String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
//        currentUser = uDao.getUsuario(userID);
        currentUser = getUsuarioViaEntity(userID);
        
    }
    
    public static Usuario getUsuarioViaEntity(int id) {
 	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
 	   entityManager = factory.createEntityManager();

 	   return entityManager.find(Usuario.class, id);
    }
    
}
