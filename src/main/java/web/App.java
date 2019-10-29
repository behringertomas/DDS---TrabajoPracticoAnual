package web;


//import jsonParser.JsonParser;
import spark.ModelAndView;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.controllers.LoginController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;


import static spark.Spark.staticFileLocation;

public class App 
{
	private static App instance = null;
//	List<Categoria> categorias = new ArrayList<Categoria>();
//	Cliente loggedClient;


    public static void main( String[] args )
    {
//    	Spark.stop(); // Sirve para parar el servidor una vez que lo arrancaste
    	BasicConfigurator.configure(); //sin eso no se configura el logger. No sacar.
        Spark.port(9000);
        staticFileLocation("/webResources");
        DebugScreen.enableDebugScreen();
        Spark.init();
//		ACA TENEMOS QUE INICIAR LOS HILOS
        
//    	LoginController.init();

        Spark.get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "login.hbs");
          }, new HandlebarsTemplateEngine());
        
        
        
        
//        Spark.get("/", (request, response) -> {
//        	Map<String, Object> model = new HashMap<>();
//        	model.put("message", "Hello Handlebars!");
//            return "<html><body><h1>HOLA</h1></body></html>";
//        } );
//
//        Spark.get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("message", "Hello Handlebars!");
//            return new ModelAndView(model, "Login.html"); // located in resources/templates
//        }, new HandlebarsTemplateEngine());
    }
	

    public static App getInstance() {
    	if(instance == null) { 
    		instance = new App();
    	}
    	return instance;
    }

    
    
}


