package projekat.model;

import java.sql.Date;

public class Cenovnik {
	
	private int idCenovnika;
	private Date datumPocetkaVazenja;
	
	public Cenovnik(int idCenovnika, Date datumPocetkaVazenja) {
		this.idCenovnika = idCenovnika;
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
