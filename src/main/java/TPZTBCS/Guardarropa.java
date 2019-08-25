package TPZTBCS;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.util.MathUtils;
import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.IGenerator;
import org.paukov.combinatorics3.SubSetGenerator;

import com.krds.accuweatherapi.ApiSession;
import com.krds.accuweatherapi.CurrentConditionsApi;
import com.krds.accuweatherapi.HourPeriod;
import com.krds.accuweatherapi.LocationApi;
import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;
import com.krds.accuweatherapi.model.CurrentConditions;
import com.krds.accuweatherapi.model.GeoPositionSearchResult;
import com.weatherlibraryjava.WeatherApixu;

import interfacesZTBCS.ITargetAPI;

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
		
	public Atuendo queMePongo(String ciudad,DatosPersonales Datos) throws UnauthorizedException, ApiException 
	{
		if(this.verificarArrayList()) 
		{

		    Atuendo atuendoElegido = new Atuendo(this.combinaciones(ciudad,Datos));
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
	
	
	public List<Prenda> combinaciones(String ciudad,DatosPersonales Datos) throws UnauthorizedException, ApiException
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
		
		ArrayList <Prenda> accesoriosNoAbrigo =(ArrayList <Prenda>) accesorios.stream().filter(x->{
			try {
				return x.getTemperatura()==0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} return (Boolean) null;
		}).collect(Collectors.toList());
		
		ArrayList <Prenda> accesoriosAbrigo = (ArrayList <Prenda>) accesorios.stream().filter(x->{
			try {
				return x.getTemperatura()>0;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return (Boolean) null;
		}).collect(Collectors.toList());
		
		
		
		ZonaYTemperatura zonaYTemp = target.request(ciudad);
		
		//------------------------------- ACCU WEATHER API
			ApiSession session = new ApiSession.Builder("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf").build();
			LocationApi locationApi = session.getLocationApi();
			CurrentConditionsApi current = session.getCurrentConditionsApi("cdxE2HxzUId3I9ebdqEY1ySFK3pTQCAf");
			
			//Limpio espacios y trimeo al nombre de la ciudad para que sea correcta la request.
			ciudad.trim();
			String newCiudad;
			newCiudad =ciudad.replaceAll("\\s+", "%20");
			
			Optional <GeoPositionSearchResult> geoLocation = locationApi.geoPosition(target.getLat(newCiudad),target.getLong(newCiudad));
			CurrentConditionsApi ccApi = session.getCurrentConditionsApi(geoLocation.get().getKey());
	
			Optional<CurrentConditions> cc = ccApi.get(HourPeriod.HOURS_24);
			double temp = cc.get().getTemperature().getMetric().getValue();
			String condicionClimatica = cc.get().getWeatherText();
			if (cc.isPresent()) {
			  System.out.println("Current temperature is: " + temp);
			  System.out.println(condicionClimatica);
			}
		//------------------------------- ACCU WEATHER API
		
//		double temp = zonaYTemp.temp;
		IGenerator<List<Prenda>> combinaciones = Generator.cartesianProduct(noAbriga, this.parteInferior, accesoriosNoAbrigo, this.calzados);
		
		ArrayList<List<Prenda>> arrayListCombinaciones = new ArrayList<List<Prenda>>();
		
		combinaciones.forEach(Lista->arrayListCombinaciones.add(Lista));
		
		int rndNoAbrigos = new Random().nextInt(arrayListCombinaciones.size());
		List <Prenda> combinacionesNoAbrigos = arrayListCombinaciones.get(rndNoAbrigos);
		
		//CABEZA
		if(temp<=Datos.getFrioCabeza()) {
			List<Prenda> posiblesAbrigoCabeza= accesoriosAbrigo.stream().filter(x->x.getParteEspecifica().equalsIgnoreCase("Cabeza")).collect(Collectors.toList());
			
			
			if (posiblesAbrigoCabeza.isEmpty()) {
				System.out.println("No hay abrigos para la cabeza que se puedan recomendar en este guardarropa");
			}else {
				List <Prenda> posiblesAbrigoCabezaValidos =  posiblesAbrigoCabeza.stream().filter(x->{
					try {
						return x.getTemperatura()>Datos.getFrioCabeza()-temp;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}).collect(Collectors.toList());
				
				if (posiblesAbrigoCabezaValidos.isEmpty()) {
				System.out.println("No hay abrigos para la cabeza que se puedan recomendar en este guardarropa se recomienda el mas cercano a la temperatura actual");
//				Prenda prendaFlexible=posiblesAbrigoCabeza.sort();
				Collections.sort(posiblesAbrigoCabeza.stream().map(x->{
					try {
						return x.getTemperatura();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 0;
				}).collect(Collectors.toList()));
				
				Prenda prendaFlexible=posiblesAbrigoCabeza.get(0);
				combinacionesNoAbrigos.add(prendaFlexible);
				}else {
					int rndNoAbrigosCabeza = new Random().nextInt(posiblesAbrigoCabezaValidos.size());
					Prenda prendaCabeza = posiblesAbrigoCabezaValidos.get(rndNoAbrigosCabeza);
					combinacionesNoAbrigos.add(0, prendaCabeza);
				}
				
				
			}
	
			
			}
		
		//CUELLO
		if(temp<=Datos.getFrioCuello()) {
			List<Prenda> posiblesAbrigoCuello= accesoriosAbrigo.stream().filter(x->x.getParteEspecifica().equalsIgnoreCase("Cuello")).collect(Collectors.toList());
			
			
			if (posiblesAbrigoCuello.isEmpty()) {
				System.out.println("No hay abrigos para el cuello que se puedan recomendar en este guardarropa");
			}else {
				List <Prenda> posiblesAbrigoCuelloValidos =  posiblesAbrigoCuello.stream().filter(x->{
					try {
						return x.getTemperatura()>Datos.getFrioCuello()-temp;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}).collect(Collectors.toList());
				
				if (posiblesAbrigoCuelloValidos.isEmpty()) {
				System.out.println("No hay abrigos para el cuello que se puedan recomendar en este guardarropa se recomienda el mas cercano a la temperatura actual");
//				Prenda prendaFlexible=posiblesAbrigoCabeza.sort();
				Collections.sort(posiblesAbrigoCuello.stream().map(x->{
					try {
						return x.getTemperatura();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 0;
				}).collect(Collectors.toList()));
				
				Prenda prendaFlexible=posiblesAbrigoCuello.get(0);
				combinacionesNoAbrigos.add(prendaFlexible);
				}else {
					int rndNoAbrigosCuellos = new Random().nextInt(posiblesAbrigoCuelloValidos.size());
					Prenda prendaCuello = posiblesAbrigoCuelloValidos.get(rndNoAbrigosCuellos);
					combinacionesNoAbrigos.add(0, prendaCuello);
				}
				
				
			}
	
			
			}
		
		//CUELLO
				if(temp<=Datos.getFrioCuello()) {
					List<Prenda> posiblesAbrigoManos= accesoriosAbrigo.stream().filter(x->x.getParteEspecifica().equalsIgnoreCase("Manos")).collect(Collectors.toList());
					
					
					if (posiblesAbrigoManos.isEmpty()) {
						System.out.println("No hay abrigos para las manos que se puedan recomendar en este guardarropa");
					}else {
						List <Prenda> posiblesAbrigoManosValidos =  posiblesAbrigoManos.stream().filter(x->{
							try {
								return x.getTemperatura()>Datos.getFrioCuello()-temp;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return false;
						}).collect(Collectors.toList());
						
						if (posiblesAbrigoManosValidos.isEmpty()) {
						System.out.println("No hay abrigos para el cuello que se puedan recomendar en este guardarropa se recomienda el mas cercano a la temperatura actual");
//						Prenda prendaFlexible=posiblesAbrigoCabeza.sort();
						Collections.sort(posiblesAbrigoManos.stream().map(x->{
							try {
								return x.getTemperatura();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return 0;
						}).collect(Collectors.toList()));
						
						Prenda prendaFlexible=posiblesAbrigoManos.get(0);
						combinacionesNoAbrigos.add(prendaFlexible);
						}else {
							int rndNoAbrigosManos = new Random().nextInt(posiblesAbrigoManosValidos.size());
							Prenda prendaManos = posiblesAbrigoManosValidos.get(rndNoAbrigosManos);
							combinacionesNoAbrigos.add(0, prendaManos);
						}
						
						
					}
			
					
					}
		
		
		
		
		if(temp<=Datos.getFrioMaximo() && temp>= Datos.getFrioMinimo()) {
			
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
				}).sum() > (Datos.getFrioMaximo()-temp) ).collect(Collectors.toList());
		
			if(combinacionesValidas.isEmpty()) {
				System.out.println("No existen combinaciones validas se recomienda una prenda pero no cumple los requerimientos de temperatura por favor compre mas prendas");
				return	combinacionesNoAbrigos;
			}
			
			List <List<Prenda>> combinacionesValidasSinDuplicados =  combinacionesValidas.stream().filter(x->verificarDuplicados(x.stream().map(y->y.getTipo()).collect(Collectors.toList()))).collect(Collectors.toList());
			
			if(combinacionesValidasSinDuplicados.isEmpty()) {
				System.out.println("No existen combinaciones validas se recomienda una prenda pero no cumple los requerimientos de temperatura por favor compre mas prendas");
				return	combinacionesNoAbrigos;
			}
				
			int rndAbrigos = new Random().nextInt(combinacionesValidas.size());
			List <Prenda> combinacionAbrigoElegida = combinacionesValidas.get(rndAbrigos);
			
			combinacionesNoAbrigos.addAll(combinacionAbrigoElegida);
			//se concatenaron ambas listas en combinacionesNoAbrigos
		}
		
		
		return	combinacionesNoAbrigos;		
	}
	
//	------------------- LAS EXCEPCIONES-----------------------------------

	public boolean verificarDuplicados(List<String> combinacion) 
	{
		Set<String> set = new HashSet<String>(combinacion);
		if(set.size() < combinacion.size())
		return false;
		
		return true;
	}
	
	
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