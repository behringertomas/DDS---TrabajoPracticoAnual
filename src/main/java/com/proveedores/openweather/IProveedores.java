package com.proveedores.openweather;

import java.time.LocalDate;

public interface IProveedores {

	OpenWeatherDTO obtenerPronosticoActual();

	ExtendedOpenWeatherDTO obtenerPronosticoExtendido();

	Double obtenerTemperaturATalDia(LocalDate fecha);

	Boolean esElClimaDeLaFecha(ExtendedMain clima, LocalDate fecha);

	Boolean estaActivo();
}
