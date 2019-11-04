package web;


//import jsonParser.JsonParser;
import spark.ModelAndView;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.controllers.LoginController;
import web.controllers.altaAbrigoController;
import web.controllers.altaAccesorioController;
import web.controllers.altaCalzadoController;
import web.controllers.altaPrendaController;
import web.controllers.altaTipoInferiorController;
import web.controllers.altaTipoSuperiorController;
import web.controllers.listadoGuardarropasController;
import web.controllers.listadoPrendasController;
import web.models.altaTiposModel;

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
    	
    	LoginController.init(); // -> Requerimiento 1
    	
    	listadoGuardarropasController.init(); // -> Requerimiento 2
    	listadoPrendasController.init(); // -> Requerimiento 3
    	
    	altaPrendaController.init(); // -> Requerimiento 4
    	
    	altaTipoSuperiorController.init(); // -> Requerimiento 4
    	altaTipoInferiorController.init(); // -> Requerimiento 4
    	altaCalzadoController.init(); // -> Requerimiento 4
    	altaAccesorioController.init(); // -> Requerimiento 4
    	altaAbrigoController.init(); // -> Requerimiento 4
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


