package TPZTBCS;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.simple.parser.ParseException;


public class JsonReader 
{
	static File f = new File("Verificaciones.json"); 
	private static final String DIRECTORIOJSON= f.getAbsolutePath();
	
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

	public static List<String> getTipoAbrigos() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoAbrigo");		
	}
	
	public int getTipoTemperatura(Prenda Prenda) throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		if (Prenda.getParteCuerpo()=="Parte Superior") {
		
		int ubicacionTemperatura= this.getTipoAbrigos().indexOf(Prenda.getTipo());
		List<String> ListaDeTemperaturas = (List<String>) jsonObject.get("TemperaturasAbrigo");	
		int temperatura = Integer.parseInt(ListaDeTemperaturas.get(ubicacionTemperatura));
		return temperatura;
		}
		if(Prenda.getParteCuerpo()=="Accesorio") {
		
		int ubicacionTemperatura= this.getTipoAbrigoSecundario().indexOf(Prenda.getTipo());
		List<String> ListaDeTemperaturas = (List<String>) jsonObject.get("TemperaturasAbrigoAccesorio");	
		int temperatura = Integer.parseInt(ListaDeTemperaturas.get(ubicacionTemperatura));
		return temperatura;
			
		}
		return 0;
	}
	
	public static String getParteEspecifica(String Prenda) throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		int ubicacionTemperatura= JsonReader.getTipoAbrigoSecundario().indexOf(Prenda);
		List<String> ListaDeTemperaturas = (List<String>) jsonObject.get("TipoAbrigoSecundarioParte");	
		String temperatura = ListaDeTemperaturas.get(ubicacionTemperatura);
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
	
	public static List<String> getTipoAbrigoSecundario() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoAbrigoSecundario");		
	}
	public static List<String> getTipoAbrigoSecundarioMaterial() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TipoAbrigoSecundarioMaterial");		
	}
	
	public static List<String> getTemperaturasAbrigoAccesorio() throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		return (List<String>) jsonObject.get("TemperaturasAbrigoAccesorio");		
	}
	
	public int getTipoTemperaturaSecundario(String Prenda) throws Exception
	{
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(DIRECTORIOJSON);
		int ubicacionTemperatura= this.getTipoAbrigoSecundario().indexOf(Prenda);
		List<String> ListaDeTemperaturas = (List<String>) jsonObject.get("TemperaturasAbrigoAccesorio");	
		int temperatura = Integer.parseInt(ListaDeTemperaturas.get(ubicacionTemperatura));
		return temperatura;
	}
	
	public String getDescripcion(String output) throws Exception
	{
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(output);
		String ListaWeather = (String) json.get("weather");
		System.out.print(ListaWeather);
		return ListaWeather;
	}

	
	
	
	
}