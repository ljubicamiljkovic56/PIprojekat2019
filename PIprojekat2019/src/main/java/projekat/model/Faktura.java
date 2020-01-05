package projekat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Faktura")
public class Faktura {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFakture;
	
	@Column(name="brojFakture", columnDefinition = "INT")
	private int brojFakture;
	
	@Column(name="datumFakture", columnDefinition = "DATE")
	private Date datumFakture;
	
	@Column(name="datumValute", columnDefinition = "DATE")
	private Date datumValute;
	
	@Column(name = "ukupnaOsnovica", columnDefinition = "DECIMAL")
	private double ukupnaOsnovica;
	
	@Column(name = "ukupanPDV", columnDefinition = "DECIMAL")
	private double ukupanPDV;
	
	@Column(name = "ukupanIznos", columnDefinition = "DECIMAL")
	private double ukupanIznos;
	
	private enum StatusFakture {F, P};
	@Column(name = "statusFakture", columnDefinition = "CHAR(1)")
	private StatusFakture statusFakture;
	
	
	public Faktura(int brojFakture, Date datumFakture, Date datumValute, double ukupnaOsnovica,
			double ukupanPDV, double ukupanIznos, StatusFakture statusFakture) {
		//this.idFakture = idFakture;
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupnaOsnovica = ukupnaOsnovica;
		this.ukupanPDV = ukupanPDV;
		this.ukupanIznos = ukupanIznos;
		this.statusFakture = statusFakture;
	}

	public int getIdFakture() {
		return idFakture;
	}

	public void setIdFakture(int idFakture) {
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


	
	
	
}
