package projekat.model;

public class Preduzece {
	
	private int idPreduzeca;
	private String nazivPreduzeca;
	private String adresa;
	private String brojTelefona;
	private String fax;
	
	public Preduzece(int idPreduzeca, String nazivPreduzeca, String adresa, String brojTelefona, String fax) {
		this.idPreduzeca = idPreduzeca;
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
