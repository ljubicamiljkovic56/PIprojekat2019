package projekat.dto;


public class PoslovniPartnerDTO {
	
	private Long idPoslovnogPartnera;
	private String nazivPoslovnogPartnera;
	private String adresa;
	private String telefon;
	private String fax;
	private String email;
	private String vrstaPartnera;
	private Long idMesta;
	private Long idPreduzeca;
	
	public PoslovniPartnerDTO() {
		super();
	}

	
	
	public PoslovniPartnerDTO(Long idPoslovnogPartnera, String nazivPoslovnogPartnera, String adresa, String telefon,
			String fax, String email, String vrstaPartnera, Long idMesta, Long idPreduzeca) {
		super();
		this.idPoslovnogPartnera = idPoslovnogPartnera;
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
		this.email = email;
		this.vrstaPartnera = vrstaPartnera;
		this.idMesta = idMesta;
		this.idPreduzeca = idPreduzeca;
	}



//	public PoslovniPartnerDTO(PoslovniPartner poslovniPartner) {
//		this.idPoslovnogPartnera = poslovniPartner.getIdPoslovnogPartnera();
//		this.nazivPoslovnogPartnera = poslovniPartner.getNazivPoslovnogPartnera();
//		this.adresa = poslovniPartner.getAdresa();
//		this.telefon = poslovniPartner.getTelefon();
//		this.fax = poslovniPartner.getFax();
//		this.email = poslovniPartner.getEmail();
//		this.vrstaPartnera = poslovniPartner.getVrstaPartnera();
//		//this.fakture = poslovniPartner.getFakture();
//		this.naseljenoMesto = poslovniPartner.getNaseljenoMesto();
//		
//	}

	public Long getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(Long idPoslovnogPartnera) {
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

	public String getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(String vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}

	public Long getIdMesta() {
		return idMesta;
	}

	public void setIdMesta(Long idMesta) {
		this.idMesta = idMesta;
	}

	public Long getIdPreduzeca() {
		return idPreduzeca;
	}

	public void setIdPreduzeca(Long idPreduzeca) {
		this.idPreduzeca = idPreduzeca;
	}
}