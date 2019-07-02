package TPZTBCS;

public class abrigo implements strategyTemperatura {

	@Override
	public int getTemperatura(String tipo) throws Exception{
		JsonReader json = new JsonReader();
		return json.getTipoTemperatura(tipo);
	}
	

}
