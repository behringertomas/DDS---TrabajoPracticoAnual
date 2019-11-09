package web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TPZTBCS.Atuendo;
import TPZTBCS.Evento;
import TPZTBCS.Guardarropa;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import web.Router;
import web.models.AlertModel;
import web.models.listadoGuardarropaModel;
import web.models.sugerenciasModel;
import web.models.views.listadoGuardarropaTable;
import web.models.views.listadoPrendasTable;
import web.models.views.sugerenciaTable;
import spark.Route;


public class sugerenciasController extends MainController{

	private static final String SUGERENCIAS = "cliente/sugerencias.hbs";
	private static EntityManager entityManager;
	private static sugerenciasModel model;
	private static Usuario currentUser;
	private static AlertModel alert = new AlertModel(false,"",false);
	
	public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getSugerencias(), sugerenciasController::showPagina, engine);
        Spark.post(Router.getSugerencias(), sugerenciasController::showPrimerSugerencia, engine);
        initModel();
    }
	
    private static void initModel() {
       model = new sugerenciasModel();
    }
    
    private static ModelAndView showPagina(Request request, Response response) {
    	getCurrentClient(request);
        sessionExist(request, response);
        model.setShowAlert(false);
        return new ModelAndView (model, SUGERENCIAS);
    }
    
    private static ModelAndView showPrimerSugerencia(Request request, Response response) {
        sessionExist(request, response);

        String userSession = request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0, userSession.indexOf("-")));

        currentUser = getUsuarioViaEntity(userID);

        try
            {
                alert.setHideAlert();
                fillSugerenciaTable(request,response);
                return new spark.ModelAndView(model,SUGERENCIAS);
            }
        catch(Exception e)
            {
                alert.setShowAlertWithMessage("No se pudo obtener la lista de prendas.");
                return new ModelAndView(alert, SUGERENCIAS);
            }

        }
    
    private static void fillSugerenciaTable(Request request, Response response) {

    	String eventoABuscar = request.queryParams("buscar");
        List<sugerenciaTable> table = new ArrayList<sugerenciaTable>();  
        
        Evento eventoSeleccionado = currentUser.getEvento(eventoABuscar);
        eventoSeleccionado.run();
        Atuendo atuendoElegido = eventoSeleccionado.getAtuendoElegido();
        List<Prenda> lstPrendas = atuendoElegido.getPrendas();
        
        try{
 	       for(int i = 0; i < table.size(); i++)
 	       {
 	    	  sugerenciaTable row = new sugerenciaTable();
 	    	   
 	    	   row.setColor_primario(lstPrendas.get(i).getColorPrimario());
 	    	   if(!lstPrendas.get(i).getColorSecundario().isEmpty()) {
 	    		   row.setColor_secundario(lstPrendas.get(i).getColorSecundario());
 	    	   } else row.setColor_secundario("Sin Color Secundario");
 	    	   row.setMaterial(lstPrendas.get(i).getMaterial());
 	    	   row.setParte(lstPrendas.get(i).getParte());
 	    	   row.setTipo(lstPrendas.get(i).getTipo());

 	           table.add(row);
 	       }
        }
        catch(Exception e){}

        model.setTable(table);
        
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
