import com.weathertest.ZonaYTemperatura;

public interface ITargetAPI {
	ZonaYTemperatura request();
	ZonaYTemperatura request(String ciudad);
}
