import java.awt.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.paukov.combinatorics3.Generator;

import java.util.Collection;
import java.util.Date;

import com.weathertest.ZonaYTemperatura;

import TPZTBCS.Evento;
import TPZTBCS.Guardarropa;
import TPZTBCS.JsonReader;
import TPZTBCS.Prenda;
import TPZTBCS.Usuario;
import TPZTBCS.cargarImagenes;


public class testsMain {

	public static void main(String[] args) throws Exception {
		
		Usuario usuario = new Usuario();
		
		Guardarropa guardarropa1 = new Guardarropa("Guardarropa	Verano");
		Guardarropa guardarropa2 = new Guardarropa("Guardarropa Primavera");
		
		usuario.agregarGuardarropas(guardarropa1);
		usuario.agregarGuardarropas(guardarropa2);
		
		Prenda prenda1  =usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
		Prenda prenda2  =usuario.construirPrenda("Parte Inferior","Pantalon Largo", "Jean", "Azul", "Negro");
		Prenda prenda3  =usuario.construirPrenda("Calzado","Runners", "Algodon", "Rojo", "Negro");
		Prenda prenda4  =usuario.construirPrenda("Accesorio","Pulsera", "Plata", "Rojo", "Negro");
		
		Prenda prenda9  =usuario.construirPrenda("Parte Superior","Musculosa", "Tela", "Rojo", "Negro");
		Prenda prenda10 =usuario.construirPrenda("Parte Inferior","Pollera", "Jean", "Azul", "Negro");
		Prenda prenda11 =usuario.construirPrenda("Calzado","Trainers", "Cuero", "Rojo", "Negro");
		Prenda prenda12 =usuario.construirPrenda("Accesorio","Lentes de Sol", "Plata", "Rojo", "Negro");
		
		Prenda prenda5  =usuario.construirPrenda("Parte Superior","Camisa", "Tela", "Rojo", "Negro");
		Prenda prenda6  =usuario.construirPrenda("Parte Inferior","Short", "Algodon", "Rojo", "Negro");
		Prenda prenda7  =usuario.construirPrenda("Calzado","Zapato", "Cuero", "Rojo", "Negro");
		Prenda prenda8  =usuario.construirPrenda("Accesorio","Reloj", "Metal", "Rojo", "Negro");
		
		Prenda prenda13 =usuario.construirPrenda("Parte Superior", "Campera", "Cuero", "Negro");
		Prenda prenda14 =usuario.construirPrenda("Parte Superior", "Sweater", "Algodon", "Blanco");
		
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda1);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda3);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda4);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda6);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda9);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda10);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda11);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda12);
		
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda2);
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda5);
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda7);
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda8);
		
		usuario.agregarPrendaAGuardarropas(guardarropa1, prenda13);
		usuario.agregarPrendaAGuardarropas(guardarropa1, prenda14);
		
//		guardarropa1.verNoAbriga();
//		guardarropa1.verAbrigo();
		
		//guardarropa1.queMePongo("Paris",usuario.getFrio());
		
		
		Date today = new Date();
		
		usuario.crearEvento(today,"Fiesta","Paris");
	
//		Evento eventoPrueba = usuario.getEvento("Fiesta");
//		System.out.println("PRUEBA 1:");
//		eventoPrueba.ejecutar();
//		System.out.println("PRUEBA 2:");
//		eventoPrueba.ejecutar();
//		System.out.println("PRUEBA 3:");
//		eventoPrueba.ejecutar();
		
		//-------------------IMAGEN
//		prenda1.setDireccionImagen("remera.jpg");
//		cargarImagenes imagen = new cargarImagenes();
//		imagen.cargarImagenes(prenda1);
		
		
		
		//---2DA ENTREGA
		
//		JsonReader json = new JsonReader();
//		json.getTipoAbrigos().forEach(x-> System.out.println(x));
//		int nro1 = json.getTipoTemperatura("Buzo");
//		System.out.println(nro1);
//		int nro2 = json.getTipoTemperatura("Sweater");
//		System.out.println(nro2);
//		int nro3 = json.getTipoTemperatura("Campera");
//		System.out.println(nro3);
		
//		TPZTBCS.ZonaYTemperatura rta= guardarropa1.solicitarClima("Paris");
//		rta.toString();
		
		

	}

}
