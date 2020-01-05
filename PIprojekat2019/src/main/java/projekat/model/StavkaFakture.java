package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "StavkaFakture")
public class StavkaFakture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStavke;
	
	@Column(name = "kolicina", columnDefinition = "DECIMAL")
	private double kolicina;
	
	@Column(name = "rabat", columnDefinition = "DECIMAL")
	private double rabat;
	
	@Column(name = "jedinicnaCena", columnDefinition = "DECIMAL")
	private double jedinicnaCena;
	
	@Column(name = "pdvStopa", columnDefinition = "DECIMAL")
	private double pdvStopa;
	
	@Column(name = "osnovicaZaPDV", columnDefinition = "DECIMAL")
	private double osnovicaZaPDV;
	
	@Column(name = "iznosPDV", columnDefinition = "DECIMAL")
	private double iznosPDV;
	
	@Column(name = "ukupanIznos", columnDefinition = "DECIMAL")
	private double ukupanIznos;
	
	public StavkaFakture(double kolicina, double rabat, double jedinicnaCena, double pdvStopa,
			double osnovicaZaPDV, double iznosPDV, double ukupanIznos) {
		//this.idStavke = idStavke;
		this.kolicina = kolicina;
		this.rabat = rabat;
		this.jedinicnaCena = jedinicnaCena;
		this.pdvStopa = pdvStopa;
		this.osnovicaZaPDV = osnovicaZaPDV;
		this.iznosPDV = iznosPDV;
		this.ukupanIznos = ukupanIznos;
	}

	public int getIdStavke() {
		return idStavke;
	}

	public void setIdStavke(int idStavke) {
		this.idStavke = idStavke;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public double getRabat() {
		return rabat;
	}

	public void setRabat(double rabat) {
		this.rabat = rabat;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public double getPdvStopa() {
		return pdvStopa;
	}

	public void setPdvStopa(double pdvStopa) {
		this.pdvStopa = pdvStopa;
	}

	public double getOsnovicaZaPDV() {
		return osnovicaZaPDV;
	}

	public void setOsnovicaZaPDV(double osnovicaZaPDV) {
		this.osnovicaZaPDV = osnovicaZaPDV;
	}

	public double getIznosPDV() {
		return iznosPDV;
	}

	public void setIznosPDV(double iznosPDV) {
		this.iznosPDV = iznosPDV;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}
	
	

}
