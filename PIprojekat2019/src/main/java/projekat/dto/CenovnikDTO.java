package projekat.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Cenovnik;
import projekat.model.StavkaCenovnika;

@SuppressWarnings("serial")
public class CenovnikDTO implements Serializable {
	
	private Long idCenovnika;
	private Date datumPocetkaVazenja;
	private List<StavkaCenovnika> stavkeCenovnika = new ArrayList<StavkaCenovnika>();
	
	public CenovnikDTO() {
		super();
	}
	
	
	public CenovnikDTO(Long idCenovnika, Date datumPocetkaVazenja, List<StavkaCenovnika> stavkeCenovnika) {
		super();
		this.idCenovnika = idCenovnika;
		this.datumPocetkaVazenja = datumPocetkaVazenja;
		this.stavkeCenovnika = stavkeCenovnika;
	}


	public CenovnikDTO(Cenovnik cenovnik) {
		this.idCenovnika = cenovnik.getIdCenovnika();
		this.datumPocetkaVazenja = cenovnik.getDatumPocetkaVazenja();
	//	this.stavkeCenovnika = cenovnik.getStavkeCenovnika();
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

}