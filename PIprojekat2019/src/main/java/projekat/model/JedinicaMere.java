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
@Table(name = "jedinica_mere")
public class JedinicaMere implements Serializable{
	
	@Id
	@Column(name = "id_jedinice_mere")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idJediniceMere;
	
	@Column(name = "naziv_jedinice_mere", columnDefinition = "VARCHAR(20)")
	private String nazivJediniceMere;
	
	@Column(name = "skraceni_naziv", columnDefinition = "CHAR(5)")
	private String skraceniNaziv;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<RobaUsluga>robaUsluga = new ArrayList<RobaUsluga>();
	
	public JedinicaMere() {
		super();
	}

	public JedinicaMere(Long idJediniceMere, String nazivJediniceMere, String skraceniNaziv) {
		super();
		this.idJediniceMere = idJediniceMere;
		this.nazivJediniceMere = nazivJediniceMere;
		this.skraceniNaziv = skraceniNaziv;
	}

	public Long getIdJediniceMere() {
		return idJediniceMere;
	}

	public void setIdJediniceMere(Long idJediniceMere) {
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


	@Override
	public String toString() {
		return "JedinicaMere [idJediniceMere=" + idJediniceMere + ", nazivJediniceMere=" + nazivJediniceMere
				+ ", skraceniNaziv=" + skraceniNaziv + "]";
	}

}