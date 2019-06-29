import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Atuendo
{	
	List <Prenda> prendas;
	
	public Atuendo(List<Prenda> prenda)
	{
		this.prendas= prenda;
	}
	
	public void imprimirPrendas() 
	{
		this.prendas.forEach(prenda->prenda.imprimirDescripcion());
		
	}	
	
	public int cuantoAbriga() {
	 return prendas.stream().mapToInt(x->x.getTemperatura()).sum();
	}
}