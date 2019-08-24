package TPZTBCS;

import com.weatherlibraryjava.WeatherApixu;

public class AdapterAPI implements ITargetAPI {
	
	WeatherApixu apixu;
	//falta otro constructor de otra api
	
	public AdapterAPI(WeatherApixu apixu) {
		this.apixu = apixu;
	}
	public ZonaYTemperatura request() {
		return this.apixu.getWeather();
	}
	public ZonaYTemperatura request(String ciudad) {
		return this.apixu.getWeather(ciudad);
	}
	
	public double getLat(String ciudad) {
		return this.apixu.getLatitud(ciudad);
	}
	
	public double getLong(String ciudad) {
		return this.apixu.getLongitud(ciudad);
	}
	
}
