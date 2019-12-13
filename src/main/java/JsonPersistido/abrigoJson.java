package JsonPersistido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "abrigoJson")
public class abrigoJson {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long ID;
	
	@Column(name = "abrigo")
	String abrigo;
	
	@Column(name = "temperatura")
	int temp;
	
	public abrigoJson() {
		
	}
	
	public abrigoJson(String abrigo, int temp) {
		this.abrigo = abrigo;
		this.temp = temp;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getAbrigo() {
		return abrigo;
	}

	public void setAbrigo(String abrigo) {
		this.abrigo = abrigo;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	
	
	
}
