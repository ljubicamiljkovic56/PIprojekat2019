//package projekat.model;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity(name = "KUF")
//public class KUF {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idKUF;
//	
//	@Column(name = "brojKUF", columnDefinition = "INT")
//	private int brojKUF;
//	
//	@Column(name = "datumPrijema", columnDefinition = "DATE")
//	private Date datumPrijema;
//	
//	@Column(name = "nazivDobavljaca", columnDefinition = "VARCHAR(20)")
//	private String nazivDobavljaca;
//	
//	@Column(name = "mestoDobavljaca", columnDefinition = "VARCHAR(20)")
//	private String mestoDobavljaca;
//	
//	@Column(name = "brojFakture", columnDefinition = "INT")
//	private int brojFakture;
//	
//	@Column(name = "datumFakture", columnDefinition = "DATE")
//	private Date datumFakture;
//	
//	@Column(name = "iznosFakture", columnDefinition = "DECIMAL")
//	private double iznosFakture;
//	
//	@Column(name = "valuta", columnDefinition = "DATE")
//	private Date valuta;
//	
//	@Column(name = "podaciOPlacanju", columnDefinition = "VARCHAR(20)")
//	private String podaciOPlacanju;
//
//	public KUF(int brojKUF, Date datumPrijema, String nazivDobavljaca, String mestoDobavljaca, int brojFakture,
//			Date datumFakture, double iznosFakture, Date valuta, String podaciOPlacanju) {
//		this.brojKUF = brojKUF;
//		this.datumPrijema = datumPrijema;
//		this.nazivDobavljaca = nazivDobavljaca;
//		this.mestoDobavljaca = mestoDobavljaca;
//		this.brojFakture = brojFakture;
//		this.datumFakture = datumFakture;
//		this.iznosFakture = iznosFakture;
//		this.valuta = valuta;
//		this.podaciOPlacanju = podaciOPlacanju;
//	}
//
//	public int getIdKUF() {
//		return idKUF;
//	}
//
//	public void setIdKUF(int idKUF) {
//		this.idKUF = idKUF;
//	}
//
//	public int getBrojKUF() {
//		return brojKUF;
//	}
//
//	public void setBrojKUF(int brojKUF) {
//		this.brojKUF = brojKUF;
//	}
//
//	public Date getDatumPrijema() {
//		return datumPrijema;
//	}
//
//	public void setDatumPrijema(Date datumPrijema) {
//		this.datumPrijema = datumPrijema;
//	}
//
//	public String getNazivDobavljaca() {
//		return nazivDobavljaca;
//	}
//
//	public void setNazivDobavljaca(String nazivDobavljaca) {
//		this.nazivDobavljaca = nazivDobavljaca;
//	}
//
//	public String getMestoDobavljaca() {
//		return mestoDobavljaca;
//	}
//
//	public void setMestoDobavljaca(String mestoDobavljaca) {
//		this.mestoDobavljaca = mestoDobavljaca;
//	}
//
//	public int getBrojFakture() {
//		return brojFakture;
//	}
//
//	public void setBrojFakture(int brojFakture) {
//		this.brojFakture = brojFakture;
//	}
//
//	public Date getDatumFakture() {
//		return datumFakture;
//	}
//
//	public void setDatumFakture(Date datumFakture) {
//		this.datumFakture = datumFakture;
//	}
//
//	public double getIznosFakture() {
//		return iznosFakture;
//	}
//
//	public void setIznosFakture(double iznosFakture) {
//		this.iznosFakture = iznosFakture;
//	}
//
//	public Date getValuta() {
//		return valuta;
//	}
//
//	public void setValuta(Date valuta) {
//		this.valuta = valuta;
//	}
//
//	public String getPodaciOPlacanju() {
//		return podaciOPlacanju;
//	}
//
//	public void setPodaciOPlacanju(String podaciOPlacanju) {
//		this.podaciOPlacanju = podaciOPlacanju;
//	}
//	
//	
//	
//
//}
