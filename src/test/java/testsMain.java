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
