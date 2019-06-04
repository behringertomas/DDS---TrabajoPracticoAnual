import java.awt.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Collection;

public class testsMain {

	public static void main(String[] args) throws Exception {
		Usuario usuario = new Usuario();
		Guardarropa guardarropa1 = new Guardarropa();
		Guardarropa guardarropa2 = new Guardarropa();
		
		usuario.agregarGuardarropas(guardarropa1);
		usuario.agregarGuardarropas(guardarropa2);
		
		Prenda prenda1  =usuario.construirPrenda("Parte Superior","Remera", "Tela", "Rojo", "Negro");
		Prenda prenda2  =usuario.construirPrenda("Parte Inferior","Pantalon Largo", "Jean", "Azul", "Negro");
		Prenda prenda3  =usuario.construirPrenda("Calzado","Runners", "Cuero", "Rojo", "Negro");
		Prenda prenda4  =usuario.construirPrenda("Accesorio","Pulsera", "Plata", "Rojo", "Negro");
		
		Prenda prenda9  =usuario.construirPrenda("Parte Superior","Musculosa", "Tela", "Rojo", "Negro");
		Prenda prenda10 =usuario.construirPrenda("Parte Inferior","Pollera", "Jean", "Azul", "Negro");
		Prenda prenda11 =usuario.construirPrenda("Calzado","Trainers", "Cuero", "Rojo", "Negro");
		Prenda prenda12 =usuario.construirPrenda("Accesorio","Lentes de Sol", "Plata", "Rojo", "Negro");
		
		Prenda prenda5  =usuario.construirPrenda("Parte Superior","Camisa", "Tela", "Rojo", "Negro");
		Prenda prenda6  =usuario.construirPrenda("Parte Inferior","Short", "Algodon", "Rojo", "Negro");
		Prenda prenda7  =usuario.construirPrenda("Calzado","Zapato", "Cuero", "Rojo", "Negro");
		Prenda prenda8  =usuario.construirPrenda("Accesorio","Reloj", "Metal", "Rojo", "Negro");
		
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda1);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda2);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda3);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda4);
		
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda5);
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda6);
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda7);
		usuario.agregarPrendaAGuardarropas(guardarropa2,prenda8);
		
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda9);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda10);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda11);
		usuario.agregarPrendaAGuardarropas(guardarropa1,prenda12);
		usuario.queMePongoATodosLosGuardarropas();
		
	}

}
