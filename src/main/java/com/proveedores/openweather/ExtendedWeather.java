package com.proveedores.openweather;

import com.proveedores.openweather.Weather;

public class ExtendedWeather {
	private Weather[] weather;
	private String dt_txt;
	
	
	public Weather getWeather() {
		return weather[0];
	}
	public void setWeather(Weather weather) {
		this.weather[0] = weather;
	}
	
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public String getDesc() {
		return this.weather[0].getMain();
	}

}
