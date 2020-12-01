package projekat.model;

import java.io.Serializable;

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
@Table(name = "narudzbenica")
public class Narudzbenica implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "narudzbenica_id")
	private Long id;
	
	@Column(name = "naziv_robe", columnDefinition = "VARCHAR(30)")
	private String nazivRobe;
	
	@Column(name = "jedinica_mere", columnDefinition = "CHAR(5)")
	private String jedinicaMere;
	
	@Column(name = "kolicina", columnDefinition = "DECIMAL")
	private double kolicina;
	
	@Column(name = "cena", columnDefinition = "DECIMAL")
	private double cena;
	
	@Column(name = "iznos", columnDefinition = "DECIMAL")
	private double iznos;
	
	@OneToOne
	@JoinColumn(name = "id_fakture")
	private Faktura faktura;
	
	public Narudzbenica() {
		super();
	}

	public Narudzbenica(Long id, String nazivRobe, String jedinicaMere, double kolicina, double cena, double iznos, Faktura faktura) {
		super();
		this.id = id;
		this.nazivRobe = nazivRobe;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.cena = cena;
		this.iznos = iznos;
		this.faktura = faktura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivRobe() {
		return nazivRobe;
	}

	public void setNazivRobe(String nazivRobe) {
		this.nazivRobe = nazivRobe;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	
	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	@Override
	public String toString() {
		return "Narudzbenica [id=" + id + ", nazivRobe=" + nazivRobe + ", jedinicaMere=" + jedinicaMere + ", kolicina="
				+ kolicina + ", cena=" + cena + ", iznos=" + iznos + ", faktura=" + faktura + "]";
	}

	
}