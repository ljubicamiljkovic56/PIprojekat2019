package projekat.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Faktura;
import projekat.model.Otpremnica;
import projekat.model.StavkaOtpremnice;

@SuppressWarnings("serial")
public class OtpremnicaDTO implements Serializable {
	
	private Long idOtpremnice;
	private int brojOtpremnice;
	private String kupac;
	private String adresaIsporuke;
	private Date datumIsporuke;
	private String prevoznik;
	private boolean potpisVozaca;
	private boolean primioRobu;
	private List<StavkaOtpremnice> stavkeOtpremnice = new ArrayList<StavkaOtpremnice>();
	private Faktura faktura;
	
	public OtpremnicaDTO() {
		super();
	}

	public OtpremnicaDTO(Long idOtpremnice, int brojOtpremnice, String kupac, String adresaIsporuke, Date datumIsporuke,
			String prevoznik, boolean potpisVozaca, boolean primioRobu, List<StavkaOtpremnice> stavkeOtpremnice,
			Faktura faktura) {
		super();
		this.idOtpremnice = idOtpremnice;
		this.brojOtpremnice = brojOtpremnice;
		this.kupac = kupac;
		this.adresaIsporuke = adresaIsporuke;
		this.datumIsporuke = datumIsporuke;
		this.prevoznik = prevoznik;
		this.potpisVozaca = potpisVozaca;
		this.primioRobu = primioRobu;
		this.stavkeOtpremnice = stavkeOtpremnice;
		this.faktura = faktura;
	}
	
	public OtpremnicaDTO(Otpremnica otpremnica) {
		this.idOtpremnice = otpremnica.getIdOtpremnice();
		this.brojOtpremnice = otpremnica.getBrojOtpremnice();
		this.kupac = otpremnica.getKupac();
		this.adresaIsporuke = otpremnica.getAdresaIsporuke();
		this.datumIsporuke = otpremnica.getDatumIsporuke();
		this.prevoznik = otpremnica.getPrevoznik();
		this.potpisVozaca = true;
		this.primioRobu = true;
		this.stavkeOtpremnice = otpremnica.getStavkeOtpremnice();
		this.faktura = otpremnica.getFaktura();
	}

	public Long getIdOtpremnice() {
		return idOtpremnice;
	}

	public void setIdOtpremnice(Long idOtpremnice) {
		this.idOtpremnice = idOtpremnice;
	}

	public int getBrojOtpremnice() {
		return brojOtpremnice;
	}

	public void setBrojOtpremnice(int brojOtpremnice) {
		this.brojOtpremnice = brojOtpremnice;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		this.kupac = kupac;
	}

	public String getAdresaIsporuke() {
		return adresaIsporuke;
	}

	public void setAdresaIsporuke(String adresaIsporuke) {
		this.adresaIsporuke = adresaIsporuke;
	}

	public Date getDatumIsporuke() {
		return datumIsporuke;
	}

	public void setDatumIsporuke(Date datumIsporuke) {
		this.datumIsporuke = datumIsporuke;
	}

	public String getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(String prevoznik) {
		this.prevoznik = prevoznik;
	}

	public boolean isPotpisVozaca() {
		return potpisVozaca;
	}

	public void setPotpisVozaca(boolean potpisVozaca) {
		this.potpisVozaca = potpisVozaca;
	}

	public boolean isPrimioRobu() {
		return primioRobu;
	}

	public void setPrimioRobu(boolean primioRobu) {
		this.primioRobu = primioRobu;
	}

	public List<StavkaOtpremnice> getStavkeOtpremnice() {
		return stavkeOtpremnice;
	}

	public void setStavkeOtpremnice(List<StavkaOtpremnice> stavkeOtpremnice) {
		this.stavkeOtpremnice = stavkeOtpremnice;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}
	
	
}