package test;


import com.proveedores.openweather.ExtendedOpenWeatherDTO;
import com.proveedores.openweather.OpenWeatherDTO;
import com.proveedores.openweather.OpenWeather;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


public class testsClima {

	OpenWeather proveedor = new OpenWeather();

	@Test
	public void obtenerPronosticoActual() {
		OpenWeatherDTO pronostico = proveedor.obtenerPronosticoActual();
		Assert.assertTrue(pronostico != null);
	}

	@Test
	public void obtenerPronosticoExtendido() {
		ExtendedOpenWeatherDTO pronostico = proveedor.obtenerPronosticoExtendido();
		Assert.assertFalse(pronostico.getList().isEmpty());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void obtenerTemperaturATalDia() {
		Date aux = new java.util.Date();
		aux.setDate(aux.getDate() + 1);
		String localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aux);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate fechaDelClima = LocalDate.parse(localDate, formatter);

		Assert.assertTrue(proveedor.obtenerTemperaturATalDia(fechaDelClima) != null);
	}
	

	@Test
	public void estaActivo() {
		Assert.assertTrue(proveedor.estaActivo());
	}
}