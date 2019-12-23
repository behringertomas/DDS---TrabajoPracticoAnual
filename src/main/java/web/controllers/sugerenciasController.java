package web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import TPZTBCS.Atuendo;
import TPZTBCS.Evento;
import TPZTBCS.Guardarropa;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import TPZTBCS.dao.BaseDao;
import TPZTBCS.models.QueryModel;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import web.EntityManagerSingleton;

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
	private static Atuendo atuendoElegido;
	private static Evento eventoSeleccionado;
	
	public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getSugerencias(), sugerenciasController::showPagina, engine);
        Spark.post(Router.getSugerencias(), sugerenciasController::generarSugerencia, engine);
        Spark.post(Router.getAceptarSugerencia(), sugerenciasController::aceptarSugerencia, engine);
        initModel();
    }
	
    private static void initModel() {
       model = new sugerenciasModel();
    }
    
    private static ModelAndView showPagina(Request request, Response response) {
    	getCurrentClient(request);
        sessionExist(request, response);
        model.setShowAlert(false);
        
        model.limpiarEventos();
        
        List<Evento> evento = (List<Evento>) currentUser.getListaEvento();
        
        for(Evento e : evento) {
        	model.getEvento().add(e);
        }
        
        return new ModelAndView (model, SUGERENCIAS);
    }
    
    private static ModelAndView aceptarSugerencia(Request request, Response response) {

    	
        model.limpiarEventos();
        
        List<Evento> evento = (List<Evento>) currentUser.getListaEvento();
        
        for(Evento e : evento) {
        	model.getEvento().add(e);
        }
        
    	BaseDao bdao = new BaseDao();
    	eventoSeleccionado.setAtuendoElegido(atuendoElegido);
        bdao.update(eventoSeleccionado);
        persist(atuendoElegido);
        
        currentUser.addAtuendoHistorial(atuendoElegido);
    	bdao.update(currentUser);
        
    	atuendoElegido.getPrendas().forEach(prenda->prenda.getAtuendo().add(atuendoElegido));
    	atuendoElegido.getPrendas().forEach(prenda-> bdao.update(prenda));
        return new ModelAndView (model, SUGERENCIAS);
    }
    
    private static ModelAndView generarSugerencia(Request request, Response response) {
        sessionExist(request, response);

        String userSession = request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0, userSession.indexOf("-")));

        currentUser = getUsuarioViaEntity(userID);
        model.limpiarEventos();
        
        List<Evento> evento = (List<Evento>) currentUser.getListaEvento();
        
        for(Evento e : evento) {
        	model.getEvento().add(e);
        }
        
        try
            {
                alert.setHideAlert();
                fillSugerenciaTable(request,response);
                return new spark.ModelAndView(model,SUGERENCIAS);
            }
        catch(Exception e)
            {

                alert.setShowAlertWithMessage("La API del Clima no puede responder la solicitud.");

                return new ModelAndView(alert, SUGERENCIAS);
            }

        }
    
    private static void fillSugerenciaTable(Request request, Response response) {

    	List<sugerenciaTable> table = new ArrayList<sugerenciaTable>();  
    	String eventoABuscar = request.queryParams("evento");
    	
    	
    	String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        
        eventoSeleccionado = currentUser.getEvento(eventoABuscar);
        eventoSeleccionado.run();
        atuendoElegido = eventoSeleccionado.getAtuendoElegido();
        List<Prenda> lstPrendas = atuendoElegido.getPrendas();
        
        try{
 	       for(int i = 0; i < lstPrendas.size(); i++)
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
    
    public static void persist(Atuendo atuendo){

    	EntityManager entityManager = EntityManagerSingleton.getEntityManager();

	    EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    entityManager.persist(atuendo);
	    transaction.commit();

    }
       
    
    private static void getCurrentClient(Request request) {
        String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        
    }
    
    public static Usuario getUsuarioViaEntity(int id) {


 	   return EntityManagerSingleton.getEntityManager().find(Usuario.class, id);

    }
    
    private static sugerenciasModel updateModel(){
        return model;
    }

}
