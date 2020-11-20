package projekat.dto;

import java.io.Serializable;

import projekat.model.Faktura;
import projekat.model.Preduzece;
import projekat.model.RobaUsluga;
import projekat.model.StavkaFakture;

@SuppressWarnings("serial")
public class StavkaFaktureDTO implements Serializable {

	private Long idStavke;
	private double kolicina;
	private double rabat;
	private double jedinicnaCena;
	private double pdvStopa;
	private double osnovicaZaPDV;
	private double iznosPDV;
	private double ukupanIznos;
	private Faktura faktura;
	private Preduzece preduzece;
	private RobaUsluga robaUsluga;
	
	public StavkaFaktureDTO() {
		super();
	}

	public StavkaFaktureDTO(Long idStavke, double kolicina, double rabat, double jedinicnaCena, double pdvStopa,
			double osnovicaZaPDV, double iznosPDV, double ukupanIznos, Faktura faktura, Preduzece preduzece,
			RobaUsluga robaUsluga) {
		super();
		this.idStavke = idStavke;
		this.kolicina = kolicina;
		this.rabat = rabat;
		this.jedinicnaCena = jedinicnaCena;
		this.pdvStopa = pdvStopa;
		this.osnovicaZaPDV = osnovicaZaPDV;
		this.iznosPDV = iznosPDV;
		this.ukupanIznos = ukupanIznos;
		this.faktura = faktura;
		this.preduzece = preduzece;
		this.robaUsluga = robaUsluga;
	}
	
	public StavkaFaktureDTO(StavkaFakture stavkaFakture) {
		this.idStavke = stavkaFakture.getIdStavke();
		this.kolicina = stavkaFakture.getKolicina();
		this.rabat = stavkaFakture.getRabat();
		this.jedinicnaCena = stavkaFakture.getJedinicnaCena();
		this.pdvStopa = stavkaFakture.getPdvStopa();
	}

	public Long getIdStavke() {
		return idStavke;
	}

	public void setIdStavke(Long idStavke) {
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

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}
	
	
}
