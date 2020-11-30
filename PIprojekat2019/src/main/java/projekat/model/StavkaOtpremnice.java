package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "stavka_otpremnice")
public class StavkaOtpremnice implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStavkeOtpremnice;
	
	@Column(name = "redni_broj_proizvoda" , columnDefinition = "INT")
	private int redniBrojProizvoda;
	
	@Column(name = "jedinica_mere", columnDefinition = "CHAR(5)")
	private String jedinicaMere;
	
	@Column(name = "cena", columnDefinition = "DECIMAL")
	private double cena;
	
	@Column(name = "kolicina", columnDefinition = "DECIMAL")
	private double kolicina;
	
	@Column(name = "napomena", columnDefinition = "VARCHAR(20)")
	private String napomena;
	
	
	public StavkaOtpremnice() {
		super();
	}

	public StavkaOtpremnice(Long idStavkeOtpremnice, int redniBrojProizvoda, String jedinicaMere,
			double cena, double kolicina, String napomena) {
		super();
		this.idStavkeOtpremnice = idStavkeOtpremnice;
		this.redniBrojProizvoda = redniBrojProizvoda;
		this.jedinicaMere = jedinicaMere;
		this.cena = cena;
		this.kolicina = kolicina;
		this.napomena = napomena;
	}


	public Long getIdStavkeOtpremnice() {
		return idStavkeOtpremnice;
	}


	public void setIdStavkeOtpremnice(Long idStavkeOtpremnice) {
		this.idStavkeOtpremnice = idStavkeOtpremnice;
	}


	public int getRedniBrojProizvoda() {
		return redniBrojProizvoda;
	}


	public void setRedniBrojProizvoda(int redniBrojProizvoda) {
		this.redniBrojProizvoda = redniBrojProizvoda;
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

	@Override
	public String toString() {
		return "StavkaOtpremnice [idStavkeOtpremnice=" + idStavkeOtpremnice + ", redniBrojProizvoda="
				+ redniBrojProizvoda + ", jedinicaMere=" + jedinicaMere
				+ ", cena=" + cena + ", kolicina=" + kolicina + ", napomena=" + napomena
				+ "]";
	}
	
}