package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "korisnik")
public class Korisnik  implements Serializable {
	
	@Id
	@Column(name = "idKorisnik")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKorisnik;
	
	@Column(name = "korisnicko_ime", columnDefinition = "VARCHAR(10)")
	private String username;
	
	@Column(name = "lozinka", columnDefinition = "VARCHAR(10)")
	private String password;
	
	@Column(name = "uloga", columnDefinition = "VARCHAR(10)")
	private String uloga;

	public Korisnik() {
		super();
	}
	
	public Korisnik(Long idKorisnik, String username, String password, String uloga) {
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

	

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
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

	@Override
	public String toString() {
		return "Korisnik [idKorisnik=" + idKorisnik + ", username=" + username + ", password=" + password + ", uloga="
				+ uloga + "]";
	}

	
	
	
}