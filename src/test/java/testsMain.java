import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.List;
import java.time.LocalDate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;

import org.apache.log4j.BasicConfigurator;
import org.json.simple.JSONObject;
import org.paukov.combinatorics3.Generator;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import com.google.common.collect.Iterables;
import com.krds.accuweatherapi.ApiSession;
import com.krds.accuweatherapi.CurrentConditionsApi;
import com.krds.accuweatherapi.DayPeriod;
import com.krds.accuweatherapi.ForecastApi;
import com.krds.accuweatherapi.HourPeriod;
import com.krds.accuweatherapi.LocationApi;
import com.krds.accuweatherapi.model.CurrentConditions;
import com.krds.accuweatherapi.model.GeoPositionSearchResult;
import com.weatherlibrary.datamodel.WeatherModel;
import com.weatherlibraryjava.IRepository;
import com.weatherlibraryjava.Repository;
import com.weatherlibraryjava.RequestBlocks.GetBy;
import com.weatherlibraryjava.WeatherApixu;
import com.weathertest.ZonaYTemperatura;

import com.proveedores.openweather.*;
import com.proveedores.*;

import TPZTBCS.AdapterAPI;
import TPZTBCS.Evento;
import TPZTBCS.Guardarropa;
import TPZTBCS.JsonReader;
import TPZTBCS.NotificacionEmail;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import TPZTBCS.cargarImagenes;
import TPZTBCS.dao.BaseDao;
import TPZTBCS.dao.GuardarropaDao;
import TPZTBCS.dao.UsuarioDao;
import interfacesZTBCS.ITargetAPI;




public class testsMain {
	
	

//	public static void main(String[] args) throws Exception, UnauthorizedException, ApiException {
//		
//		Usuario tomas = new Usuario("tomas","tomas@gmail.com","1234","Tomas Behringer",21);
//		  Prenda prenda1 = tomas.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
//		  tomas.CrearGuardarropa("Guardarropa De Invierno",10);
//		  tomas.asignarPrenda(tomas.getGuardarropa("Guardarropa De Invierno"), prenda1 );
//		
//		  System.out.println(prenda1.getDescripcion());
//	        
//	} 
//		UsuarioDao usr = new UsuarioDao();
//		Usuario tomasSQL = usr.getUserByUsername("tomas");
//		
//		System.out.println(tomasSQL.getGuardarropa("Guardarropa Primaveral").getAllPrendas().size());
//		
//	} 
//		EntityManager entityManager; 
//		BasicConfigurator.configure();
//	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
//	    entityManager = factory.createEntityManager();
//		
//		Usuario agustin = new Usuario("agustin","agustin@gmail.com","1234","Agustin Zeppa",24);
//		agustin.CrearGuardarropa("Guardarropa Primaveral",10);

		UsuarioDao uDao = new UsuarioDao();
//		
//		Usuario agustinPersistido = uDao.getUserByUsername("agustin");
		
//		agustinPersistido.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
//		agustinPersistido.construirPrenda("Parte Inferior","Pantalon Largo", "Jean", "Azul", "Negro");
//		agustinPersistido.construirPrenda("Calzado","Runners", "Algodon", "Rojo", "Negro");
//		agustinPersistido.construirPrenda("Accesorio","Pulsera", "Plata", "Rojo", "Negro");
//		
		//agustinPersistido.asignarPrenda(agustinPersistido.getGuardarropa("Guardarropa Primaveral"), prenda);
		
//	    GuardarropaDao gDao = new GuardarropaDao();
		
//	    EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(agustin);
//        transaction.commit();
	    
	    
//	    gDao.getAllGuardarropas(agustinPersistido).forEach(x->x.imprimirGuardarropa());

	    
//		Usuario usuario = new Usuario("Tomi xd",20,"agustin.zeppa@gmail.com");
//		Guardarropa guardarropa1 = new Guardarropa("Guardarropa	Verano");
//		NotificacionEmail notiPrueba = new NotificacionEmail();
//		notiPrueba.enviarNotificacion(usuario.getDatos());
//		System.out.println("Hola2");
		
		
//		BaseDao dao = new BaseDao();
//		UsuarioDao userDao = new UsuarioDao();
//
//		Usuario u = userDao.getUserByUsername("ezequiel123");
//		System.out.println(u.getEmail());
		
		
//		Guardarropa guardarropa2 = new Guardarropa("Guardarropa Primavera");
		
//		usuario.agregarGuardarropas(guardarropa1);
//		usuario.agregarGuardarropas(guardarropa2);
		
		
//		Prenda prenda1 = new Prenda();
		
//		prenda1.setPuntaje(usuario, 10);
//		System.out.println("puntaje1 : " + prenda1.getPuntaje(usuario));
//		prenda1.setPuntaje(usuario, 9);
//		System.out.println("puntaje2 : " + prenda1.getPuntaje(usuario));
		
		
		
		
//		Prenda prenda9  =usuario.construirPrenda("Parte Superior","Musculosa", "Tela", "Rojo", "Negro");
//		Prenda prenda10 =usuario.construirPrenda("Parte Inferior","Pollera", "Jean", "Azul", "Negro");
//		Prenda prenda11 =usuario.construirPrenda("Calzado","Trainers", "Cuero", "Rojo", "Negro");
//		Prenda prenda12 =usuario.construirPrenda("Accesorio","Lentes de Sol", "Plata", "Rojo", "Negro");
//		
//		Prenda prenda5  =usuario.construirPrenda("Parte Superior","Camisa", "Tela", "Rojo", "Negro");
//		Prenda prenda6  =usuario.construirPrenda("Parte Inferior","Short", "Algodon", "Rojo", "Negro");
//		Prenda prenda7  =usuario.construirPrenda("Calzado","Zapato", "Cuero", "Rojo", "Negro");
//		Prenda prenda8  =usuario.construirPrenda("Accesorio","Reloj", "Metal", "Rojo", "Negro");
//		
//		Prenda prenda13 =usuario.construirPrenda("Parte Superior", "Campera", "Cuero", "Negro");
//		Prenda prenda14 =usuario.construirPrenda("Parte Superior", "Sweater", "Algodon", "Blanco");
//		Prenda prenda15 =usuario.construirPrenda("Accesorio", "Bufanda", "Algodon", "Blanco");
//		Prenda prenda16 =usuario.construirPrenda("Accesorio", "Gorro", "Tela", "Blanco");
//		Prenda prenda17 =usuario.construirPrenda("Accesorio", "Gorro", "Seda", "Negro");
//		Prenda prenda18 =usuario.construirPrenda("Accesorio", "Gorro", "Algodon", "Rojo");
//		Prenda prenda19 =usuario.construirPrenda("Accesorio", "Gorro", "Seda", "Blanco");
//		
//		
//		//JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("C:\\Users\\Ivan\\Documents\\GitHub\\DDS---TrabajoPracticoAnual\\src\\main\\java\\Verificaciones.json");
//		//prenda15.imprimirDescripcion();
//		System.out.println(prenda19.getParteEspecifica());
//		
//		
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda1);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda3);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda4);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda6);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda9);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda10);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda11);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda12);
//		
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda16);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda17);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda18);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda19);
//		
//		
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda2);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda5);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda7);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda8);
//		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda15);
//		usuario.agregarPrendaAGuardarropas(guardarropa1, prenda13);
//		usuario.agregarPrendaAGuardarropas(guardarropa1, prenda14);
//		
//		
//		usuario.crearEvento("Fiesta de Gala", "Paris", 2020, 10, 7, 15, 26);
		
	
//		ITargetAPI target = new AdapterAPI( new WeatherApixu() ); //apixu
//		ApiSession session = new ApiSession.Builder("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf").build();
//		LocationApi locationApi = session.getLocationApi();
//		CurrentConditionsApi current = session.getCurrentConditionsApi("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf");
//		Optional <GeoPositionSearchResult> geoLocation = locationApi.geoPosition(target.getLat("Paris"),target.getLong("Paris"));
//		ForecastApi forecastapi= session.getForecastApi(geoLocation.get().getKey());
		
//		String descripcion = forecastapi.getDailyXdays(DayPeriod.DAYS_5).get().getHeadline().getCategory();
//		System.out.println(forecastapi.getDailyXdays(DayPeriod.DAYS_5).map(x->x.getHeadline().getCategory().toString()));
		
		//guardarropa1.queMePongo("Perth",usuario.getDatos());
		
		
		
//		--------------------------------------------- ACCU WEATHER
		
		
//		ITargetAPI target = new AdapterAPI( new WeatherApixu() ); 
		
//		System.out.println("Latitud: " + target.getLat("Paris"));
//		System.out.println("Longitud: " + target.getLong("Paris"));
		
//		ApiSession session = new ApiSession.Builder("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf").build();
//		LocationApi locationApi = session.getLocationApi();
		
//		CurrentConditionsApi current = session.getCurrentConditionsApi("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf");
		
		
//		Deja esto comentado para el tema del Forecast.
//		 ForecastApi forecast = session.getForecastApi("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf");
//		 forecast.getDailyXdays("DAYS_5");
//		va a ser algo asi como HourPeriod.HOURS_24
		
//		String ciudad = "Paris";
		
//			ciudad.trim();
//			String newCiudad;
			
//			newCiudad =ciudad.replaceAll("\\s+", "%20");
		
//		guardarropa1.queMePongo(newCiudad, usuario.getDatos());
		
//		Optional <GeoPositionSearchResult> geoLocation = locationApi.geoPosition(target.getLat(newCiudad),target.getLong(newCiudad));
		
//		if (geoLocation.isPresent()) {
//		  System.out.println("The location key for the coordinates is: " + geoLocation.get().getKey());
//		}

//		CurrentConditionsApi ccApi = session.getCurrentConditionsApi(geoLocation.get().getKey());
//
//		Optional<CurrentConditions> cc = ccApi.get(HourPeriod.HOURS_24);
//		if (cc.isPresent()) {
//		  System.out.println("Current temperature is: " + cc.get().getTemperature().getMetric().getValue());
//		  System.out.println(cc.get().getWeatherText());
//		}
//		LocalDate date = LocalDate.of(2019, 9, 4);

//		OpenWeather apiOpenW = new OpenWeather();
//		apiOpenW.obtenerPronosticoExtendido("London");
		
//		ITargetAPI target = new AdapterAPI( new WeatherApixu() ); //apixu
//		OpenWeather apiOpenW = new OpenWeather();
		
//		ApiSession session = new ApiSession.Builder("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf").build();
//		LocationApi locationApi = session.getLocationApi();
//		CurrentConditionsApi current = session.getCurrentConditionsApi("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf");
//		
//		Optional <GeoPositionSearchResult> geoLocation = locationApi.geoPosition(target.getLat("Paris"),target.getLong("Paris"));
//		ForecastApi forecastapi= session.getForecastApi(geoLocation.get().getKey());
//		
//		apiOpenW.obtenerPronosticoExtendido("London");
//		System.out.println(forecastapi.getDailyXdays(DayPeriod.DAYS_5).get().getHeadline().getCategory());
		//		pronosticoExt.getList().stream().forEach(x->x.getMain().getTemp_max());
//		System.out.println(temp);
//		OpenWeatherDTO pronosticoHoy = apiOpenW.obtenerPronosticoActual();
//		System.out.println(pronosticoHoy.getTemp());
		

		
//		guardarropa1.verNoAbriga();
//		guardarropa1.verAbrigo();
		
		
		
		//Date today = new Date();
		
		//usuario.crearEvento(today,"Fiesta","Paris");
	
//		Evento eventoPrueba = usuario.getEvento("Fiesta");
//		System.out.println("PRUEBA 1:");
//		eventoPrueba.ejecutar();
//		System.out.println("PRUEBA 2:");
//		eventoPrueba.ejecutar();
//		System.out.println("PRUEBA 3:");
//		eventoPrueba.ejecutar();
		
		//-------------------IMAGEN
//		prenda1.setDireccionImagen("remera.jpg");
//		cargarImagenes imagen = new cargarImagenes();
//		imagen.cargarImagenes(prenda1);
		
		
		
			//---2DA ENTREGA
			
			//JsonReader json = new JsonReader();
			//json.getTipoAbrigoSecundarioMaterial().forEach(x-> System.out.println(x));
			//String nro1 = json.getParteEspecifica("Bufanda");
			//System.out.println(nro1);
//			int nro2 = json.getTipoTemperatura("Sweater");
//			System.out.println(nro2);
//			int nro3 = json.getTipoTemperatura("Campera");
//			System.out.println(nro3);
//		
//			System.out.println(guardarropa1.solicitarClima("Paris"));
//			rta.toString();
//			
		

//	}

}
