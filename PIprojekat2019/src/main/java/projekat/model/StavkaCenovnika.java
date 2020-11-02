package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "stavka_cenovnika")
public class StavkaCenovnika implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStavke;
	
	@Column(name = "cena", columnDefinition = "DECIMAL")
	private double cena;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cenovnik cenovnik;

	public StavkaCenovnika() {
		super();
	}
	
	public StavkaCenovnika(Long idStavke, double cena, Cenovnik cenovnik) {
		super();
		this.idStavke = idStavke;
		this.cena = cena;
		this.cenovnik = cenovnik;
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

	@Override
	public String toString() {
		return "StavkaCenovnika [idStavke=" + idStavke + ", cena=" + cena + ", cenovnik=" + cenovnik + "]";
	}	
}