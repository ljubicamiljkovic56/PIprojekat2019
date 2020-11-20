package projekat.dto;

import java.io.Serializable;

import projekat.model.Otpremnica;
import projekat.model.StavkaOtpremnice;

@SuppressWarnings("serial")
public class StavkaOtpremniceDTO implements Serializable {
	
	private Long idStavkeOtpremnice;
	private int redniBrojProizvoda;
	private String jedinicaMere;
	private double cena;
	private double kolicina;
	private String napomena;
	private Otpremnica otpremnica;
	
	public StavkaOtpremniceDTO() {
		super();
	}

	public StavkaOtpremniceDTO(Long idStavkeOtpremnice, int redniBrojProizvoda, String jedinicaMere, double cena,
			double kolicina, String napomena, Otpremnica otpremnica) {
		super();
		this.idStavkeOtpremnice = idStavkeOtpremnice;
		this.redniBrojProizvoda = redniBrojProizvoda;
		this.jedinicaMere = jedinicaMere;
		this.cena = cena;
		this.kolicina = kolicina;
		this.napomena = napomena;
		this.otpremnica = otpremnica;
	}
	
	public StavkaOtpremniceDTO(StavkaOtpremnice stavkaOtpremnice) {
		this.idStavkeOtpremnice = stavkaOtpremnice.getIdStavkeOtpremnice();
		this.redniBrojProizvoda = stavkaOtpremnice.getRedniBrojProizvoda();
		this.jedinicaMere = stavkaOtpremnice.getJedinicaMere();
		this.cena = stavkaOtpremnice.getCena();
		this.kolicina = stavkaOtpremnice.getKolicina();
		this.napomena = stavkaOtpremnice.getNapomena();
		this.otpremnica = stavkaOtpremnice.getOtpremnica();
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

	public Otpremnica getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(Otpremnica otpremnica) {
		this.otpremnica = otpremnica;
	}
		
}