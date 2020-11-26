package projekat.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "otpremnica")
public class Otpremnica implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOtpremnice;
	
	@Column(name = "broj_otpremnice", columnDefinition = "INT")
	private int brojOtpremnice;
	
	@Column(name = "kupac", columnDefinition = "VARCHAR(20)")
	private String kupac;
	
	@Column(name = "adresa_isporuke", columnDefinition = "VARCHAR(30)")
	private String adresaIsporuke;
	
	@Column(name = "datum_isporuke", columnDefinition = "DATE")
	private Date datumIsporuke;
	
	@Column(name = "prevoznik", columnDefinition = "VARCHAR(20)")
	private String prevoznik;
	
	@Column(name = "potpis_vozaca", columnDefinition = "TINYINT(1)")
	private boolean potpisVozaca;
	
	@Column(name = "primio_robu", columnDefinition = "TINYINT(1)")
	private boolean primioRobu;

	
	@OneToOne
	@JoinColumn(name = "id_fakture")
	private Faktura faktura;
	
	@OneToOne
	@JoinColumn(name = "id_stavke_otpremnice")
	private StavkaOtpremnice stavkaOtpremnice;
	
	
	
	public Otpremnica() {
		super();
	}

	public Otpremnica(Long idOtpremnice, int brojOtpremnice, String kupac, String adresaIsporuke, Date datumIsporuke,
			String prevoznik, boolean potpisVozaca, boolean primioRobu,
			Faktura faktura, StavkaOtpremnice stavkaOtpremnice) {
		super();
		this.idOtpremnice = idOtpremnice;
		this.brojOtpremnice = brojOtpremnice;
		this.kupac = kupac;
		this.adresaIsporuke = adresaIsporuke;
		this.datumIsporuke = datumIsporuke;
		this.prevoznik = prevoznik;
		this.potpisVozaca = potpisVozaca;
		this.primioRobu = primioRobu;
		this.faktura = faktura;
		this.stavkaOtpremnice = stavkaOtpremnice;
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


	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}



	public StavkaOtpremnice getStavkaOtpremnice() {
		return stavkaOtpremnice;
	}

	public void setStavkaOtpremnice(StavkaOtpremnice stavkaOtpremnice) {
		this.stavkaOtpremnice = stavkaOtpremnice;
	}

	@Override
	public String toString() {
		return "Otpremnica [idOtpremnice=" + idOtpremnice + ", brojOtpremnice=" + brojOtpremnice + ", kupac=" + kupac
				+ ", adresaIsporuke=" + adresaIsporuke + ", datumIsporuke=" + datumIsporuke + ", prevoznik=" + prevoznik
				+ ", potpisVozaca=" + potpisVozaca + ", primioRobu=" + primioRobu + ", stavkaOtpremnice="
				+ stavkaOtpremnice + "]";
	}
	
	
}