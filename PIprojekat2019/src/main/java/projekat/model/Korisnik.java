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
	
	@Column(name = "korisnickoIme", columnDefinition = "VARCHAR(10)")
	private String korisnickoIme;
	
	@Column(name = "lozinka", columnDefinition = "VARCHAR(10)")
	private String lozinka;

	public Korisnik(Long idKorisnik, String korisnickoIme, String lozinka) {
		super();
		this.idKorisnik = idKorisnik;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public Long getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(Long idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Korisnik [idKorisnik=" + idKorisnik + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}
	
}