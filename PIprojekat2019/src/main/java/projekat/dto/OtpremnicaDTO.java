package projekat.dto;
import java.sql.Date;

public class OtpremnicaDTO {
	
	private Long idOtpremnice;
	private int brojOtpremnice;
	private String kupac;
	private String adresaIsporuke;
	private Date datumIsporuke;
	private String prevoznik;
	private boolean potpisVozaca;
	private boolean primioRobu;
	private Long idFakture;
	private Long idNarudzbenice;
	
	public OtpremnicaDTO() {
		super();
	}
	
	public OtpremnicaDTO(Long idOtpremnice, int brojOtpremnice, String kupac, String adresaIsporuke, Date datumIsporuke,
			String prevoznik, boolean potpisVozaca, boolean primioRobu, Long idFakture, Long idNarudzbenice) {
		super();
		this.idOtpremnice = idOtpremnice;
		this.brojOtpremnice = brojOtpremnice;
		this.kupac = kupac;
		this.adresaIsporuke = adresaIsporuke;
		this.datumIsporuke = datumIsporuke;
		this.prevoznik = prevoznik;
		this.potpisVozaca = potpisVozaca;
		this.primioRobu = primioRobu;
		this.idFakture = idFakture;
		this.idNarudzbenice = idNarudzbenice;
	}



//	public OtpremnicaDTO(Otpremnica otpremnica) {
//		this.idOtpremnice = otpremnica.getIdOtpremnice();
//		this.brojOtpremnice = otpremnica.getBrojOtpremnice();
//		this.kupac = otpremnica.getKupac();
//		this.adresaIsporuke = otpremnica.getAdresaIsporuke();
//		this.datumIsporuke = otpremnica.getDatumIsporuke();
//		this.prevoznik = otpremnica.getPrevoznik();
//		this.potpisVozaca = true;
//		this.primioRobu = true;
//		this.faktura = otpremnica.getFaktura();
//	//	this.stavkaOtpremnice = otpremnica.getStavkaOtpremnice();
//	}

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

	public Long getIdFakture() {
		return idFakture;
	}

	public void setIdFakture(Long idFakture) {
		this.idFakture = idFakture;
	}

	public Long getIdNarudzbenice() {
		return idNarudzbenice;
	}

	public void setIdNarudzbenice(Long idNarudzbenice) {
		this.idNarudzbenice = idNarudzbenice;
	}
}