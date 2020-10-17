package projekat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "cenovnik")
public class Cenovnik implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCenovnika;
	
	@Column(name="datum_pocetka_vazenja", columnDefinition = "DATE")
	private Date datumPocetkaVazenja;
	
	@OneToMany(mappedBy = "cenovnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StavkaCenovnika> stavkeCenovnika = new ArrayList<StavkaCenovnika>();
	
	@OneToOne(fetch = FetchType.LAZY)
	private Preduzece preduzece;

	public Cenovnik(Long idCenovnika, Date datumPocetkaVazenja, List<StavkaCenovnika> stavkeCenovnika,
			Preduzece preduzece) {
		super();
		this.idCenovnika = idCenovnika;
		this.datumPocetkaVazenja = datumPocetkaVazenja;
		this.stavkeCenovnika = stavkeCenovnika;
		this.preduzece = preduzece;
	}

	public Long getIdCenovnika() {
		return idCenovnika;
	}

	public void setIdCenovnika(Long idCenovnika) {
		this.idCenovnika = idCenovnika;
	}

	public Date getDatumPocetkaVazenja() {
		return datumPocetkaVazenja;
	}

	public void setDatumPocetkaVazenja(Date datumPocetkaVazenja) {
		this.datumPocetkaVazenja = datumPocetkaVazenja;
	}

	public List<StavkaCenovnika> getStavkeCenovnika() {
		return stavkeCenovnika;
	}

	public void setStavkeCenovnika(List<StavkaCenovnika> stavkeCenovnika) {
		this.stavkeCenovnika = stavkeCenovnika;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	@Override
	public String toString() {
		return "Cenovnik [idCenovnika=" + idCenovnika + ", datumPocetkaVazenja=" + datumPocetkaVazenja
				+ ", stavkeCenovnika=" + stavkeCenovnika + ", preduzece=" + preduzece + "]";
	}

	
}