package JsonPersistido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "factoresClimaticosJson")
public class factoresClimaticosJson {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long ID;
	
	@Column(name = "prenda_factor_climatico")
	String prenda_factor_climatico;
	
	@Column(name = "clima")
	String clima;
	
	public factoresClimaticosJson() {
		
	}
	
	public factoresClimaticosJson(String prenda_factor_climatico, String clima) {
		this.prenda_factor_climatico = prenda_factor_climatico;
		this.clima = clima;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getPrenda_factor_climatico() {
		return prenda_factor_climatico;
	}

	public void setPrenda_factor_climatico(String prenda_factor_climatico) {
		this.prenda_factor_climatico = prenda_factor_climatico;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}
	
	
	
}
