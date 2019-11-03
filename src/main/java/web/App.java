package web;


//import jsonParser.JsonParser;
import spark.ModelAndView;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.controllers.LoginController;
import web.controllers.altaPrendaController;
import web.controllers.altaTipoSuperiorController;
import web.controllers.listadoGuardarropasController;
import web.controllers.listadoPrendasController;
import web.models.altaTipoSuperiorModel;

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

    public static App getInstance() {
    	if(instance == null) { 
    		instance = new App();
    	}
    	return instance;
    }
    
    public static void iniciarControladores() {
    	
    	LoginController.init();
    	listadoGuardarropasController.init();
    	listadoPrendasController.init();
    	altaPrendaController.init();
    	altaTipoSuperiorController.init();
//    	altaTipoInferiorController.init();

    }
    
    
    public static void main( String[] args )
    {

    	BasicConfigurator.configure(); //sin eso no se configura el logger. No sacar.
        Spark.port(9000);
        staticFileLocation("/webResources");
        DebugScreen.enableDebugScreen();
        Spark.init();
        
//		ACA TENEMOS QUE INICIAR LOS HILOS
        
    	
        iniciarControladores();
        
	 
        
        
    }

    
}


