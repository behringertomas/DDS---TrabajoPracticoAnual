package web.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import web.models.altaEventoModel;
import web.models.calendarioModel;

public class calendarioController extends MainController{
	
	private static final String CALENDARIO = "/cliente/calendar.hbs";
	private static calendarioModel model;
	
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.getCalendarioPath(),calendarioController::showPagina,engine);
        initModel();
    }  
    private static ModelAndView showPagina(Request request, Response response) {
        return new ModelAndView (model, CALENDARIO);
    }
    
    private static void initModel() {
        model = new calendarioModel();
    }
    
}
