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
@Table(name = "faktura")
public class Faktura implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFakture;
	
	@Column(name = "broj_fakture", columnDefinition = "INT")
	private int brojFakture;
	
	@Column(name = "datum_fakture", columnDefinition = "DATE")
	private Date datumFakture;
	
	@Column(name = "datum_valute", columnDefinition = "DATE")
	private Date datumValute;
	
	@Column(name = "ukupna_osnovica", columnDefinition = "DECIMAL")
	private double ukupnaOsnovica;
	
	@Column(name = "ukupan_pdv", columnDefinition = "DECIMAL")
	private double ukupanPDV;
	
	@Column(name = "ukupan_iznos", columnDefinition = "DECIMAL")
	private double ukupanIznos;
	
	//private enum StatusFakture {F, P};
	@Column(name = "status_fakture", columnDefinition = "CHAR(1)")
	private String statusFakture;
	
	@OneToOne
	@JoinColumn(name = "id_stavke_fakture")
	private StavkaFakture stavkaFakture;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_godine")
	private PoslovnaGodina poslovnaGodina;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_poslovnog_partnera")
	private PoslovniPartner poslovniPartner;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_preduzeca")
	private Preduzece preduzece;
	
	
	
	public Faktura() {
		super();
	}

	public Faktura(Long idFakture, int brojFakture, Date datumFakture, Date datumValute, double ukupnaOsnovica,
			double ukupanPDV, double ukupanIznos, String statusFakture, StavkaFakture stavkaFakture,
			PoslovnaGodina poslovnaGodina, PoslovniPartner poslovniPartner, Preduzece preduzece) {
		super();
		this.idFakture = idFakture;
		this.brojFakture = brojFakture;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupnaOsnovica = ukupnaOsnovica;
		this.ukupanPDV = ukupanPDV;
		this.ukupanIznos = ukupanIznos;
		this.statusFakture = statusFakture;
		this.stavkaFakture = stavkaFakture;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.preduzece = preduzece;
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

	public String getStatusFakture() {
		return statusFakture;
	}

	public void setStatusFakture(String statusFakture) {
		this.statusFakture = statusFakture;
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

	public StavkaFakture getStavkaFakture() {
		return stavkaFakture;
	}

	public void setStavkaFakture(StavkaFakture stavkaFakture) {
		this.stavkaFakture = stavkaFakture;
	}

	@Override
	public String toString() {
		return "Faktura [idFakture=" + idFakture + ", brojFakture=" + brojFakture + ", datumFakture=" + datumFakture
				+ ", datumValute=" + datumValute + ", ukupnaOsnovica=" + ukupnaOsnovica + ", ukupanPDV=" + ukupanPDV
				+ ", ukupanIznos=" + ukupanIznos + ", statusFakture=" + statusFakture + ", stavkaFakture="
				+ stavkaFakture + ", poslovnaGodina=" + poslovnaGodina + ", poslovniPartner=" + poslovniPartner
				+ ", preduzece=" + preduzece + "]";
	}

	
	
}