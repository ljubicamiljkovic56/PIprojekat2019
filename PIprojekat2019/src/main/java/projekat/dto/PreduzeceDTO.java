package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Cenovnik;
import projekat.model.Faktura;
import projekat.model.NaseljenoMesto;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.model.StavkaFakture;

@SuppressWarnings("serial")
public class PreduzeceDTO implements Serializable {
	
	private Long idPreduzeca;
	private String nazivPreduzeca;
	private String adresa;
	private String brojTelefona;
	private String fax;
	private List<PoslovnaGodina> poslovneGodine = new ArrayList<PoslovnaGodina>();
	private NaseljenoMesto naseljenoMesto;
	private List<PoslovniPartner> poslovniPartneri = new ArrayList<PoslovniPartner>();
	private Cenovnik cenovnik;
	private List<Faktura> fakture = new ArrayList<Faktura>();
	private List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
	
	
	public PreduzeceDTO() {
		super();
	}


	public PreduzeceDTO(Long idPreduzeca, String nazivPreduzeca, String adresa, String brojTelefona, String fax,
			List<PoslovnaGodina> poslovneGodine, NaseljenoMesto naseljenoMesto, List<PoslovniPartner> poslovniPartneri,
			Cenovnik cenovnik, List<Faktura> fakture, List<StavkaFakture> stavkeFakture) {
		super();
		this.idPreduzeca = idPreduzeca;
		this.nazivPreduzeca = nazivPreduzeca;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.fax = fax;
		this.poslovneGodine = poslovneGodine;
		this.naseljenoMesto = naseljenoMesto;
		this.poslovniPartneri = poslovniPartneri;
		this.cenovnik = cenovnik;
		this.fakture = fakture;
		this.stavkeFakture = stavkeFakture;
	}
	
	public PreduzeceDTO(Preduzece preduzece) {
		this.idPreduzeca = preduzece.getIdPreduzeca();
		this.nazivPreduzeca = preduzece.getNazivPreduzeca();
		this.adresa = preduzece.getAdresa();
		this.brojTelefona = preduzece.getBrojTelefona();
		this.fax = preduzece.getFax();
		this.poslovneGodine = preduzece.getPoslovneGodine();
		this.naseljenoMesto = preduzece.getNaseljenoMesto();
		this.poslovniPartneri = preduzece.getPoslovniPartneri();
		this.cenovnik = preduzece.getCenovnik();
		this.fakture = preduzece.getFakture();
		this.stavkeFakture = preduzece.getStavkeFakture();
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


	public List<PoslovnaGodina> getPoslovneGodine() {
		return poslovneGodine;
	}


	public void setPoslovneGodine(List<PoslovnaGodina> poslovneGodine) {
		this.poslovneGodine = poslovneGodine;
	}


	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}


	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}


	public List<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}


	public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}


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
	
	

}
