package com.codecrafters.openweathermap.api;
import com.codecrafters.openweathermap.data.CurrentWeatherInfo;
import com.codecrafters.openweathermap.data.ForecastWeatherInfo;
import com.codecrafters.openweathermap.data.WeatherInfo;

public class testsMain {
	private static final String CITY_NAME = "London";
    private static OpenWeatherMap openWeatherMap = new OpenWeatherMap("75538e7aa1c4f65ae1d6e1646cf75ed6");
    
    private static void printWeatherInfo(WeatherInfo weatherInfo) {
        System.out.println(weatherInfo.getDateTime().toLocalDateTime() + " -> " + weatherInfo.getTemperatureInfo().getTemperature().inCelsius());
    }
    
	public static void main(String[] args) {
		
		CurrentWeatherInfo currentWeatherInfo = openWeatherMap.getCurrentWeather(CITY_NAME); 

	}

}
