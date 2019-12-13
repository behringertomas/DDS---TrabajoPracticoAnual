package web;


//import jsonParser.JsonParser;
import com.utils.Utils;

import JsonPersistido.abrigoJson;
import JsonPersistido.abrigoSecundarioJson;
import JsonPersistido.factoresClimaticosJson;
import spark.ModelAndView;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import web.controllers.LoginController;
import web.controllers.LogoutController;
import web.controllers.altaAbrigoController;
import web.controllers.altaAccesorioAbrigoController;
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
import web.controllers.sugerenciasAceptadasController;
import web.controllers.sugerenciasController;
import web.models.altaTiposModel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.BasicConfigurator;

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
import com.sun.crypto.provider.DESCipher;

import TPZTBCS.Evento;
import TPZTBCS.Usuario;
import TPZTBCS.dao.abrigoJsonDao;
import TPZTBCS.dao.abrigoSecundarioJsonDao;
import TPZTBCS.dao.factoresClimaticosJsonDao;

import com.prominence.openweathermap.*;
import com.proveedores.openweather.OpenWeather;

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
    	altaAccesorioAbrigoController.init();
    	LogoutController.init();
    	calendarioController.init();
    	puntajeController.init();
    	
    	sugerenciasAceptadasController.init();
    }
    
    public static void loadJsonAbrigos() {
    	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
	    EntityManager entityManager = factory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();

	   
    	abrigoJson abrigo1 = new abrigoJson("Campera", 20); 
    	abrigoJson abrigo2 = new abrigoJson("Sweater", 15);
    	abrigoJson abrigo3 = new abrigoJson("Buzo", 10);
    	abrigoJson abrigo4 = new abrigoJson("Campera Impermeable", 10);
	    transaction.begin();
	    entityManager.persist(abrigo1);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo2);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo3);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigo4);
	    transaction.commit();
    	
    	abrigoSecundarioJson abrigoSecundario1 = new abrigoSecundarioJson("Bufanda","Cuello", 10);
    	abrigoSecundarioJson abrigoSecundario2 = new abrigoSecundarioJson("Gorro","Cabeza", 10);
    	abrigoSecundarioJson abrigoSecundario3 = new abrigoSecundarioJson("Guantes","Manos", 10);
    	abrigoSecundarioJson abrigoSecundario4 = new abrigoSecundarioJson("Cuello Polar","Cuello", 10);
    	abrigoSecundarioJson abrigoSecundario5 = new abrigoSecundarioJson("Gorra Sol","Cabeza", 0);
	    transaction.begin();
	    entityManager.persist(abrigoSecundario1);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario2);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario3);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario4);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(abrigoSecundario5);
	    transaction.commit();
    	
    	factoresClimaticosJson factoresClimaticos1 = new factoresClimaticosJson("Gorra de Sol","Sol");
    	factoresClimaticosJson factoresClimaticos2 = new factoresClimaticosJson("Lentes de Sol","Sol");
    	factoresClimaticosJson factoresClimaticos3 = new factoresClimaticosJson("Campera Impermeable","Lluvia");
    	factoresClimaticosJson factoresClimaticos4 = new factoresClimaticosJson("Paraguas","Lluvia");
	    transaction.begin();
	    entityManager.persist(factoresClimaticos1);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(factoresClimaticos2);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(factoresClimaticos3);
	    transaction.commit();
	    transaction.begin();
	    entityManager.persist(factoresClimaticos4);
	    transaction.commit();
    	
    	
    }
    
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
//    	loadJsonAbrigos();
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
    	    	
    	//***	FORMAS PARA LLAMAR A LA API:
    	
    	
    	
//    	Date date = new java.util.Date();
//    	date.setDate(date.getDate() + 2);
//    	LocalDate new_date = proveedor.convertToLocalDateViaMilisecond(date);
//   
//    	Double temp = proveedor.obtenerTemperaturATalDia(new_date, ciudad);
//    	System.out.println(temp);
    	//************
    	
//    	abrigoJsonDao abrigoDao = new abrigoJsonDao();
//    	
//    	abrigoJson abrigo = abrigoDao.getByAbrigo("Campera");
//    	
//    	System.out.println(abrigo.getAbrigo());
//    	System.out.println(abrigo.getTemp());
//    	double temp = proveedor.get_temperatura_de_hoy(ciudad);
    	
//    	OpenWeather proveedor = new OpenWeather();
//    	String ciudad = "Paris";
//    	String descripcion = proveedor.get_descripcion_de_hoy(ciudad);
    	
    	
//    	String descripcion = "Weather: few clouds";
//    	System.out.println(temp);
//    	System.out.println(descripcion);
//    	Esto es porque siempre pone wheater:
//    	descripcion = (String) descripcion.subSequence(9, descripcion.length());
//    	System.out.println(descripcion);
    	
    	
//    	
//    	String desc = proveedor.get_descripcion_tal_dia(ciudad, date);
//    	System.out.println(desc);
    	
    	
    	
    }

    
}


