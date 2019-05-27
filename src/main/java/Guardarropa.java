import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Guardarropa {
	
	Collection <Prenda> abrigo  	  = new ArrayList<Prenda>();
	Collection <Prenda> parteSuperior = new ArrayList<Prenda>();
	Collection <Prenda> parteInferior = new ArrayList<Prenda>();
	Collection <Prenda> accesorios	  = new ArrayList<Prenda>();
	Collection <Prenda> calzados 	  = new ArrayList<Prenda>();
	
	public static void generate(int n, int r) {
	    Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(n, r);
	    while (iterator.hasNext()) {
	        final int[] combination = iterator.next();
	        System.out.println(Arrays.toString(combination));
	    }
	}
	
	public static void sugerir() {
		
	}
	
//	public ArrayList<Prenda> getParteSuperior() {
//		return parteSuperior.stream().
//	}
	
	public void agregarAGuardarropas(Prenda prenda) {
		
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
