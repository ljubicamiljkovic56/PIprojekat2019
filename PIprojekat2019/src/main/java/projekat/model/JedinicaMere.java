package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "JedinicaMere")
public class JedinicaMere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJediniceMere;
	
	@Column(name = "nazivJediniceMere", columnDefinition = "VARCHAR(10)")
	private String nazivJediniceMere;
	
	@Column(name = "skraceniNaziv", columnDefinition = "CHAR(2)")
	private String skraceniNaziv;
	
	public JedinicaMere(String nazivJediniceMere, String skraceniNaziv) {
		//this.idJediniceMere = idJediniceMere;
		this.nazivJediniceMere = nazivJediniceMere;
		this.skraceniNaziv = skraceniNaziv;
	}

	public int getIdJediniceMere() {
		return idJediniceMere;
	}

	public void setIdJediniceMere(int idJediniceMere) {
		this.idJediniceMere = idJediniceMere;
	}

	public String getNazivJediniceMere() {
		return nazivJediniceMere;
	}

	public void setNazivJediniceMere(String nazivJediniceMere) {
		this.nazivJediniceMere = nazivJediniceMere;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	
	

}
