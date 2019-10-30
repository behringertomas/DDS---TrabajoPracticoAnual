package web.controllers;

import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.Router;
import spark.Response;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class MenuController {

	 private static final String HOME = "/Menu.hbs";
	 
    public static void init() {
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.homePath(), MenuController::load,engine);
//        Spark.post(Router.homePath,MenuController:: asd ,engine);
        
    }
    
    
    private static ModelAndView load(Request request, Response response) {
//        sessionExist(request, response);

        return new ModelAndView (model, HOME);
//    }
}
