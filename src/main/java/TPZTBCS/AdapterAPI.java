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
}
