package TPZTBCS;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;

import interfacesZTBCS.strategyTemperatura;

@Entity
@Table (name = "Prenda")
public class Prenda 
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRENDA")
	int id;
	
	@Column (name = "ID_ATUENDO")
	@ManyToMany(mappedBy = "prendas")
	List <Atuendo> atuendo = new ArrayList<Atuendo>();
	
	@JoinColumn (name = "guardarropa_prenda_id",referencedColumnName = "ID_GUARDARROPA",foreignKey = @ForeignKey(name = "FK_GUARDARROPA"))
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Guardarropa.class)
	private Guardarropa guardarropa_id;

	@Column(name = "Calendario_De_Uso")
	ArrayList <Date> calendarioDeUso = new ArrayList<Date>();
	
//	@OneToOne(cascade = {CascadeType.ALL})
//	@JoinColumn (name = "ID_IMAGEN")
//	private Imagen imagen;
	
	@Lob
	@Column(name = "Imagen")
	byte[] imagen = null;
	
//	@Column(name = "Imagen")
//	String imagen;
	
	
	public Guardarropa getGuardarropa_id() {
		return guardarropa_id;
	}

	public void setGuardarropa_id(Guardarropa guardarropa_id) {
		this.guardarropa_id = guardarropa_id;
	}
	
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
    private String url_img = "";
	@Column(name = "PRENDA_PARTE_ESPECIFICA")
	private String parteEspecifica="";
	@Column(name = "CUANTO_ABRIGA")
	private int abrigoTemp;
	

	@Transient
	private strategyTemperatura strategyTemp;
	
	@Column(name = "PRENDA_PREFERENCIAS")
	HashMap<Usuario,Integer> ListaPuntaje = new HashMap<Usuario,Integer>();
	

	public void setPuntaje(Usuario usuario, int puntaje)
	{
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
	
	public void instanciar_array_bytes(File file) {
		this.imagen = new byte [(int) file.length()];
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public Prenda() {
		
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	

	public List<Atuendo> getAtuendo() {
		return atuendo;
	}
	
//	public String getImagen() {
//		return imagen;
//	}
//
//	public void setImagen(String imagen) {
//		this.imagen = imagen;
//	}

	public void setAtuendo(List<Atuendo> atuendo) {
		this.atuendo = atuendo;
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
	public int getAbrigoTemp() {
		return abrigoTemp;
	}

	public void setAbrigoTemp(int abrigoTemp) {
		this.abrigoTemp = abrigoTemp;
	}
    
    public String getMaterial() {
		return material;
	}

	public String getColorPrimario() {
		return colorPrimario;
	}

	public String getParte() {
		return parte;
	}

	public strategyTemperatura getStrategy() {
    	return this.strategyTemp;
    }
    
    public String getParteCuerpo() {return this.parte;}
    
    public String getTipo() {return this.tipo;}
    
    public void setDireccionImagen(String url_img)	{ this.url_img = url_img; }	
    
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
    	return this.url_img;
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
    
    public void bloquearPrenda(Date fecha)
    {
    	this.calendarioDeUso.add(fecha);
    }
    
    public void desbloquearPrenda(Date fecha)
    {
    	this.calendarioDeUso.remove(fecha);
    }
    
    public boolean isBlocked(Date fecha)
    {
    	return this.calendarioDeUso.contains(fecha);
    }

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
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