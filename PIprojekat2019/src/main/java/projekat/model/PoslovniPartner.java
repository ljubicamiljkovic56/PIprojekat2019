package projekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "poslovni_partner")
public class PoslovniPartner implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPoslovnogPartnera;
	
	@Column(name = "naziv_poslovnog_partnera", columnDefinition = "VARCHAR(20)")
	private String nazivPoslovnogPartnera;
	
	@Column(name = "adresa", columnDefinition = "VARCHAR(20)")
	private String adresa;
	
	@Column(name = "telefon", columnDefinition = "VARCHAR(20)")
	private String telefon;
	
	@Column(name = "fax", columnDefinition = "VARCHAR(20)")
	private String fax;
	
	@Column(name = "email", columnDefinition = "VARCHAR(40)")
	private String email;
	
	//private enum VrstaPartnera {KU, DO, KD};
	
	@Column(name = "vrsta_partnera", columnDefinition = "CHAR(2)")
	private String vrstaPartnera;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mesta")
	private NaseljenoMesto naseljenoMesto;
	
	public PoslovniPartner() {
		super();
	}

	public PoslovniPartner(Long idPoslovnogPartnera, String nazivPoslovnogPartnera, String adresa, String telefon,
			String fax, String email, String vrstaPartnera, List<Faktura> fakture, NaseljenoMesto naseljenoMesto) {
		super();
		this.idPoslovnogPartnera = idPoslovnogPartnera;
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
		this.email = email;
		this.vrstaPartnera = vrstaPartnera;
		//this.fakture = fakture;
		this.naseljenoMesto = naseljenoMesto;
		//this.preduzece = preduzece;
	}

	public Long getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(Long idPoslovnogPartnera) {
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

	public String getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(String vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}

//	public List<Faktura> getFakture() {
//		return fakture;
//	}
//
//	public void setFakture(List<Faktura> fakture) {
//		this.fakture = fakture;
//	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

//	public Preduzece getPreduzece() {
//		return preduzece;
//	}
//
//	public void setPreduzece(Preduzece preduzece) {
//		this.preduzece = preduzece;
//	}

	@Override
	public String toString() {
		return "PoslovniPartner [idPoslovnogPartnera=" + idPoslovnogPartnera + ", nazivPoslovnogPartnera="
				+ nazivPoslovnogPartnera + ", adresa=" + adresa + ", telefon=" + telefon + ", fax=" + fax + ", email="
				+ email + ", vrstaPartnera=" + vrstaPartnera + ", naseljenoMesto=" + naseljenoMesto + "]";
	}


}