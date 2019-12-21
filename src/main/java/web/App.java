package web;


//import jsonParser.JsonParser;
<<<<<<< HEAD
=======
import com.utils.Utils;

import JsonPersistido.abrigoJson;
import JsonPersistido.abrigoSecundarioJson;
import JsonPersistido.factoresClimaticosJson;
>>>>>>> Entrega5
import spark.ModelAndView;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.controllers.LoginController;
<<<<<<< HEAD
import web.controllers.altaAbrigoController;
=======
import web.controllers.LogoutController;
import web.controllers.altaAbrigoController;
import web.controllers.altaAccesorioAbrigoController;
>>>>>>> Entrega5
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
<<<<<<< HEAD
import web.controllers.sugerenciasController;
import web.models.altaTiposModel;

import java.io.IOException;
import java.util.ArrayList;
=======
import web.controllers.sugerenciasAceptadasController;
import web.controllers.sugerenciasController;
import web.models.altaTiposModel;
import web.loadInitialData;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
>>>>>>> Entrega5
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
import org.apache.log4j.BasicConfigurator;

=======
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.BasicConfigurator;

import web.EntityManagerSingleton;
import com.github.prominence.openweathermap.api.DailyForecastRequester;
import com.github.prominence.openweathermap.api.HourlyForecastRequester;
import com.github.prominence.openweathermap.api.OpenWeatherMapManager;
import com.github.prominence.openweathermap.api.constants.Accuracy;
import com.github.prominence.openweathermap.api.constants.Language;
import com.github.prominence.openweathermap.api.constants.Unit;
import com.github.prominence.openweathermap.api.model.response.DailyForecast;
import com.github.prominence.openweathermap.api.model.response.DailyForecast.Forecast;
import com.github.prominence.openweathermap.api.model.response.HourlyForecast;
import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;
import com.proveedores.openweather.ExtendedOpenWeatherDTO;
import com.proveedores.openweather.OpenWeather;
import com.proveedores.openweather.WeatherDTO;
import TPZTBCS.Evento;
import TPZTBCS.Usuario;
import TPZTBCS.dao.abrigoJsonDao;
import TPZTBCS.dao.abrigoSecundarioJsonDao;
import TPZTBCS.dao.factoresClimaticosJsonDao;

import com.prominence.openweathermap.*;
import com.proveedores.openweather.OpenWeather;
>>>>>>> Entrega5

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
    
<<<<<<< HEAD
=======
    
>>>>>>> Entrega5
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
<<<<<<< HEAD
    	
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
=======
    	altaAccesorioAbrigoController.init();
    	LogoutController.init();
    	calendarioController.init();
    	puntajeController.init();
    	
    	sugerenciasAceptadasController.init();
    }
    
    
	public static void main( String[] args )
    {
//		Logger del spark
    	
    	BasicConfigurator.configure(); 
    	
    
    	
//    	cargar_datos_a_bd();
    	
    	
    	
    	web.EntityManagerSingleton.getEntityManager();
    	
    	Spark.port(getHerokuAssignedPort());
    	
>>>>>>> Entrega5
        staticFileLocation("/webResources");
        DebugScreen.enableDebugScreen();
        Spark.init();
       
<<<<<<< HEAD
//		ACA TENEMOS QUE INICIAR LOS HILOS
        
    	
        iniciarControladores();
        
	 
        
        
=======
        iniciarControladores();
    	    	    	
    	
    }
	
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    
    public static void cargar_datos_a_bd() {
    	loadInitialData.loadJsonAbrigos();
    	try {
			loadInitialData.loadUsuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> Entrega5
    }

    
}


