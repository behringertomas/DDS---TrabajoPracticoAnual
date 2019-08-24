package TPZTBCS;

public interface ITargetAPI {
	
	ZonaYTemperatura request();
	ZonaYTemperatura request(String ciudad);
	
	double getLat(String ciudad);
	double getLong(String ciudad);
}
