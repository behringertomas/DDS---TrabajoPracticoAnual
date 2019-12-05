package JsonPersistido;

import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
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

import TPZTBCS.Prenda;
import interfacesZTBCS.strategyTemperatura;

@Entity
@Table (name = "Json")

public class Json {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COLOR")
	Long ID;
	
	@Column(name = "Color")	
	String colores[] = { 
			"Azul",
		    "Rojo",
		    "Amarillo",
		    "Blanco",
		    "Verde",
		    "Marron",
		    "Rosa",
		    "Violeta",
		    "Bordo",
		    "Celeste",
		    "Negro",
		    "Gris"
			};
	@Column(name = "ParteSuperior")
	String parteSuperior[]= {"Remera","Musculosa","Camisa"};
	
	@Column(name = "TipoAbrigo")
	String tipoAbrigo[]= {"Campera","Sweater","Buzo", "Campera Impermeable"};
	
	@Column(name = "TemperaturasAbrigo")
	String temperaturasAbrigo[] = {"20","15","10","10"};
	
	@Column(name = "TipoParteInferior")
	String tipoParteInferior[] = {"Pantalon Largo","Short","Pollera","Pantalon Corto"};
	
	@Column(name = "TipoCalzado")
	String tipoCalzado[] = {"Zapatilla","Zapato","Runners","Botines","Trainers"};
	
	@Column(name = "TipoParteSuperiorMaterial")
	String tipoParteSuperiorMaterial[]= {"Tela","Algodon","Seda","Cuero"};
	
	@Column(name = "TipoParteInferiorMaterial")
	String tipoParteInferiorMaterial[] = {"Jean","Algodon","Cuero","Pana","Gamuza"};
	
	@Column(name = "TipoCalzadoMaterial")
	String tipoCalzadoMaterial[]= {"Jean","Algodon","Cuero","Pana","Gamuza"};
	
	@Column(name = "TipoAccesorio")
	String tipoAccesorio []= {"Reloj","Pulsera","Aro","Lentes de Sol","Paraguas"};
	
	@Column(name = "TipoAccesorioMaterial")
	String tipoAccesorioMaterial[] = {"Metal","Oro","Plata","Bronce"};
	
	@Column(name = "TipoAbrigoSecundario")
	String tipoAbrigoSecundario[] = {"Bufanda","Gorro","Guantes","Cuello Polar","Gorra de Sol"};
	
	@Column(name = "TipoAbrigoSecundarioParte")
	String tipoAbrigoSecundarioParte[]= {"Cuello","Cabeza","Manos","Cuello","Cabeza"};
	
	@Column(name = "TipoAbrigoSecundarioMaterial")
	String tipoAbrigoSecundarioMaterial[]= {"Tela","Algodon","Seda"};
	
	@Column(name = "TemperaturasAbrigoAccesorios")
	String temperaturasAbrigosAccesorios[] = {"15","15","15","15","0"};
	
	@Column(name = "PrendasFactoresClimaticos")
	String prendasFactoresClimaticos[] = {"Pollera","Gorro","Gorra de Sol","Lentes de Sol","Campera Impermeable","Paraguas"};
	
	@Column(name = "RelacionFactoresClimaticos")
	String relacionFactoresClimaticos[] = {"Viento","Viento","Sol","Sol","Lluvia","Lluvia"};
	
	
	public Long getIdColor() {
        return ID;
    }	
	
	
}
