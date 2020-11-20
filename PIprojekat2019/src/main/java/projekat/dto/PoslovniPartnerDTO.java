package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Faktura;
import projekat.model.NaseljenoMesto;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;


@SuppressWarnings("serial")
public class PoslovniPartnerDTO implements Serializable {
	
	private int idPoslovnogPartnera;
	private String nazivPoslovnogPartnera;
	private String adresa;
	private String telefon;
	private String fax;
	private String email;
	private enum VrstaPartnera {KU, DO, KD};
	private VrstaPartnera vrstaPartnera;
	private List<Faktura> fakture = new ArrayList<Faktura>();
	private NaseljenoMesto naseljenoMesto;
	private Preduzece preduzece;
	
	private PoslovniPartnerDTO() {
		super();
	}

	public PoslovniPartnerDTO(int idPoslovnogPartnera, String nazivPoslovnogPartnera, String adresa, String telefon,
			String fax, String email, VrstaPartnera vrstaPartnera, List<Faktura> fakture, NaseljenoMesto naseljenoMesto,
			Preduzece preduzece) {
		super();
		this.idPoslovnogPartnera = idPoslovnogPartnera;
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
		this.email = email;
		this.vrstaPartnera = vrstaPartnera;
		this.fakture = fakture;
		this.naseljenoMesto = naseljenoMesto;
		this.preduzece = preduzece;
	}
	
	public PoslovniPartnerDTO(PoslovniPartner poslovniPartner) {
		this.idPoslovnogPartnera = poslovniPartner.getIdPoslovnogPartnera();
		this.nazivPoslovnogPartnera = poslovniPartner.getNazivPoslovnogPartnera();
		this.adresa = poslovniPartner.getAdresa();
		this.telefon = poslovniPartner.getTelefon();
		this.fax = poslovniPartner.getFax();
		this.email = poslovniPartner.getEmail();
		//this.vrstaPartnera = poslovniPartner.getVrstaPartnera();
		this.fakture = poslovniPartner.getFakture();
		this.naseljenoMesto = poslovniPartner.getNaseljenoMesto();
		this.preduzece = poslovniPartner.getPreduzece();
		
	}

	public int getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(int idPoslovnogPartnera) {
		this.idPoslovnogPartnera = idPoslovnogPartnera;
	}

	public String getNazivPoslovnogPartnera() {
		return nazivPoslovnogPartnera;
	}

	public void setNazivPoslovnogPartnera(String nazivPoslovnogPartnera) {
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public VrstaPartnera getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(VrstaPartnera vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

}