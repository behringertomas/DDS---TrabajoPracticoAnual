import java.awt.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Collection;

public class testsMain {

	public static void main(String[] args) throws Exception {
		Usuario usuario = new Usuario();
		Guardarropa guardarropa1 = new Guardarropa();
		Guardarropa guardarropa2 = new Guardarropa();
		
		Prenda prenda1 =usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
		Prenda prenda2 =usuario.construirPrenda("Parte Inferior","Pantalon Largo", "Jean", "Azul", "Negro");
		Prenda prenda3 =usuario.construirPrenda("Calzado","Runners", "Cuero", "Rojo", "Negro");
		Prenda prenda4 =usuario.construirPrenda("Accesorio","Pulsera", "Plata", "Rojo", "Negro");
		
		guardarropa1.agregarAGuardarropas(prenda1);
		guardarropa1.agregarAGuardarropas(prenda2);
		guardarropa1.agregarAGuardarropas(prenda3);
		guardarropa1.agregarAGuardarropas(prenda4);
		
		Prenda prenda5 =usuario.construirPrenda("Parte Superior","Camisa", "Tela", "Rojo", "Negro");
		Prenda prenda6 =usuario.construirPrenda("Parte Inferior","Short", "Algodon", "Rojo", "Negro");
		Prenda prenda7 =usuario.construirPrenda("Calzado","Zapato", "Cuero", "Rojo", "Negro");
		Prenda prenda8 =usuario.construirPrenda("Accesorio","Reloj", "Metal", "Rojo", "Negro");
		
		guardarropa2.agregarAGuardarropas(prenda5);
		guardarropa2.agregarAGuardarropas(prenda6);
		guardarropa2.agregarAGuardarropas(prenda7);
		guardarropa2.agregarAGuardarropas(prenda8);
		
		usuario.queMePongoATodosLosGuardarropas();
		
	}

}
