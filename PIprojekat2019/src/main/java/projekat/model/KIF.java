package projekat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "KIF")
public class KIF {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKIF;
	
	@Column(name = "brojKIF", columnDefinition = "INT")
	private int brojKIF;
	
	@Column(name = "datumPrijema", columnDefinition = "DATE")
	private Date datumPrijema;
	
	@Column(name = "nazivFirme", columnDefinition = "VARCHAR(20)")
	private String nazivFirme;
	
	@Column(name = "pib", columnDefinition = "VARCHAR(20)")
	private String pib;
	
	@Column(name = "oslobodjenje", columnDefinition = "VARCHAR(10)")
	private String oslobodjenje;

	public KIF(int brojKIF, Date datumPrijema, String nazivFirme, String pib, String oslobodjenje) {
		this.brojKIF = brojKIF;
		this.datumPrijema = datumPrijema;
		this.nazivFirme = nazivFirme;
		this.pib = pib;
		this.oslobodjenje = oslobodjenje;
	}

	public int getIdKIF() {
		return idKIF;
	}

	public void setIdKIF(int idKIF) {
		this.idKIF = idKIF;
	}

	public int getBrojKIF() {
		return brojKIF;
	}

	public void setBrojKIF(int brojKIF) {
		this.brojKIF = brojKIF;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public String getNazivFirme() {
		return nazivFirme;
	}

	public void setNazivFirme(String nazivFirme) {
		this.nazivFirme = nazivFirme;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getOslobodjenje() {
		return oslobodjenje;
	}

	public void setOslobodjenje(String oslobodjenje) {
		this.oslobodjenje = oslobodjenje;
	}
	
	
	
	

}
