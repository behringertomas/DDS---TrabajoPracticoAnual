package com.codecrafters.openweathermap.api;
import com.codecrafters.openweathermap.data.CurrentWeatherInfo;
import com.codecrafters.openweathermap.data.ForecastWeatherInfo;
import com.codecrafters.openweathermap.data.WeatherInfo;

public class testsMain {
	private static final String CITY_NAME = "London";
    private static OpenWeatherMap openWeatherMap = new OpenWeatherMap("b401579bf8682516861b9ec403bd2234");
    
    private static void printWeatherInfo(WeatherInfo weatherInfo) {
        System.out.println(weatherInfo.getDateTime().toLocalDateTime() + " -> " + weatherInfo.getTemperatureInfo().getTemperature().inCelsius());
    }
    
	public static void main(String[] args) {
		
		CurrentWeatherInfo currentWeatherInfo = openWeatherMap.getCurrentWeather("Buenos Aires,BA"); 

	}

}
