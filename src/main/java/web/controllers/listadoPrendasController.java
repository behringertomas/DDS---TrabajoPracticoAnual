package web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.log4j.BasicConfigurator;

import TPZTBCS.Guardarropa;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import TPZTBCS.dao.GuardarropaDao;
import TPZTBCS.dao.UsuarioDao;
import javafx.scene.control.ComboBox;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.helper.SessionHelper;
import web.models.AlertModel;
import web.models.listadoGuardarropaModel;
import web.models.listadoPrendasModel;
import web.models.views.listadoGuardarropaTable;
import web.models.views.listadoPrendasTable;

public class listadoPrendasController  extends MainController {

	private static EntityManager entityManager;
	public static PointValuePair solucion;
	private static final String LISTADO_PRENDAS = "cliente/listadoPrendas.hbs";
	private static listadoPrendasModel model;
    private static Usuario currentUser;
    private static AlertModel alert = new AlertModel(false,"",false);
    
    
    private static UsuarioDao uDao = new UsuarioDao();
    private static GuardarropaDao gDao = new GuardarropaDao();
    
    
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.prendasPath(),listadoPrendasController::showPagina,engine);
        Spark.post(Router.prendasPath(), listadoPrendasController::showListado, engine);
        initModel();
    }   
  
    
    private static ModelAndView showPagina(Request request, Response response) {
    	getCurrentClient(request);
        sessionExist(request, response);
        model.setShowAlert(false);
        
        model.limpiarGuardarropas();
        
        List<Guardarropa> guardarropa = (List<Guardarropa>) currentUser.getListaGuardarropas();
        
        for(Guardarropa g : guardarropa) {
        	model.getGuardarropa().add(g);
        }
        return new ModelAndView (model, LISTADO_PRENDAS);
    }
    
    private static void getCurrentClient(Request request) {
        String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
//        currentUser = uDao.getUsuario(userID);
        currentUser = getUsuarioViaEntity(userID);
        
    }
    
    private static ModelAndView showListado(Request request, Response response) {        
        try
            {
                alert.setHideAlert();
                fillListadoPrendasTable(request,response);
                return new spark.ModelAndView(model,LISTADO_PRENDAS);
            }
        catch(Exception e)
            {
                alert.setShowAlertWithMessage("Error");
                return new ModelAndView(alert, LISTADO_PRENDAS);
            }

        }
        
/////////////////////////////////////////////////////////////
    
        private static void initModel() {
            model = new listadoPrendasModel();
            
        }
/////////////////////////////////////////////////////////////

       private static void fillListadoPrendasTable(Request request, Response response) {

            List<listadoPrendasTable> table = new ArrayList<listadoPrendasTable>();        
            String guardarropaABuscar = request.queryParams("guardarropa");
            
            String userSession =  request.session().attribute("user");
            Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
            currentUser = getUsuarioViaEntity(userID);
            
            List<Prenda> lstPrendas = currentUser.getGuardarropa(guardarropaABuscar).getAllPrendas();
            
           try{
    	       for(int i = 0; i < lstPrendas.size(); i++)
    	       {
    	    	   listadoPrendasTable row = new listadoPrendasTable();
    	    	   
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

           model.setListadoPrendasTable(table);
           
        }
       
       public static Usuario getUsuarioViaEntity(int id) {
    	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
    	   entityManager = factory.createEntityManager();
  
    	   return entityManager.find(Usuario.class, id);
       }
       
        
    }

