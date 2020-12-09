package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stavka_fakture")
public class StavkaFakture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStavke;
	
	@Column(name = "kolicina", columnDefinition = "DECIMAL")
	private double kolicina;
	
	@Column(name = "rabat", columnDefinition = "DECIMAL")
	private double rabat;
	
	@Column(name = "jedinicna_cena", columnDefinition = "DECIMAL")
	private double jedinicnaCena;
	
	@Column(name = "pdv_stopa", columnDefinition = "DECIMAL")
	private double pdvStopa;
	
	@Column(name = "osnovica_za_pdv", columnDefinition = "DECIMAL")
	private double osnovicaZaPDV;
	
	@Column(name = "iznos_pdv", columnDefinition = "DECIMAL")
	private double iznosPDV;
	
	@Column(name = "ukupan_iznos", columnDefinition = "DECIMAL")
	private double ukupanIznos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_preduzeca")
	private Preduzece preduzece;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fakture")
	private Faktura faktura;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_robe")
	private RobaUsluga robaUsluga;

	
	public StavkaFakture() {
		super();
	}


	public StavkaFakture(Long idStavke, double kolicina, double rabat, double jedinicnaCena, double pdvStopa,
			double osnovicaZaPDV, double iznosPDV, double ukupanIznos, Preduzece preduzece, Faktura faktura,
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
		this.preduzece = preduzece;
		this.faktura = faktura;
		this.robaUsluga = robaUsluga;
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


	public Preduzece getPreduzece() {
		return preduzece;
	}


	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}


	public Faktura getFaktura() {
		return faktura;
	}


	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}


	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}


	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}


	@Override
	public String toString() {
		return "StavkaFakture [idStavke=" + idStavke + ", kolicina=" + kolicina + ", rabat=" + rabat
				+ ", jedinicnaCena=" + jedinicnaCena + ", pdvStopa=" + pdvStopa + ", osnovicaZaPDV=" + osnovicaZaPDV
				+ ", iznosPDV=" + iznosPDV + ", ukupanIznos=" + ukupanIznos + ", preduzece=" + preduzece + ", faktura="
				+ faktura + ", robaUsluga=" + robaUsluga + "]";
	}


}