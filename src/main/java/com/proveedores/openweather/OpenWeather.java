package com.proveedores.openweather;

//import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.time.Instant;

//----------

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;


import com.fasterxml.jackson.core.type.TypeReference;
import com.github.prominence.openweathermap.api.DailyForecastRequester;
import com.github.prominence.openweathermap.api.HourlyForecastRequester;
import com.github.prominence.openweathermap.api.OpenWeatherMapManager;
import com.github.prominence.openweathermap.api.constants.Accuracy;
import com.github.prominence.openweathermap.api.constants.Language;
import com.github.prominence.openweathermap.api.constants.Unit;
import com.github.prominence.openweathermap.api.model.response.DailyForecast;
import com.github.prominence.openweathermap.api.model.response.HourlyForecast;
import com.utils.JsonParser;
import com.utils.Utils;
import com.proveedores.openweather.WeatherDTO;

import TPZTBCS.JsonReader;


public class OpenWeather implements IProveedores {
	private Client client;
	private static final String key = "691b222f7f69f1389e3414cd964b74bc";
	private JsonParser jsonParser = new JsonParser();

	public static final String pronosticoActualUrl = "http://api.openweathermap.org/data/2.5/weather";
	public static final String pronosticoPorHoraUrl = "http://api.openweathermap.org/data/2.5/forecast";

	public OpenWeather() {
	}

	@Override
	public OpenWeatherDTO obtenerPronosticoActual() {
		client = Client.create();
		WebResource webResource = client.resource(pronosticoActualUrl).queryParam("id", "3433955").queryParam("appid",
				key);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String output = response.getEntity(String.class);
		return jsonParser.read(output, new TypeReference<OpenWeatherDTO>() {
		});
	}

	public OpenWeatherDTO obtenerPronosticoActual(String ciudad) {
		client = Client.create();
		WebResource webResource = client.resource(pronosticoActualUrl+"?q="+ciudad.replaceAll(" ", "%20")).queryParam("id", "3433955").queryParam("appid",
				key);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String output = response.getEntity(String.class);
		return jsonParser.read(output, new TypeReference<OpenWeatherDTO>() {
		});
	}
	
//	public WeatherDTO obtenerDescripcionActual() {
//		client = Client.create();
//		WebResource webResource = client.resource(pronosticoActualUrl).queryParam("id", "3433955").queryParam("appid",
//				key);
//		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
//		String output = response.getEntity(String.class);
//		return jsonParser.read(output, new TypeReference<WeatherDTO>() {
//		});
//	}
//	
//	public WeatherDTO obtenerDescripcionActual(String ciudad) {
//		client = Client.create();
//		WebResource webResource = client.resource(pronosticoActualUrl+"?q="+ciudad.replaceAll(" ", "%20")).queryParam("id", "3433955").queryParam("appid",
//				key);
//		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
//		String output = response.getEntity(String.class);
//		return jsonParser.read(output, new TypeReference<WeatherDTO>() {
//		});
//	}
	
//	-----------------------------------------------------------------------------------------------
	
//	public ExtendedWeatherDTO obtenerPronosticoDescripcionExtendido() {
//		client = Client.create();
//		WebResource webResource = client.resource(pronosticoPorHoraUrl).queryParam("id", "3433955").queryParam("appid",
//				key);
//		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
//		String output = response.getEntity(String.class);
//		return jsonParser.read(output, new TypeReference<ExtendedWeatherDTO>() {});
//	}
//
//	public ExtendedWeatherDTO obtenerPronosticoDescripcionExtendido(String ciudad) {
//		client = Client.create();
//		WebResource webResource = client.resource(pronosticoPorHoraUrl+"?q="+ciudad.replaceAll(" ", "%20")).queryParam("id", "3433955").queryParam("appid",
//				key);
//		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
//		String output = response.getEntity(String.class);
//		
//		return jsonParser.read(output, new TypeReference<ExtendedWeatherDTO>() {});
//	}
	
//	-----------------------------------------------------------------------------------------------
	
	@Override
	public ExtendedOpenWeatherDTO obtenerPronosticoExtendido() {
		client = Client.create();
		WebResource webResource = client.resource(pronosticoPorHoraUrl).queryParam("id", "3433955").queryParam("appid",
				key);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String output = response.getEntity(String.class);
		return jsonParser.read(output, new TypeReference<ExtendedOpenWeatherDTO>() {
		});
	}

	
	public ExtendedOpenWeatherDTO obtenerPronosticoExtendido(String ciudad) {
		client = Client.create();
		WebResource webResource = client.resource(pronosticoPorHoraUrl+"?q="+ciudad.replaceAll(" ", "%20")).queryParam("id", "3433955").queryParam("appid",
				key);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String output = response.getEntity(String.class);
		
		//System.out.print(output);	
		
		//return null;
		return jsonParser.read(output, new TypeReference<ExtendedOpenWeatherDTO>() {});
	}
	
	
	
//	@Override
//	public float obtenerTemperaturATalDia(LocalDate fecha) { // EL FORMATO DE LA FECHA PASADO DEBE SER dd/mm/aaaa
//		ExtendedOpenWeatherDTO pronosticoExtendido = obtenerPronosticoExtendido();
//		List<ExtendedMain> pronosticoDelDiaCadaTresHoras = pronosticoExtendido.getList().stream()
//				.filter(clima -> esElClimaDeLaFecha(clima, fecha)).collect(Collectors.toList());
//		ExtendedMain pronosticoDelDia = pronosticoDelDiaCadaTresHoras.get(0);
//		return pronosticoDelDia.getTemp();
//	}

	public Double obtenerTemperaturATalDia(LocalDate fecha, String ciudad) { // EL FORMATO DE LA FECHA PASADO DEBE SER dd/mm/aaaa
		ExtendedOpenWeatherDTO pronosticoExtendido = obtenerPronosticoExtendido(ciudad);
		List<ExtendedMain> pronosticoDelDiaCadaTresHoras = pronosticoExtendido.getList().stream()
				.filter(clima -> esElClimaDeLaFecha(clima, fecha)).collect(Collectors.toList());
		ExtendedMain pronosticoDelDia = pronosticoDelDiaCadaTresHoras.get(0);
		return pronosticoDelDia.getTemp();
	}
	
	
//	public String obtenerDescripcionATalDia(LocalDate fecha) { // EL FORMATO DE LA FECHA PASADO DEBE SER dd/mm/aaaa
//		ExtendedWeatherDTO pronosticoExtendido = obtenerPronosticoDescripcionExtendido();
//		List<ExtendedWeather> pronosticoDelDiaCadaTresHoras = pronosticoExtendido.getList().stream()
//				.filter(clima -> esElClimaDeLaFecha_Descripcion(clima, fecha)).collect(Collectors.toList());
//		ExtendedWeather pronosticoDelDia = pronosticoDelDiaCadaTresHoras.get(0);
//		return pronosticoDelDia.getDesc();
//	}
//	
//	public String obtenerDescripcionATalDia(LocalDate fecha, String ciudad) { // EL FORMATO DE LA FECHA PASADO DEBE SER dd/mm/aaaa
//		ExtendedWeatherDTO pronosticoExtendido = obtenerPronosticoDescripcionExtendido(ciudad);
//		List<ExtendedWeather> pronosticoDelDiaCadaTresHoras = pronosticoExtendido.getList().stream()
//				.filter(clima -> esElClimaDeLaFecha_Descripcion(clima, fecha)).collect(Collectors.toList());
//		ExtendedWeather pronosticoDelDia = pronosticoDelDiaCadaTresHoras.get(0);
//		return pronosticoDelDia.getDesc();
//	}
	
	
	@Override
	public Boolean esElClimaDeLaFecha(ExtendedMain clima, LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate fechaDelClima = LocalDate.parse(clima.getDt_txt(), formatter);

		return fecha.equals(fechaDelClima);
	}

	public Boolean esElClimaDeLaFecha_Descripcion(ExtendedWeather clima, LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate fechaDelClima = LocalDate.parse(clima.getDt_txt(), formatter);

		return fecha.equals(fechaDelClima);
	}
	
	@Override
	public Boolean estaActivo() {
		return true;
	}
	
// METODOS NUEVOS 
	
	public double get_temperatura_de_hoy(String ciudad) {
		OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager(key);
    	HourlyForecastRequester forecastRequester = openWeatherManager.getHourlyForecastRequester();
    	
    	HourlyForecast forecastResponse = forecastRequester
    		    .setLanguage(Language.ENGLISH)
    		    .setUnitSystem(Unit.METRIC_SYSTEM)
    		    .setAccuracy(Accuracy.ACCURATE)
    		    .getByCityName(ciudad);
    	
    	return forecastResponse.getAverageTemperature();
	}
	
	public String get_descripcion_de_hoy(String ciudad) {
		OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager(key);
    	HourlyForecastRequester forecastRequester = openWeatherManager.getHourlyForecastRequester();
    	
    	HourlyForecast todayResponse = forecastRequester
    		    .setLanguage(Language.ENGLISH)
    		    .setUnitSystem(Unit.METRIC_SYSTEM)
    		    .setAccuracy(Accuracy.ACCURATE)
    		    .getByCityName(ciudad);
    	
    	return todayResponse.getForecasts().get(0).getWeatherStates().get(0).toString();
	}
	
	public String get_descripcion_tal_dia(String ciudad, Date fechaEvento) {
		
		Date date = new java.util.Date(); 
		
		int dias_restantes = (int) Math.ceil(((fechaEvento.getTime()-date.getTime())/86400000));
		if (dias_restantes == 0) dias_restantes++;
		OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager(key);
//		DailyForecastRequester forecastRequester = openWeatherManager.getDailyForecastRequester();
		
		HourlyForecastRequester forecastRequester = openWeatherManager.getHourlyForecastRequester();
    	HourlyForecast forecastResponse = forecastRequester
    		    .setLanguage(Language.ENGLISH)
    		    .setUnitSystem(Unit.METRIC_SYSTEM)
    		    .setAccuracy(Accuracy.ACCURATE)
    		    .getByCityName(ciudad);
		
//		DailyForecast forecastResponse = forecastRequester
//			    .setAmountOfDays(dias_restantes)
//			    .getByCityName(ciudad);
		
		return forecastResponse.getForecasts().get(0).getWeatherStates().get(0).toString();
	}

	@Override
	public Double obtenerTemperaturATalDia(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public int dias_restantes(Date fechaEvento) {
		Date date = new java.util.Date(); 
		
		int dias_restantes = (int) Math.ceil(((fechaEvento.getTime()-date.getTime())/86400000));
		if (dias_restantes == 0) dias_restantes++;
		
		return dias_restantes;
	}
	
	
}