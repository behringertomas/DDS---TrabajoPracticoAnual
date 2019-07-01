import com.weathertest.MainWeather;
import com.weathertest.ZonaYTemperatura;

public class AdapterAPI implements ITargetAPI {
	
	MainWeather apixu;
	//falta otro constructor de otra api
	
	public AdapterAPI(MainWeather apixu) {
		this.apixu = apixu;
	}
	public ZonaYTemperatura request() {
		return this.apixu.getWeather();
	}
	public ZonaYTemperatura request(String ciudad) {
		return this.apixu.getWeather(ciudad);
	}
}
