package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "StavkaCenovnika")
public class StavkaCenovnika {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStavke;
	
	@Column(name = "cena", columnDefinition = "DECIMAL")
	private double cena;
	
	public StavkaCenovnika(double cena) {
		//this.idStavke = idStavke;
		this.cena = cena;
	}

	public int getIdStavke() {
		return idStavke;
	}

	public void setIdStavke(int idStavke) {
		this.idStavke = idStavke;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	

}
