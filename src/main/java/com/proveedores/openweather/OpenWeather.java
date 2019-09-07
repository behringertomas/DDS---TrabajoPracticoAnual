package com.proveedores.openweather;

//import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


//----------

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;


import com.fasterxml.jackson.core.type.TypeReference;
import com.utils.JsonParser;

import TPZTBCS.JsonReader;


public class OpenWeather implements IProveedores {
	private Client client;
	private static final String key = "b401579bf8682516861b9ec403bd2234";
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
	
	
	@Override
	public Double obtenerTemperaturATalDia(LocalDate fecha) { // EL FORMATO DE LA FECHA PASADO DEBE SER dd/mm/aaaa
		ExtendedOpenWeatherDTO pronosticoExtendido = obtenerPronosticoExtendido();
		List<ExtendedMain> pronosticoDelDiaCadaTresHoras = pronosticoExtendido.getList().stream()
				.filter(clima -> esElClimaDeLaFecha(clima, fecha)).collect(Collectors.toList());
		ExtendedMain pronosticoDelDia = pronosticoDelDiaCadaTresHoras.get(0);
		return pronosticoDelDia.getTemp();
	}

	public Double obtenerTemperaturATalDia(LocalDate fecha, String ciudad) { // EL FORMATO DE LA FECHA PASADO DEBE SER dd/mm/aaaa
		ExtendedOpenWeatherDTO pronosticoExtendido = obtenerPronosticoExtendido(ciudad);
		List<ExtendedMain> pronosticoDelDiaCadaTresHoras = pronosticoExtendido.getList().stream()
				.filter(clima -> esElClimaDeLaFecha(clima, fecha)).collect(Collectors.toList());
		ExtendedMain pronosticoDelDia = pronosticoDelDiaCadaTresHoras.get(0);
		return pronosticoDelDia.getTemp();
	}
	
	
	@Override
	public Boolean esElClimaDeLaFecha(ExtendedMain clima, LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate fechaDelClima = LocalDate.parse(clima.getDt_txt(), formatter);

		return fecha.equals(fechaDelClima);
	}

	@Override
	public Boolean estaActivo() {
		return true;
	}
}