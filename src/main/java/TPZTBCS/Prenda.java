package TPZTBCS;

import java.util.HashMap;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import interfacesZTBCS.strategyTemperatura;

@Entity
@Table (name = "Prenda")
public class Prenda 
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRENDA")
	Long ID;
	
	@ManyToOne
	@JoinColumn (name = "guardarropa_prenda_id")
	private Guardarropa guardarropa_id;
	
	@Column(name = "EN_GUARDARROPA")
	private boolean enGuardarropa=false;
	@Column(name = "PRENDA_PARTE")
	private String parte = "";
	@Column(name = "PRENDA_TIPO")
	private String tipo = "";
	@Column(name = "PRENDA_MATERIAL")
	private String material = "";
	@Column(name = "PRENDA_COLOR_PRIMARIA")
    private String colorPrimario = "";
	@Column(name = "PRENDA_COLOR_SECUNDARIO")
    private String colorSecundario = "";
	@Column(name = "PRENDA_DIRECCION_IMG")
    private String direccionImagen = "";
	@Column(name = "PRENDA_PARTE_ESPECIFICA")
	private String parteEspecifica="";

	@Transient
	private strategyTemperatura strategyTemp;
	@Column(name = "PRENDA_PREFERENCIAS")
	HashMap<Usuario,Integer> ListaPuntaje = new HashMap<Usuario,Integer>();
	
	public void setPuntaje(Usuario usuario)
	{
		System.out.println("Prenda: " + this.parteEspecifica + this.tipo);
		System.out.println("Puntaje anterior: " + this.getPuntaje(usuario));
		System.out.println("Ingrese puntaje de la prenda:");
		
		Scanner obj = new Scanner(System.in);
		int puntaje = obj.nextInt();
		
		ListaPuntaje.put(usuario,puntaje);			
	}
	
	public int getPuntaje(Usuario usuario)
	{
        if (ListaPuntaje.containsKey(usuario)) {
    		return ListaPuntaje.get(usuario);            
        } else {
           // System.out.println("No hay ninguna prenda de este usuario.");
            return 0;
        }
		
    }

	
	
	public void setParteEspecifica(String parte) {
		this.parteEspecifica=parte;
	}
	public String getParteEspecifica() {
		return this.parteEspecifica;
	}
    
    public void setStrategy(strategyTemperatura str) { this.strategyTemp = str;}
    
    public void setParte(String parte){this.parte = parte;}
    
    public void setTipo(String tipo){this.tipo = tipo;}
    
    public void setMaterial(String material){ this.material = material; }
    
    public void setColorPrimario(String colorPrimario)	{ this.colorPrimario = colorPrimario; }
    
    public void setColorSecundario(String colorSecundario)	{ this.colorSecundario = colorSecundario; }	
    
    public Prenda getPrenda() { return this; }
    
    public int getTemperatura() throws Exception {
    	return this.strategyTemp.getTemperatura(this);
    }
    
    public strategyTemperatura getStrategy() {
    	return this.strategyTemp;
    }
    
    public String getParteCuerpo() {return this.parte;}
    
    public String getTipo() {return this.tipo;}
    
    public void setDireccionImagen(String direccionImagen)	{ this.direccionImagen = direccionImagen; }	
    
    public void meterEnGuardarropa()
    {
    	this.enGuardarropa=true;
    }
    
    public boolean estaEnGuardarropa() 
    {
    	return this.enGuardarropa;
    }
    
    public void mostrarPrenda()
    {
    	System.out.println(this.parte);
    	System.out.println(this.tipo);
    	System.out.println(this.material);
    	System.out.println(this.colorPrimario);
    	System.out.println(this.colorSecundario);
    }
    
    public String getColorSecundario() 
    {
    	return this.colorSecundario;
    }
    
    public String getDireccionImagen()
    {
    	return this.direccionImagen;
    }
    
    public void imprimirDescripcion()
    {
    	if(this.colorSecundario == "") {
    		System.out.println(this.tipo + " de " + this.material + " " + this.colorPrimario);
    	} else {
    		System.out.println(this.tipo + " de " + this.material + " " +this.colorPrimario + " y " + this.colorSecundario);
    	}
    }
    
    public String getDescripcion()
    {
    	if(this.colorSecundario == "") {
    		return(this.tipo + " de " + this.material + " " + this.colorPrimario);
    	} else {
    		return(this.tipo + " de " + this.material + " " +this.colorPrimario + " y " + this.colorSecundario);
    	}    	
    }
    
//    public void modificarPuntaje(Usuario usuario){
//  
//        if (ListaPuntaje.containsKey(usuario)) {
//            System.out.println("Prenda: " + this.parteEspecifica + this.tipo);
//            this.setPuntaje(usuario);            
//        } else {
//            System.out.println("No hay ninguna prenda de este usuario.");
//        }
//    }
    
}