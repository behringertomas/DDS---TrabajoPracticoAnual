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
import web.controllers.altaEventoController;
import web.controllers.altaPrendaController;
import web.controllers.altaTipoInferiorController;
import web.controllers.altaTipoSuperiorController;
import web.controllers.calendarioController;
import web.controllers.listadoGuardarropasController;
import web.controllers.listadoPrendasController;
import web.controllers.puntajeController;
import web.controllers.sugerenciasController;
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
    	
    	LoginController.init();
    	
    	listadoGuardarropasController.init();
    	listadoPrendasController.init();
    	
    	altaPrendaController.init();
    	altaEventoController.init();
    	
    	sugerenciasController.init();
    	altaTipoSuperiorController.init();
    	altaTipoInferiorController.init();
    	altaCalzadoController.init();
    	altaAccesorioController.init();
    	altaAbrigoController.init();
    	
    	calendarioController.init();
    	puntajeController.init();
    }
    
    
    public static void main( String[] args )
    {
//    	BasicConfigurator.configure(); 

//    	Eso es para el logger del server.
//    	si no quieren que logee Started y todas las respuestas del sv, saquenlo.
//    	Sirve para que podamos ver lo que va respondiendo solo eclipse.
//    	Lo unico que si, si lo descomentan va a dar un mensajito rojo, pero no le den bola
        Spark.port(9000);
        staticFileLocation("/webResources");
        DebugScreen.enableDebugScreen();
        Spark.init();
       
//		ACA TENEMOS QUE INICIAR LOS HILOS
        
    	
        iniciarControladores();
        
	 
        
        
    }

    
}


