package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Preduzece")
public class Preduzece {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPreduzeca;
	
	@Column(name = "nazivPreduzeca", columnDefinition = "VARCHAR(20)")
	private String nazivPreduzeca;
	
	@Column(name = "adresa", columnDefinition = "VARCHAR(20)")
	private String adresa;
	
	@Column(name = "brojTelefona", columnDefinition = "VARCHAR(20)")
	private String brojTelefona;
	
	@Column(name = "fax", columnDefinition = "VARCHAR(20)")
	private String fax;
	
	public Preduzece(String nazivPreduzeca, String adresa, String brojTelefona, String fax) {
		//this.idPreduzeca = idPreduzeca;
		this.nazivPreduzeca = nazivPreduzeca;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.fax = fax;
	}

	public int getIdPreduzeca() {
		return idPreduzeca;
	}

	public void setIdPreduzeca(int idPreduzeca) {
		this.idPreduzeca = idPreduzeca;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	

}
