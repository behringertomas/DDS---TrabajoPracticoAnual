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

	public static void sugerir() {
		
	}

	public void agregarAGuardarropas(Prenda prenda) {	
	        switch(prenda.getParteCuerpo()) {
	            case "Parte Inferior": this.agregarCalzado(prenda);
	            case "Accesorio": this.agregarAccesorios(prenda);
	            case "Parte Superior": this.agregarPS(prenda);
	            case "Calzado": this.agregarCalzado(prenda);
	    }
			
	}
	
	public void agregarAbrigo(Prenda prenda) {
        this.abrigo.add(prenda);
    }
    public void agregarPS(Prenda prenda) {
        this.parteSuperior.add(prenda);
    }
    public void agregarPI(Prenda prenda) {
        this.parteInferior.add(prenda);
    }
    public void agregarCalzado(Prenda prenda) {
        this.calzados.add(prenda);
    }
    public void agregarAccesorios(Prenda prenda) {
        this.accesorios.add(prenda);
    }
	
	public int getCantParteSuperior() {
		return this.parteSuperior.size();
	}
	
	public int getCantParteInferior() {
		return this.parteInferior.size();
	}
	
	public int getCantCalzado() {
		return this.calzados.size();
	}
	
	public int getCantAccesorios() {
		return this.accesorios.size();
	}
	
//	public ArrayList<String> getArrayParteSuperior(){
//		return 
//	}
//	public List<int[]> generate(int n, int r) {
//	    List<int[]> combinations = new ArrayList<>();
//	    helper(combinations, new int[r], 0, n-1, 0);
//	    return combinations;
//	}
	
//	public int getCantPrendasTotal() {
//		return this.prendas.size();
//	}
	
	
	public Guardarropa() {
	
	}

}
