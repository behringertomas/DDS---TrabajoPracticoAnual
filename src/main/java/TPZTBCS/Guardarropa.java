package TPZTBCS;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.util.MathUtils;
import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.IGenerator;
import org.paukov.combinatorics3.SubSetGenerator;

import com.weatherlibraryjava.WeatherApixu;

public class Guardarropa 
{
	ITargetAPI target = new AdapterAPI( new WeatherApixu() ); //apixu
	String identificador;
	int limiteDePrendas;
	
	public Guardarropa(String identificador,int limiteDePrendas)
	{
		this.identificador = identificador;
		this.limiteDePrendas = limiteDePrendas;
	}
	
	public Guardarropa(String identificador)
	{
		this.identificador = identificador;
		this.limiteDePrendas = 99999;
	}
	
	ArrayList <Prenda> parteSuperior = new ArrayList<Prenda>();
	ArrayList <Prenda> parteInferior = new ArrayList<Prenda>();
	ArrayList <Prenda> accesorios = new ArrayList<Prenda>();
	ArrayList <Prenda> calzados = new ArrayList<Prenda>();
	

	
//-------------------AGREGAR PRENDA A GUARDARROPAS-------------------- 
	
	public void agregarAGuardarropas(Prenda prenda) throws Exception
	{	
		if(!prenda.estaEnGuardarropa()) {
			if(this.numeroTotalEnGuardarropa() < limiteDePrendas) {
				switch(prenda.getParteCuerpo()) 
				{
				case "Parte Superior":
					this.parteSuperior.add(prenda);
					prenda.meterEnGuardarropa();
					break;
				case "Parte Inferior": 
					this.parteInferior.add(prenda);
					prenda.meterEnGuardarropa();
					break;
				case "Accesorio":
					this.accesorios.add(prenda);
					prenda.meterEnGuardarropa();
					break;
				case "Calzado": 
					this.calzados.add(prenda);
					prenda.meterEnGuardarropa();
					break;
				default:
					System.out.println("ESTE ELEMENTO NO PERTENECE A NINGUNA LISTA");
					break;
				} 
		}
			else throw new Exception("GUARDARROPA LLENO CREE UNO NUEVO");
	}
		else throw new Exception("PRENDA YA SE ENCUENTRA EN UN GUARDARROPA");
}
//-------------------MOSTRAR LOS ARRAYS DEL GUARDARROPA-------------------- 
	
	public ArrayList<String> getArrayParteSuperior() 
	{
		ArrayList <String> arrayParteSuperior = new ArrayList <String>(this.parteSuperior.stream().map(prenda -> prenda.getTipo()).collect(Collectors.toList()));
		arrayParteSuperior.forEach(System.out::println);
		return arrayParteSuperior;
	}
	
	public ArrayList<String> getArrayParteInferior() 
	{
		ArrayList <String> arrayParteInferior = new ArrayList <String>(this.parteInferior.stream().map(prenda -> prenda.getTipo()).collect(Collectors.toList()));
		return arrayParteInferior;
	}
	
	public ArrayList<String> getArrayAccesorios() 
	{
		ArrayList <String> arrayAccesorios = new ArrayList <String>(this.accesorios.stream().map(prenda -> prenda.getTipo()).collect(Collectors.toList()));
		return arrayAccesorios;
	}
	
	public ArrayList<String> getArrayCalzado() 
	{
		ArrayList <String> arrayCalzado = new ArrayList <String>(this.calzados.stream().map(prenda -> prenda.getTipo()).collect(Collectors.toList()));
		return arrayCalzado;
	}


//-------------------CLIMA --------------------
	public ZonaYTemperatura solicitarClima() {
//		this.target.request().toString();
		return this.target.request();
	}
	public ZonaYTemperatura solicitarClima(String ciudad) {
//		this.target.request().toString();
		return this.target.request(ciudad);
	}
	
	
	
//-------------------FUNCION PRINCIPAL --------------------
		
	public Atuendo queMePongo(String ciudad) 
	{
		if(this.verificarArrayList()) 
		{

		    Atuendo atuendoElegido = new Atuendo(this.combinaciones(ciudad));
		    System.out.println("Atuendo de: " + this.identificador);
		    atuendoElegido.imprimirPrendas();
		    System.out.println("");
		    return atuendoElegido;
		}
		else
		{
			System.out.println(this.identificador + " no posee atuendos");
			return null;
		}
	}
	
	
//-------------------------Funcion de combinaciones----------------------- 
	
	public void verNoAbriga() {
		ArrayList <Prenda> noAbriga =(ArrayList <Prenda>) parteSuperior.stream().filter(x->{
			try {
				return x.getTemperatura()==0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} return (Boolean) null;
		}).collect(Collectors.toList());
		
		noAbriga.forEach(x->x.imprimirDescripcion());
	}
	
	public void verAbrigo() {
		ArrayList <Prenda> abrigo =(ArrayList <Prenda>) parteSuperior.stream().filter(x->{
			try {
				return x.getTemperatura()>0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} return (Boolean) null;
		}).collect(Collectors.toList());
		
		abrigo.forEach(x->x.imprimirDescripcion());
	}
	
	
	public List<Prenda> combinaciones(String ciudad)
	{
		
		ArrayList <Prenda> noAbriga =(ArrayList <Prenda>) parteSuperior.stream().filter(x->{
			try {
				return x.getTemperatura()==0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} return (Boolean) null;
		}).collect(Collectors.toList());
		
		ArrayList <Prenda> abrigo = (ArrayList <Prenda>) parteSuperior.stream().filter(x->{
			try {
				return x.getTemperatura()>0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return (Boolean) null;
		}).collect(Collectors.toList());
		
		ZonaYTemperatura zonaYTemp = target.request(ciudad);
		double temp = zonaYTemp.temp;
		IGenerator<List<Prenda>> combinaciones = Generator.cartesianProduct(noAbriga, this.parteInferior, this.accesorios, this.calzados);
		
		ArrayList<List<Prenda>> arrayListCombinaciones = new ArrayList<List<Prenda>>();
		
		combinaciones.forEach(Lista->arrayListCombinaciones.add(Lista));
		int rndNoAbrigos = new Random().nextInt(arrayListCombinaciones.size());
		List <Prenda> combinacionesNoAbrigos = arrayListCombinaciones.get(rndNoAbrigos);
		
		if(temp<=15) {
			SubSetGenerator<Prenda> combinacionesAbrigo =  Generator.subset(abrigo);
				
			List <List<Prenda>> combinacionesValidas = combinacionesAbrigo.simple().stream().filter(x->x.stream().mapToInt(
					a->{
						try {
							return a.getTemperatura();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return 0;
				}).sum() > (15-temp)).collect(Collectors.toList());
		
			
			int rndAbrigos = new Random().nextInt(combinacionesValidas.size());
			List <Prenda> combinacionAbrigoElegida = combinacionesValidas.get(rndAbrigos);
			
			combinacionesNoAbrigos.addAll(combinacionAbrigoElegida);
			//se concatenaron ambas listas en combinacionesNoAbrigos
		}
		
		
		return	combinacionesNoAbrigos;		
	}
	
//	------------------- LAS EXCEPCIONES-----------------------------------

	public void verificarGuardarropaConPrendas() throws Exception
	{
		if(parteSuperior.isEmpty()) throw new Exception("NO HAY PARTE SUPERIOR");
		if(parteInferior.isEmpty()) throw new Exception("NO HAY PARTE INFERIOR");
		if(calzados.isEmpty()) 		throw new Exception("NO HAY CALZADO");
		if(accesorios.isEmpty()) 	throw new Exception("NO HAY ACCESORIO");
	}

//-----------------------Verificacion de Array List-----------------------

	public boolean verificarArrayList() 
	{
		return this.parteSuperior.size()>0 && this.parteInferior.size()>0 && this.calzados.size()>0 && this.accesorios.size()>0 ;
	}
	public int numeroTotalEnGuardarropa() {
		return parteSuperior.size() +  parteInferior.size()+ calzados.size()+ accesorios.size();
		
	}



	
		
	
	
}