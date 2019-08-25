package TPZTBCS;

import interfacesZTBCS.strategyTemperatura;

public class abrigo implements strategyTemperatura {

	@Override
	public int getTemperatura(Prenda prenda) throws Exception{
		JsonReader json = new JsonReader();
		return json.getTipoTemperatura(prenda);
	}
	

}
