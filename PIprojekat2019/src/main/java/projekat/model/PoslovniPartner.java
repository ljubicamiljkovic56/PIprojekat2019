package projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "poslovni_partner")
public class PoslovniPartner implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPoslovnogPartnera;
	
	@Column(name = "naziv_poslovnog_partnera", columnDefinition = "VARCHAR(20)")
	private String nazivPoslovnogPartnera;
	
	@Column(name = "adresa", columnDefinition = "VARCHAR(20)")
	private String adresa;
	
	@Column(name = "telefon", columnDefinition = "VARCHAR(20)")
	private String telefon;
	
	@Column(name = "fax", columnDefinition = "VARCHAR(20)")
	private String fax;
	
	@Column(name = "email", columnDefinition = "VARCHAR(20)")
	private String email;
	
	private enum VrstaPartnera {KU, DO, KD};
	
	@Column(name = "vrsta_partnera", columnDefinition = "CHAR(2)")
	private VrstaPartnera vrstaPartnera;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Faktura> fakture = new ArrayList<Faktura>();
	
	@OneToOne(fetch = FetchType.EAGER)
	private NaseljenoMesto naseljenoMesto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Preduzece preduzece;
	
	public PoslovniPartner() {
		super();
	}

	public PoslovniPartner(int idPoslovnogPartnera, String nazivPoslovnogPartnera, String adresa, String telefon,
			String fax, String email, VrstaPartnera vrstaPartnera, List<Faktura> fakture, NaseljenoMesto naseljenoMesto,
			Preduzece preduzece) {
		super();
		this.idPoslovnogPartnera = idPoslovnogPartnera;
		this.nazivPoslovnogPartnera = nazivPoslovnogPartnera;
		this.adresa = adresa;
		this.telefon = telefon;
		this.fax = fax;
		this.email = email;
		this.vrstaPartnera = vrstaPartnera;
		this.fakture = fakture;
		this.naseljenoMesto = naseljenoMesto;
		this.preduzece = preduzece;
	}

	public int getIdPoslovnogPartnera() {
		return idPoslovnogPartnera;
	}

	public void setIdPoslovnogPartnera(int idPoslovnogPartnera) {
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

	public VrstaPartnera getVrstaPartnera() {
		return vrstaPartnera;
	}

	public void setVrstaPartnera(VrstaPartnera vrstaPartnera) {
		this.vrstaPartnera = vrstaPartnera;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	@Override
	public String toString() {
		return "PoslovniPartner [idPoslovnogPartnera=" + idPoslovnogPartnera + ", nazivPoslovnogPartnera="
				+ nazivPoslovnogPartnera + ", adresa=" + adresa + ", telefon=" + telefon + ", fax=" + fax + ", email="
				+ email + ", vrstaPartnera=" + vrstaPartnera + ", fakture=" + fakture + ", naseljenoMesto="
				+ naseljenoMesto + ", preduzece=" + preduzece + "]";
	}
		
}