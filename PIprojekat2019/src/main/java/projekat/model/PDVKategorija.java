package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PDVKategorija")
public class PDVKategorija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorije;
	
	@Column(name = "nazivKategorije", columnDefinition = "VARCHAR(10)")
	private String nazivKategorije;
	
	public PDVKategorija(String nazivKategorije) {
		//this.idKategorije = idKategorije;
		this.nazivKategorije = nazivKategorije;
	}

	public int getIdKategorije() {
		return idKategorije;
	}

	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}
	
	
	

}
