package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PoslovniPartner")
public class PoslovniPartner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPoslovnogPartnera;
	
	@Column(name = "nazivPoslovnogPartnera", columnDefinition = "VARCHAR(20)")
	private String nazivPoslovnogPartnera;
	
	@Column(name = "adresa", columnDefinition = "VARCHAR(20)")
	private String adresa;
	
	@Column(name = "telefon", columnDefinition = "VARCHAR(20)")
	private String telefon;
	
	@Column(name = "fax", columnDefinition = "VARCHAR(20)")
	private String fax;
	
	@Column(name = "email", columnDefinition = "VARCHAR(15)")
	private String email;
	
	private enum VrstaPartnera {KU, DO, KD};
	
	@Column(name = "vrstaPartnera", columnDefinition = "CHAR(2)")
	private VrstaPartnera vrstaPartnera;
	
	public PoslovniPartner(String nazivPoslovnogPartnera, String adresa, String telefon,
			String fax, String email, VrstaPartnera vrstaPartnera) {
		//this.idPoslovnogPartnera = idPoslovnogPartnera;
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
		this.email = email;
		this.vrstaPartnera = vrstaPartnera;
	}

	public int getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(int idPoslovnogPartnera) {
		this.idPoslovnogPartnera = idPoslovnogPartnera;
	}

	public String getNazivPoslovnogPartnera() {
		return nazivPoslovnogPartnera;
	}

	public void setNazivPoslovnogPartnera(String nazivPoslovnogPartnera) {
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public VrstaPartnera getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(VrstaPartnera vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}
	
	
	
	
}
