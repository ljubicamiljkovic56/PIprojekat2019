package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "StavkaOtpremnice")
public class StavkaOtpremnice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStavkeOtpremnice;
	
	@Column(name = "redniBrojProizvoda" , columnDefinition = "INT")
	private int redniBrojProizvoda;
	
	@Column(name = "nazivProizvoda", columnDefinition = "VARCHAR(20)")
	private String nazivProizvoda;
	
	@Column(name = "jedinicaMere", columnDefinition = "CHAR(2)")
	private String jedinicaMere;
	
	@Column(name = "cena", columnDefinition = "DECIMAL")
	private double cena;
	
	@Column(name = "kolicina", columnDefinition = "DECIMAL")
	private double kolicina;
	
	@Column(name = "napomena", columnDefinition = "VARCHAR(20)")
	private String napomena;

	public StavkaOtpremnice(int redniBrojProizvoda, String nazivProizvoda, String jedinicaMere, double cena,
			double kolicina, String napomena) {
		this.redniBrojProizvoda = redniBrojProizvoda;
		this.nazivProizvoda = nazivProizvoda;
		this.jedinicaMere = jedinicaMere;
		this.cena = cena;
		this.kolicina = kolicina;
		this.napomena = napomena;
	}

	public int getIdStavkeOtpremnice() {
		return idStavkeOtpremnice;
	}

	public void setIdStavkeOtpremnice(int idStavkeOtpremnice) {
		this.idStavkeOtpremnice = idStavkeOtpremnice;
	}

	public int getRedniBrojProizvoda() {
		return redniBrojProizvoda;
	}

	public void setRedniBrojProizvoda(int redniBrojProizvoda) {
		this.redniBrojProizvoda = redniBrojProizvoda;
	}

	public String getNazivProizvoda() {
		return nazivProizvoda;
	}

	public void setNazivProizvoda(String nazivProizvoda) {
		this.nazivProizvoda = nazivProizvoda;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	
	

}
