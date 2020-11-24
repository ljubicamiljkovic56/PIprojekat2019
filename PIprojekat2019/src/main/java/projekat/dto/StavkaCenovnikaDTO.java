package projekat.dto;

import java.io.Serializable;

import projekat.model.Cenovnik;
import projekat.model.RobaUsluga;
import projekat.model.StavkaCenovnika;

@SuppressWarnings("serial")
public class StavkaCenovnikaDTO implements Serializable {
	
	private Long idStavke;
	private double cena;
	private Cenovnik cenovnik;
	private RobaUsluga robaUsluga;
	
	public StavkaCenovnikaDTO() {
		super();
	}
	
	public StavkaCenovnikaDTO(Long idStavke, double cena, Cenovnik cenovnik, RobaUsluga robaUsluga) {
		super();
		this.idStavke = idStavke;
		this.cena = cena;
		this.cenovnik = cenovnik;
		this.robaUsluga = robaUsluga;
	}
	
	public StavkaCenovnikaDTO(StavkaCenovnika stavkaCenovnika) {
		this.idStavke = stavkaCenovnika.getIdStavke();
		this.cena = stavkaCenovnika.getCena();
		this.cenovnik = stavkaCenovnika.getCenovnik();
		this.robaUsluga = stavkaCenovnika.getRobaUsluga();
	}

	public Long getIdStavke() {
		return idStavke;
	}

	public void setIdStavke(Long idStavke) {
		this.idStavke = idStavke;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

}