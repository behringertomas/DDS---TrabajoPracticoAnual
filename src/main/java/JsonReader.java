import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.json.simple.parser.ParseException;


public class JsonReader 
{
	private static final String DIRECTORIOJSON = "C:\\Users\\agust\\Desktop\\DDS---TrabajoPracticoAnual\\src\\main\\java\\Verificaciones.json";
	
	public static Object readJsonSimpleDemo(String filename) throws Exception
	{
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}

	public static List<String> getColores() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("Colores");		
	}

	public static List<String> getTipoParteSuperior() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoParteSuperior");		
	}

	public List<String> getTipoAbrigos() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoAbrigo");		
	}
	
	public int getTipoTemperatura(String Prenda) throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		int ubicacionTemperatura= this.getTipoAbrigos().indexOf(Prenda);
		List<String> ListaDeTemperaturas = (List<String>) jsonObject.get("TipoAbrigo");	
		int temperatura = Integer.parseInt(ListaDeTemperaturas.get(ubicacionTemperatura));
		return temperatura;
	}
	public static List<String> getTipoParteInferior() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoParteInferior");		
	}

	public static List<String> getTipoCalzado() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoCalzado");		
	}

	public static List<String> getTipoAccesorio() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoAccesorio");		
	}

	public static List<String> getMaterialParteSuperior() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoParteSuperiorMaterial");		
	}

	public static List<String> getMaterialParteInferior() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoParteInferiorMaterial");		
	}

	public static List<String> getMaterialCalzado() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoCalzadoMaterial");		
	}

	public static List<String> getMaterialAccesorio() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoAccesorioMaterial");		
	}
}