package projekat.dto;

public class NarudzbenicaDTO {

	private Long id;
	private String nazivRobe;
	private String jedinicaMere;
	private double kolicina;
	private double cena;
	private double iznos;
	private Long idPreduzeca;
	private Long idPoslovnogPartnera;
	private Long idGodine;
	
	public NarudzbenicaDTO() {
		super();
	}
	
	public NarudzbenicaDTO(Long id, String nazivRobe, String jedinicaMere, double kolicina, double cena, double iznos,
			Long idPreduzeca, Long idPoslovnogPartnera, Long idGodine) {
		super();
		this.id = id;
		this.nazivRobe = nazivRobe;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.cena = cena;
		this.iznos = iznos;
		this.idPreduzeca = idPreduzeca;
		this.idPoslovnogPartnera = idPoslovnogPartnera;
		this.idGodine = idGodine;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivRobe() {
		return nazivRobe;
	}
	public void setNazivRobe(String nazivRobe) {
		this.nazivRobe = nazivRobe;
	}
	public String getJedinicaMere() {
		return jedinicaMere;
	}
	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public Long getIdPreduzeca() {
		return idPreduzeca;
	}

	public void setIdPreduzeca(Long idPreduzeca) {
		this.idPreduzeca = idPreduzeca;
	}

	public Long getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(Long idPoslovnogPartnera) {
		this.idPoslovnogPartnera = idPoslovnogPartnera;
	}

	public Long getIdGodine() {
		return idGodine;
	}

	public void setIdGodine(Long idGodine) {
		this.idGodine = idGodine;
	}	
}