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
@Table(name = "narudzbenica")
public class Narudzbenica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "narudzbenica_id")
	private Long id;
	
	@Column(name = "broj_narudzbenice", columnDefinition = "INT")
	private int brojNarudzbenice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_preduzeca")
	private Preduzece preduzece;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_poslovnog_partnera")
	private PoslovniPartner poslovniPartner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_godine")
	private PoslovnaGodina poslovnaGodina;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<StavkaNarudzbenice> stavkeNarudzbenice = new ArrayList<StavkaNarudzbenice>();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Faktura> fakture = new ArrayList<Faktura>();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Otpremnica> otpremnice = new ArrayList<Otpremnica>();
	
	public Narudzbenica() {
		super();
	}

	public Narudzbenica(Long id, int brojNarudzbenice, Preduzece preduzece, PoslovniPartner poslovniPartner,
			PoslovnaGodina poslovnaGodina, List<StavkaNarudzbenice> stavkeNarudzbenice, List<Faktura> fakture,
			List<Otpremnica> otpremnice) {
		super();
		this.id = id;
		this.brojNarudzbenice = brojNarudzbenice;
		this.preduzece = preduzece;
		this.poslovniPartner = poslovniPartner;
		this.poslovnaGodina = poslovnaGodina;
		this.stavkeNarudzbenice = stavkeNarudzbenice;
		this.fakture = fakture;
		this.otpremnice = otpremnice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojNarudzbenice() {
		return brojNarudzbenice;
	}

	public void setBrojNarudzbenice(int brojNarudzbenice) {
		this.brojNarudzbenice = brojNarudzbenice;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public List<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(List<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}

	public List<Otpremnica> getOtpremnice() {
		return otpremnice;
	}

	public void setOtpremnice(List<Otpremnica> otpremnice) {
		this.otpremnice = otpremnice;
	}

	@Override
	public String toString() {
		return "Narudzbenica [id=" + id + ", brojNarudzbenice=" + brojNarudzbenice + ", preduzece=" + preduzece
				+ ", poslovniPartner=" + poslovniPartner + ", poslovnaGodina=" + poslovnaGodina
				+ ", stavkeNarudzbenice=" + stavkeNarudzbenice + ", fakture=" + fakture + ", otpremnice=" + otpremnice
				+ "]";
	}
	
}