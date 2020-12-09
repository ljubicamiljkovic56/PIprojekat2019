package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kupljeni_proizvod")
public class KupljeniProizvod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="proizvod_id")
	private Long id;
	
	@Column(name = "naziv", columnDefinition = "VARCHAR(30)")
	private String naziv;
	
	@Column(name = "cena", columnDefinition = "DECIMAL")
	private double cena;
	
	@Column(name = "opis", columnDefinition = "VARCHAR(30)")
	private String opis;

	@Column(name = "kolicina", columnDefinition = "DECIMAL")
	private double kolicina;
	
	@Column(name = "kupac", columnDefinition = "VARCHAR(10)")
	private String kupac;
	
	public KupljeniProizvod() {
		super();
	}
	

	public KupljeniProizvod(Long id, String naziv, double cena, String opis, double kolicina, String kupac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.opis = opis;
		this.kolicina = kolicina;
		this.kupac = kupac;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		this.kupac = kupac;
	}

	@Override
	public String toString() {
		return "KupljeniProizvod [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", opis=" + opis + ", kolicina="
				+ kolicina + ", kupac=" + kupac + "]";
	}

}