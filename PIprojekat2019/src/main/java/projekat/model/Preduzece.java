package projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "preduzece")
public class Preduzece {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPreduzeca;
	
	@Column(name = "naziv_preduzeca", columnDefinition = "VARCHAR(20)")
	private String nazivPreduzeca;
	
	@Column(name = "adresa_preduzeca", columnDefinition = "VARCHAR(20)")
	private String adresa;
	
	@Column(name = "broj_telefona", columnDefinition = "VARCHAR(20)")
	private String brojTelefona;
	
	@Column(name = "fax_preduzeca", columnDefinition = "VARCHAR(20)")
	private String fax;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mesta")
	private NaseljenoMesto naseljenoMesto;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cenovnik> cenovnici = new ArrayList<Cenovnik>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PoslovniPartner> poslovniPartneri = new ArrayList<PoslovniPartner>();
	
	
	public Preduzece() {
		super();
	}


	public Preduzece(Long idPreduzeca, String nazivPreduzeca, String adresa, String brojTelefona, String fax,
			NaseljenoMesto naseljenoMesto, List<Cenovnik> cenovnici, List<PoslovniPartner> poslovniPartneri) {
		super();
		this.idPreduzeca = idPreduzeca;
		this.nazivPreduzeca = nazivPreduzeca;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.fax = fax;
		this.naseljenoMesto = naseljenoMesto;
		this.cenovnici = cenovnici;
		this.poslovniPartneri = poslovniPartneri;
	}


	public Long getIdPreduzeca() {
		return idPreduzeca;
	}


	public void setIdPreduzeca(Long idPreduzeca) {
		this.idPreduzeca = idPreduzeca;
	}


	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}


	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getBrojTelefona() {
		return brojTelefona;
	}


	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}


	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}


	public List<Cenovnik> getCenovnici() {
		return cenovnici;
	}


	public void setCenovnici(List<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}


	public List<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}


	public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}


	@Override
	public String toString() {
		return "Preduzece [idPreduzeca=" + idPreduzeca + ", nazivPreduzeca=" + nazivPreduzeca + ", adresa=" + adresa
				+ ", brojTelefona=" + brojTelefona + ", fax=" + fax + ", naseljenoMesto=" + naseljenoMesto
				+ ", cenovnici=" + cenovnici + ", poslovniPartneri=" + poslovniPartneri + "]";
	}
}