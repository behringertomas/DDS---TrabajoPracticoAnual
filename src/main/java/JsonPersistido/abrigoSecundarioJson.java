package JsonPersistido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "abrigoSecundarioJson")
public class abrigoSecundarioJson {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long ID;
	
	@Column(name = "abrigo_secundario")
	String abrigo_secundario;
	
	@Column(name = "parte_cuerpo")
	String parte_cuerpo;
	
	@Column(name = "temperatura")
	int temp;
	
	
	
	public abrigoSecundarioJson() {
		
	}
	
	public abrigoSecundarioJson(String abrigo_secundario,String parte_cuerpo, int temp) {
		this.abrigo_secundario = abrigo_secundario;
		this.temp = temp;
		this.parte_cuerpo = parte_cuerpo;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getAbrigo_secundario() {
		return abrigo_secundario;
	}

	public void setAbrigo_secundario(String abrigo_secundario) {
		this.abrigo_secundario = abrigo_secundario;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public String getParte_cuerpo() {
		return parte_cuerpo;
	}

	public void setParte_cuerpo(String parte_cuerpo) {
		this.parte_cuerpo = parte_cuerpo;
	}
	
	
	

}
