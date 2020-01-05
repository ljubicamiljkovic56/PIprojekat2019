package projekat.model;

public class PoslovniPartner {
	
	private int idPoslovnogPartnera;
	private String nazivPoslovnogPartnera;
	private String adresa;
	private String telefon;
	private String fax;
	private String email;
	private enum VrstaPartnera {KU, DO, KD};
	private VrstaPartnera vrstaPartnera;
	
	public PoslovniPartner(int idPoslovnogPartnera, String nazivPoslovnogPartnera, String adresa, String telefon,
			String fax, String email, VrstaPartnera vrstaPartnera) {
		this.idPoslovnogPartnera = idPoslovnogPartnera;
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
