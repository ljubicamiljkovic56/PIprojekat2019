package projekat.dto;

public class KorisnikDTO {
	
	private Long idKorisnik;
	private String username;
	private String password;
	private String uloga;
	
	public KorisnikDTO() {
		super();
	}
	
	

	public KorisnikDTO(Long idKorisnik, String username, String password, String uloga) {
		super();
		this.idKorisnik = idKorisnik;
		this.username = username;
		this.password = password;
		this.uloga = uloga;
	}



	public Long getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(Long idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	

}
