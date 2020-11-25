package projekat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Cenovnik() {
		super();
	}
	
	public Cenovnik(Long idCenovnika, Date datumPocetkaVazenja, List<StavkaCenovnika> stavkeCenovnika) {
		super();
		this.idCenovnika = idCenovnika;
		this.datumPocetkaVazenja = datumPocetkaVazenja;
		//this.stavkeCenovnika = stavkeCenovnika;
		//this.preduzece = preduzece;
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

	@Override
	public String toString() {
		return "Cenovnik [idCenovnika=" + idCenovnika + ", datumPocetkaVazenja=" + datumPocetkaVazenja + "]";
	}
	
}