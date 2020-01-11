package projekat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Otpremnica")
public class Otpremnica {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOtpremnice;
	
	@Column(name = "brojOtpremnice", columnDefinition = "INT")
	private int brojOtpremnice;
	
	@Column(name = "kupac", columnDefinition = "VARCHAR(20)")
	private String kupac;
	
	@Column(name = "adresaIsporuke", columnDefinition = "VARCHAR(20)")
	private String adresaIsporuke;
	
	@Column(name = "datumIsporuke", columnDefinition = "DATE")
	private Date datumIsporuke;
	
	@Column(name = "prevoznik", columnDefinition = "VARCHAR(20)")
	private String prevoznik;
	
	@Column(name = "potpisVozaca", columnDefinition = "TINYINT(1)")
	private boolean potpisVozaca;
	
	@Column(name = "primioRobu", columnDefinition = "TINYINT(1)")
	private boolean primioRobu;

	public Otpremnica(int brojOtpremnice, String kupac, String adresaIsporuke, Date datumIsporuke, String prevoznik,
			boolean potpisVozaca, boolean primioRobu) {
		this.brojOtpremnice = brojOtpremnice;
		this.kupac = kupac;
		this.adresaIsporuke = adresaIsporuke;
		this.datumIsporuke = datumIsporuke;
		this.prevoznik = prevoznik;
		this.potpisVozaca = potpisVozaca;
		this.primioRobu = primioRobu;
	}

	public int getIdOtpremnice() {
		return idOtpremnice;
	}

	public void setIdOtpremnice(int idOtpremnice) {
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
	
	
	

}
