package projekat.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Faktura;
import projekat.model.Otpremnica;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.model.StavkaFakture;

@SuppressWarnings("serial")
public class FakturaDTO implements Serializable {
	
	private Long idFakture;
	private int brojFakture;
	private Date datumFakture;
	private Date datumValute;
	private double ukupnaOsnovica;
	private double ukupanPDV;
	private double ukupanIznos;
	private enum StatusFakture {F, P};
	private StatusFakture statusFakture;
	private List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
	private PoslovnaGodina poslovnaGodina;
	private PoslovniPartner poslovniPartner;
	private Preduzece preduzece;
	private List<Otpremnica> otpremnice = new ArrayList<Otpremnica>();
	

	public FakturaDTO() {
		super();
	}


	public FakturaDTO(Long idFakture, int brojFakture, Date datumFakture, Date datumValute, double ukupnaOsnovica,
			double ukupanPDV, double ukupanIznos, StatusFakture statusFakture, List<StavkaFakture> stavkeFakture,
			PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner, Preduzece preduzece,
			List<Otpremnica> otpremnice) {
		super();
		this.idFakture = idFakture;
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupnaOsnovica = ukupnaOsnovica;
		this.ukupanPDV = ukupanPDV;
		this.ukupanIznos = ukupanIznos;
		this.statusFakture = statusFakture;
		this.stavkeFakture = stavkeFakture;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
		this.otpremnice = otpremnice;
	}

	
	@SuppressWarnings("static-access")
	public FakturaDTO(Faktura faktura) {
		this.idFakture = faktura.getIdFakture();
		this.brojFakture = faktura.getBrojFakture();
		this.datumFakture = faktura.getDatumFakture();
		this.datumValute = faktura.getDatumValute();
		this.ukupnaOsnovica = faktura.getUkupnaOsnovica();
		this.ukupanPDV = faktura.getUkupanPDV();
		this.ukupanIznos = faktura.getUkupanIznos();
		this.statusFakture = statusFakture.P;
	}

	public Long getIdFakture() {
		return idFakture;
	}


	public void setIdFakture(Long idFakture) {
		this.idFakture = idFakture;
	}


	public int getBrojFakture() {
		return brojFakture;
	}


	public void setBrojFakture(int brojFakture) {
		this.brojFakture = brojFakture;
	}


	public Date getDatumFakture() {
		return datumFakture;
	}


	public void setDatumFakture(Date datumFakture) {
		this.datumFakture = datumFakture;
	}


	public Date getDatumValute() {
		return datumValute;
	}


	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}


	public double getUkupnaOsnovica() {
		return ukupnaOsnovica;
	}


	public void setUkupnaOsnovica(double ukupnaOsnovica) {
		this.ukupnaOsnovica = ukupnaOsnovica;
	}


	public double getUkupanPDV() {
		return ukupanPDV;
	}


	public void setUkupanPDV(double ukupanPDV) {
		this.ukupanPDV = ukupanPDV;
	}


	public double getUkupanIznos() {
		return ukupanIznos;
	}


	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}


	public StatusFakture getStatusFakture() {
		return statusFakture;
	}


	public void setStatusFakture(StatusFakture statusFakture) {
		this.statusFakture = statusFakture;
	}


	public List<StavkaFakture> getStavkeFakture() {
		return stavkeFakture;
	}


	public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
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


	public Preduzece getPreduzece() {
		return preduzece;
	}


	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}


	public List<Otpremnica> getOtpremnice() {
		return otpremnice;
	}


	public void setOtpremnice(List<Otpremnica> otpremnice) {
		this.otpremnice = otpremnice;
	}	
	
}