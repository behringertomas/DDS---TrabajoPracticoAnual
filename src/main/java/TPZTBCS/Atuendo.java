package TPZTBCS;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	Long ID;
	
	@OneToMany (targetEntity = Prenda.class,mappedBy = "atuendo",cascade = CascadeType.ALL)
	List <Prenda> prendas;
	
	@Column (name = "PUNTAJE_ATUENDO")
	HashMap<Usuario,Integer> ListaPuntajeAtuendo = new HashMap<Usuario,Integer>();
	
	public void setPuntaje(Usuario usuario)
	{
		System.out.println("Puntaje anterior: " + this.getPuntaje(usuario));
		System.out.println("Ingrese puntaje del atuendo completo:");
		Scanner obj = new Scanner(System.in);
		
		int puntaje = obj.nextInt();
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
	
	public void repuntuarPrendas(Usuario usuario) 
	{
		this.prendas.forEach(prenda-> prenda.setPuntaje(usuario));
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
	
	public void bloquear (Date fecha)
	{
		prendas.forEach(prenda-> prenda.bloquearPrenda(fecha));
	}
}