package web.controllers;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import TPZTBCS.Atuendo;
import TPZTBCS.Evento;
import TPZTBCS.Guardarropa;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import TPZTBCS.dao.BaseDao;
import TPZTBCS.dao.UsuarioDao;
import TPZTBCS.dao.atuendoDao;
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
    private static Usuario currentUser;
    private static atuendoDao aDao;
    private static UsuarioDao uDao = new UsuarioDao();
	private static EntityManager entityManager;
	private static List<modificacionPuntajes> lstModificacionPuntajes;
	private static puntajePrendasModel model;
	private static AlertModel alert = new AlertModel(false,"",false);
	private static int atuendoSeleccionado;
	
	private static List<Prenda> lista_prendas_totales = new ArrayList<>();

    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getHistorialCalificacionesPath(), puntajeController::load, engine);
        Spark.post(Router.getHistorialCalificacionesPath(), puntajeController::buscarPrendas, engine);
        Spark.post(Router.getModificarPuntajes(), puntajeController::modificarPuntajes, engine);
        initModel();

    }
    
    private static void initModel() {
        model = new puntajePrendasModel();
    }
    
    private static ModelAndView modificarPuntajes(Request request, Response response) {
    	
    	
    	Atuendo atuendoElegido = getAtuendoViaEntity(getAtuendoSeleccionado());
    	
//    	puntuaciones de prendas en particular
//    	haremos un promedio. Si se quiere puntuar el atuendo total, abajo habia comenzado a hacer el codigo.
//    	lo dejo comentado aca abajo y en el hbs.
    	int sumatoriaPuntaje = 0;
    	try{
 	       for(int i = 0; i < lista_prendas_totales.size(); i++)
 	       {
 	    	   
 	    	  String idAObtenerPuntaje = Integer.toString(lista_prendas_totales.get(i).getID());
 	    	   String asd = request.queryParams(idAObtenerPuntaje);
 	    	   int puntajeParticular = Integer.parseInt(request.params(":id"));
// 	    	   String idAObtenerPuntaje = Integer.toString(lista_prendas_totales.get(i).getID());
// 	    	   int puntajeParticular = Integer.parseInt(request.queryParams(idAObtenerPuntaje));
 	    	   sumatoriaPuntaje +=puntajeParticular;
 	       }
 	       int puntajeFinal = sumatoriaPuntaje / lista_prendas_totales.size();
 	       atuendoElegido.setPuntaje(currentUser,puntajeFinal);
 	       
 	       BaseDao bdao = new BaseDao();
 	       bdao.update(atuendoElegido);
 	       
// 	       POR SI SE NECESITA HACER UN PUNTAJE TOTAL, VIENE POR ACA
// 	      int puntajeTotalAtuendo = Integer.parseInt(request.queryParams("puntajeTotal"));
// 	      if (puntajeTotalAtuendo != 0) {
// 	    	 
// 	      }
        }
        catch(Exception e){}
    	
    	return new spark.ModelAndView(model,HISTORIAL_CALIFICACIONES);
    }
    
    private static ModelAndView load(Request request, Response response) {
    	
    	String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        
        model.setShowAlert(false);
        
        cargarAtuendosAlListBox();

        return new spark.ModelAndView(model,HISTORIAL_CALIFICACIONES);

    }

    private static void fillListadoAtuendosTable(Request request, Response response) {
//    	lstModificacionPuntajes.clear();
    	lista_prendas_totales.clear();
        List<modificacionPuntajes> table = new ArrayList<modificacionPuntajes>();        
        
        setAtuendoSeleccionado(Integer.parseInt(request.queryParams("atuendo")));
       
        Atuendo atuendoElegido = getAtuendoViaEntity(getAtuendoSeleccionado());

        lista_prendas_totales.addAll(atuendoElegido.getPrendas());
     
       try{
	       for(int i = 0; i < lista_prendas_totales.size(); i++)
	       {
	    	   modificacionPuntajes row = new modificacionPuntajes();
	    	   
	    	   row.setID(lista_prendas_totales.get(i).getID());
	    	   row.setColor_primario(lista_prendas_totales.get(i).getColorPrimario());
	    	   if(!lista_prendas_totales.get(i).getColorSecundario().isEmpty()) {
	    		   row.setColor_secundario(lista_prendas_totales.get(i).getColorSecundario());
	    	   } else row.setColor_secundario("Sin Color Secundario");
	    	   row.setMaterial(lista_prendas_totales.get(i).getMaterial());
	    	   row.setParte(lista_prendas_totales.get(i).getParte());
	    	   row.setTipo(lista_prendas_totales.get(i).getTipo());

	           table.add(row);
//	           lstModificacionPuntajes.add(row);
	       }
       }
       catch(Exception e){}

       model.setTable(table);
    }

    private static ModelAndView buscarPrendas(Request request, Response response) {
    
    	String userSession =  request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0,userSession.indexOf("-")));
        currentUser = getUsuarioViaEntity(userID);
        cargarAtuendosAlListBox();
        
        model.setShowAlert(false);
        
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
    
    public static Atuendo getAtuendoViaEntity(int id) {
  	   EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
  	   entityManager = factory.createEntityManager();

  	   return entityManager.find(Atuendo.class, id);
     }
    
    public static void cargarAtuendosAlListBox() {
        model.limpiar_atuendos();
        List<Atuendo> atuendo = currentUser.getHistorialAtuendos();
        
        for(Atuendo a : atuendo) {
        	model.getListaAtuendos().add(a);
        }
    }

	public static int getAtuendoSeleccionado() {
		return atuendoSeleccionado;
	}

	public static void setAtuendoSeleccionado(int atuendoSeleccionado) {
		puntajeController.atuendoSeleccionado = atuendoSeleccionado;
	}
    
    
    


}
