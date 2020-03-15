package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "korisnik")
public class Korisnik {
	
	@Id
	@Column(name = "idKorisnik")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKorisnik;
	
	@Column(name = "korisnickoIme", columnDefinition = "VARCHAR(10)")
	private String korisnickoIme;
	
	@Column(name = "lozinka", columnDefinition = "VARCHAR(10)")
	private String lozinka;
	
	

//	public Korisnik(int idKorisnik, String korisnickoIme, String lozinka) {
//		this.idKorisnik = idKorisnik;
//		this.korisnickoIme = korisnickoIme;
//		this.lozinka = lozinka;
//	}

	public int getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
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
	

	
}
