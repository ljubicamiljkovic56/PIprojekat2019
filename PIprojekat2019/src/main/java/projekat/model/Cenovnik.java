package projekat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Cenovnik")
public class Cenovnik {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCenovnika;
	
	@Column(name="datumPocetkaVazenja", columnDefinition = "DATE")
	private Date datumPocetkaVazenja;
	
	public Cenovnik(Date datumPocetkaVazenja) {
		//this.idCenovnika = idCenovnika;
		this.datumPocetkaVazenja = datumPocetkaVazenja;
	}

	public int getIdCenovnika() {
		return idCenovnika;
	}

	public void setIdCenovnika(int idCenovnika) {
		this.idCenovnika = idCenovnika;
	}

	public Date getDatumPocetkaVazenja() {
		return datumPocetkaVazenja;
	}

	public void setDatumPocetkaVazenja(Date datumPocetkaVazenja) {
		this.datumPocetkaVazenja = datumPocetkaVazenja;
	}


	
	
	
	

}
