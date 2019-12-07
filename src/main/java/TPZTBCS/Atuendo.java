package TPZTBCS;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "Atuendo")
public class Atuendo
{	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ATUENDO_ELEGIDO")
	int id;
	
	@ManyToMany(cascade = {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
	@JoinTable(name = "atuendo_prenda",joinColumns = {@JoinColumn(name = "ID_ATUENDO_ELEGIDO")}, inverseJoinColumns = {@JoinColumn(name = "ID_PRENDA")})
	List <Prenda> prendas = new ArrayList<Prenda>();
	
	@Transient
	HashMap<Usuario,Integer> ListaPuntajeAtuendo = new HashMap<Usuario,Integer>();
	
	@ElementCollection
	@Column(name = "PUNTAJE")
	private List<Integer> listaPuntajes;
	
	
	public Atuendo() {
		
	}
	
//	public void setPuntaje(Usuario usuario)
//	{
//		System.out.println("Puntaje anterior: " + this.getPuntaje(usuario));
//		System.out.println("Ingrese puntaje del atuendo completo:");
//		Scanner obj = new Scanner(System.in);
//		
//		int puntaje = obj.nextInt();
//		ListaPuntajeAtuendo.put(usuario,puntaje);			
//	}
	
	public void setPuntaje(Usuario usuario,int puntaje)
	{
		ListaPuntajeAtuendo.put(usuario,puntaje);			
	}
	
	public int getPuntaje(Usuario usuario)
	{
		if(ListaPuntajeAtuendo.containsKey(usuario)) 
		{
			return ListaPuntajeAtuendo.get(usuario);	
		}
		else 
		{
			return this.getPromedioPuntaje(usuario);
		}
	}
	
	public int getPromedioPuntaje(Usuario usuario)
	{
		int cantidadPrendas = prendas.size();
		int sumatoria = this.puntajeTotalDePrendas(usuario);
		
		return  sumatoria / cantidadPrendas;
	}
	
	public Atuendo(List<Prenda> prenda)
	{
		this.prendas= prenda;
	}
	
	public void imprimirPrendas() 
	{
		this.prendas.forEach(prenda->prenda.imprimirDescripcion());
		
	}
	
	
	public List<Integer> getListaPuntajes() {
		return listaPuntajes;
	}

	public void setListaPuntajes(List<Integer> listaPuntajes) {
		this.listaPuntajes = listaPuntajes;
	}

	public void repuntuarPrendas(Usuario usuario,int puntaje) 
	{
		this.prendas.forEach(prenda-> prenda.setPuntaje(usuario,puntaje));
	}
	
	public int cuantoAbriga() {
	 return prendas.stream().mapToInt(
		x->{
		try {
			return x.getTemperatura();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return 0;
	}).sum();
	}
	
	
	
	public void agregarPuntajeALaLista(int puntaje){
		this.listaPuntajes.add(puntaje);
	}

	public void setListaPuntajeAtuendo(HashMap<Usuario, Integer> listaPuntajeAtuendo) {
		ListaPuntajeAtuendo = listaPuntajeAtuendo;
	}

	public int puntajeTotalDePrendas(Usuario usuario)
	{
		return prendas.stream().mapToInt(x->{return x.getPuntaje(usuario); }).sum();
	}
	
	private Prenda getPrenda(int indice)
	{
		return prendas.get(indice);
	}
	
	public boolean isNotBlocked(Date fecha)
	{
		int cantPrendas = prendas.size();
		
		for(int i=0; i<cantPrendas; i++)
		{
			Prenda prendai = this.getPrenda(i);
			if(prendai.isBlocked(fecha))
			{
				return false;
			}
		}
		return true;
	}
	
	
	
	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public void bloquear (Date fecha)
	{
		prendas.forEach(prenda-> prenda.bloquearPrenda(fecha));
	}
}