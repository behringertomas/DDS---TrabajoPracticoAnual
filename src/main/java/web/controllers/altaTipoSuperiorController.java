package web.controllers;

import TPZTBCS.Usuario;
import TPZTBCS.dao.UsuarioDao;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.models.altaPrendasModel;
import web.models.altaTipoSuperiorModel;

public class altaTipoSuperiorController extends MainController {

	private static Usuario currentUser;
    private static UsuarioDao uDao = new UsuarioDao();
	private static altaTipoSuperiorModel model;
	private static final String ALTA_SUPERIOR = "/cliente/altaTipoSuperior.hbs";
	private static final String PARTE = "Parte Superior";
	
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getAltaSuperior(),altaTipoSuperiorController::load,engine);
        Spark.post(Router.getAltaSuperior(), altaTipoSuperiorController::crearPrenda, engine);
        initModel();
    }   
    
    private static void initModel() {
        model = new altaTipoSuperiorModel();
    }
    
    private static ModelAndView load(Request request, Response response) {
        sessionExist(request, response);
        String userSession = request.session().attribute("user");
        Integer userID = Integer.parseInt(userSession.substring(0, userSession.indexOf("-")));
        currentUser = uDao.getUsuario(userID);
        model.setShowAlert(false);

        return new ModelAndView(model, ALTA_SUPERIOR);
    }
    
    private static ModelAndView crearPrenda(Request request, Response response) {
//		usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
    	try {
    		String tipoPrenda = request.queryParams("superior");
    		String material = request.queryParams("material");
    		String colorPrimario = request.queryParams("colorPrimario");
    		if(request.queryParams("colorSecundario").equalsIgnoreCase("Ninguno")) {
    			currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario);
    		} else {
    			String colorSecundario = request.queryParams("colorSecundario");
    			currentUser.construirPrenda(PARTE, tipoPrenda, material, colorPrimario,colorSecundario);
    		}
    		
    	}
    	catch (Exception ex) {
            response.status(400);
            response.body("Ocurrio un error. Intenta nuevamente");
        }
    	
    	return new ModelAndView(model, ALTA_SUPERIOR);
    }
    
    
}
