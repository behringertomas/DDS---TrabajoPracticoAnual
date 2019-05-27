import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class Guardarropa {
	
	ArrayList <Prenda> abrigo  	  = new ArrayList<Prenda>();
	ArrayList <Prenda> parteSuperior = new ArrayList<Prenda>();
	ArrayList <Prenda> parteInferior = new ArrayList<Prenda>();
	ArrayList <Prenda> accesorios	  = new ArrayList<Prenda>();
	ArrayList <Prenda> calzados 	  = new ArrayList<Prenda>();
	
	public static void generate(int n, int r) {
	    Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(n, r);
	    while (iterator.hasNext()) {
	        final int[] combination = iterator.next();
	        System.out.println(Arrays.toString(combination));
	    }
	}
	
	public void getArrayParteSuperior() {
//		this.parteSuperior.listIterator(prenda -> prenda.getTipo());
		this.parteSuperior.forEach(prenda -> prenda.getTipo());
	}

	public void agregarAGuardarropas(Prenda prenda) {	
	        switch(prenda.getParteCuerpo()) {
	        	case "Parte Superior": this.parteSuperior.add(prenda);
	            case "Parte Inferior": this.parteInferior.add(prenda);
	            case "Accesorio": this.accesorios.add(prenda);
	            case "Calzado": this.calzados.add(prenda);
	    }
			
	}
	
	public Guardarropa() {
	
	}

}
