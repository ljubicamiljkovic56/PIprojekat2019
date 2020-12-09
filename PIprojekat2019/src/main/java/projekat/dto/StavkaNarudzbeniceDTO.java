package projekat.dto;

public class StavkaNarudzbeniceDTO {

	private Long id;
	private String jedinicaMere;
	private double kolicina;
	private double cena;
	private double iznos;
	private Long idNarudzbenice;
	private Long idRobeUsluge;
	
	public StavkaNarudzbeniceDTO() {
		super();
	}
	
	public StavkaNarudzbeniceDTO(Long id, String jedinicaMere, double kolicina, double cena, double iznos,
			Long idNarudzbenice, Long idRobeUsluge) {
		super();
		this.id = id;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.cena = cena;
		this.iznos = iznos;
		this.idNarudzbenice = idNarudzbenice;
		this.idRobeUsluge = idRobeUsluge;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdNarudzbenice() {
		return idNarudzbenice;
	}

	public void setIdNarudzbenice(Long idNarudzbenice) {
		this.idNarudzbenice = idNarudzbenice;
	}

	public Long getIdRobeUsluge() {
		return idRobeUsluge;
	}

	public void setIdRobeUsluge(Long idRobeUsluge) {
		this.idRobeUsluge = idRobeUsluge;
	}

}