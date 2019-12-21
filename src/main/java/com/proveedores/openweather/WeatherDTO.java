package com.proveedores.openweather;
import com.proveedores.openweather.Weather;

public class WeatherDTO {
	private Weather weather;

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	
	public String getDesc() { // Aca es anti-intuitivo, pero voy a hacer un getMain porque me da una descripcion exacta. La otra es mas larga
		return this.weather.getMain();
	}
}
