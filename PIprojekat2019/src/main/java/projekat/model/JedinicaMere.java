package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "jedinica_mere")
public class JedinicaMere implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJediniceMere;
	
	@Column(name = "naziv_jedinice_mere", columnDefinition = "VARCHAR(20)")
	private String nazivJediniceMere;
	
	@Column(name = "skraceni_naziv", columnDefinition = "VARCHAR(5)")
	private String skraceniNaziv;
	
	@OneToOne(fetch = FetchType.EAGER)
	private RobaUsluga robaUsluga;
	
	public JedinicaMere() {
		super();
	}

	public JedinicaMere(int idJediniceMere, String nazivJediniceMere, String skraceniNaziv, RobaUsluga robaUsluga) {
		super();
		this.idJediniceMere = idJediniceMere;
		this.nazivJediniceMere = nazivJediniceMere;
		this.skraceniNaziv = skraceniNaziv;
		this.robaUsluga = robaUsluga;
	}

	public int getIdJediniceMere() {
		return idJediniceMere;
	}

	public void setIdJediniceMere(int idJediniceMere) {
		this.idJediniceMere = idJediniceMere;
	}

	public String getNazivJediniceMere() {
		return nazivJediniceMere;
	}

	public void setNazivJediniceMere(String nazivJediniceMere) {
		this.nazivJediniceMere = nazivJediniceMere;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

	@Override
	public String toString() {
		return "JedinicaMere [idJediniceMere=" + idJediniceMere + ", nazivJediniceMere=" + nazivJediniceMere
				+ ", skraceniNaziv=" + skraceniNaziv + ", robaUsluga=" + robaUsluga + "]";
	}	
}