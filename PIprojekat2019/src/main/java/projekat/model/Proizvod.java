package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proizvod")
public class Proizvod {
	
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

	
	public Proizvod() {
		super();
	}


	public Proizvod(Long id, String naziv, double cena, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.opis = opis;
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


	@Override
	public String toString() {
		return "Proizvod [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", opis=" + opis + "]";
	}
	


}