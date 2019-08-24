package com.weatherlibraryjava;
import com.weatherlibrary.datamodel.WeatherModel;
import com.weatherlibraryjava.IRepository;
import com.weatherlibraryjava.Repository;
import com.weatherlibraryjava.RequestBlocks.GetBy;
import TPZTBCS.*;

public class WeatherApixu {
	
		String key = "6252e1d72dde486ea07170507192408";
		 
		public double getLatitud(String ciudad) {
			WeatherApixu obj = new WeatherApixu();
			IRepository repo = new Repository();
			
			try {
				
				WeatherModel weatherModel = repo.GetWeatherData(obj.key, GetBy.CityName, ciudad);	
				return weatherModel.location.lat;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
		
		public double getLongitud(String ciudad) {
			WeatherApixu obj = new WeatherApixu();
			IRepository repo = new Repository();
			
			try {
				
				WeatherModel weatherModel = repo.GetWeatherData(obj.key, GetBy.CityName, ciudad);
				return weatherModel.location.lon;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			
		}
		
		public ZonaYTemperatura getWeather() { //request del adapter.
			WeatherApixu obj = new WeatherApixu();
			IRepository repo = new Repository();
		
			try {
				
				WeatherModel weatherModel = repo.GetWeatherDataByAutoIP(obj.key);
				ZonaYTemperatura respuesta = new ZonaYTemperatura(weatherModel.location.name,weatherModel.current.temp_c);
				return respuesta;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		public ZonaYTemperatura getWeather(String ciudad) { //request del adapter.
			WeatherApixu obj = new WeatherApixu();
			IRepository repo = new Repository();
		
			try {
		
				WeatherModel weatherModel = repo.GetWeatherData(obj.key, GetBy.CityName, ciudad);
				ZonaYTemperatura respuesta = new ZonaYTemperatura(weatherModel.location.name,weatherModel.current.temp_c);
				return respuesta;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}

//		public static void main(String[] args) {
//			
//			MainWeather obj = new MainWeather();
//			
//			IRepository repo = new Repository();
//			
//			try {
//	
//				WeatherModel weatherModel = repo.GetWeatherData(obj.key, GetBy.CityName, "Cordoba");
//				System.out.println("WeatherTestJava : location name==============>"+weatherModel.location.name);
//				System.out.println("WeatherTestJava : Temp==============>"+weatherModel.current.temp_c);
//				
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
}
