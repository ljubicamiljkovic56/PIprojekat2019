package projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "preduzece")
public class Preduzece implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPreduzeca;
	
	@Column(name = "naziv_preduzeca", columnDefinition = "VARCHAR(20)")
	private String nazivPreduzeca;
	
	@Column(name = "adresa", columnDefinition = "VARCHAR(20)")
	private String adresa;
	
	@Column(name = "broj_telefona", columnDefinition = "VARCHAR(20)")
	private String brojTelefona;
	
	@Column(name = "fax", columnDefinition = "VARCHAR(20)")
	private String fax;
	
	@OneToOne
	@JoinColumn(name = "id_godine")
	private PoslovnaGodina poslovnaGodina;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "id_mesta")
	private NaseljenoMesto naseljenoMesto;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	private List<PoslovniPartner> poslovniPartneri = new ArrayList<PoslovniPartner>();
	
	@ManyToOne
	@JoinColumn(name = "id_partnera")
	private PoslovniPartner poslovniPartner;
	
	@OneToOne
	@JoinColumn(name = "id_cenovnika")
	private Cenovnik cenovnik;
	
	@OneToMany
	private List<Faktura> fakture = new ArrayList<Faktura>();
	
	@OneToMany
	private List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
	
	public Preduzece() {
		super();
	}

	public Preduzece(Long idPreduzeca, String nazivPreduzeca, String adresa, String brojTelefona, String fax,
			PoslovnaGodina poslovnaGodina, NaseljenoMesto naseljenoMesto, PoslovniPartner poslovniPartner,
			Cenovnik cenovnik, List<Faktura> fakture, List<StavkaFakture> stavkeFakture) {
		super();
		this.idPreduzeca = idPreduzeca;
		this.nazivPreduzeca = nazivPreduzeca;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.fax = fax;
		this.poslovnaGodina = poslovnaGodina;
		this.naseljenoMesto = naseljenoMesto;
	//this.poslovniPartneri = poslovniPartneri;
		//this.poslovniPartner = poslovniPartner;
		this.cenovnik = cenovnik;
		this.fakture = fakture;
		this.stavkeFakture = stavkeFakture;
		this.poslovniPartner = poslovniPartner;
	}

	public Long getIdPreduzeca() {
		return idPreduzeca;
	}

	public void setIdPreduzeca(Long idPreduzeca) {
		this.idPreduzeca = idPreduzeca;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

//	public List<PoslovnaGodina> getPoslovneGodine() {
//		return poslovneGodine;
//	}
//
//	public void setPoslovneGodine(List<PoslovnaGodina> poslovneGodine) {
//		this.poslovneGodine = poslovneGodine;
//	}
	
	

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	/*
	 * public List<PoslovniPartner> getPoslovniPartneri() { return poslovniPartneri;
	 * }
	 * 
	 * public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
	 * this.poslovniPartneri = poslovniPartneri; }
	 */

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}

	public List<StavkaFakture> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	@Override
	public String toString() {
		return "Preduzece [idPreduzeca=" + idPreduzeca + ", nazivPreduzeca=" + nazivPreduzeca + ", adresa=" + adresa
				+ ", brojTelefona=" + brojTelefona + ", fax=" + fax + ", poslovnaGodina=" + poslovnaGodina
				+ ", naseljenoMesto=" + naseljenoMesto + ", cenovnik=" + cenovnik + ", fakture=" + fakture
				+ ", stavkeFakture=" + stavkeFakture + "]";
	}

	

}