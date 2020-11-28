package projekat.dto;

import java.io.Serializable;
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
	private PoslovnaGodina poslovnaGodina;
	private NaseljenoMesto naseljenoMesto;
	private PoslovniPartner poslovniPartner;
	private Cenovnik cenovnik;
	
	
	public PreduzeceDTO() {
		super();
	}


	public PreduzeceDTO(Long idPreduzeca, String nazivPreduzeca, String adresa, String brojTelefona, String fax,
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
		this.cenovnik = cenovnik;
		this.poslovniPartner = poslovniPartner;
	}
	
	public PreduzeceDTO(Preduzece preduzece) {
		this.idPreduzeca = preduzece.getIdPreduzeca();
		this.nazivPreduzeca = preduzece.getNazivPreduzeca();
		this.adresa = preduzece.getAdresa();
		this.brojTelefona = preduzece.getBrojTelefona();
		this.fax = preduzece.getFax();
		this.poslovnaGodina = preduzece.getPoslovnaGodina();
		this.naseljenoMesto = preduzece.getNaseljenoMesto();
		this.poslovniPartner = preduzece.getPoslovniPartner();
		this.cenovnik = preduzece.getCenovnik();
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


	

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}


	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}


	public Cenovnik getCenovnik() {
		return cenovnik;
	}


	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}




	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}


	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}


	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}


	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}
	
	

}
