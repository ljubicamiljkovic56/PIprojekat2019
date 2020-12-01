package projekat.dto;

import java.io.Serializable;

import projekat.model.Faktura;
import projekat.model.Narudzbenica;

@SuppressWarnings("serial")
public class NarudzbenicaDTO implements Serializable {

	private Long id;
	private String nazivRobe;
	private String jedinicaMere;
	private double kolicina;
	private double cena;
	private double iznos;
	private Faktura faktura;
	
	public NarudzbenicaDTO() {
		super();
	}
	
	public NarudzbenicaDTO(Long id, String nazivRobe, String jedinicaMere, double kolicina, double cena, double iznos,
			Faktura faktura) {
		super();
		this.id = id;
		this.nazivRobe = nazivRobe;
		this.jedinicaMere = jedinicaMere;
		this.kolicina = kolicina;
		this.cena = cena;
		this.iznos = iznos;
		this.faktura = faktura;
	}
	
	public NarudzbenicaDTO(Narudzbenica narudzbenica) {
		this.id = narudzbenica.getId();
		this.nazivRobe = narudzbenica.getNazivRobe();
		this.jedinicaMere = narudzbenica.getJedinicaMere();
		this.kolicina = narudzbenica.getKolicina();
		this.cena = narudzbenica.getCena();
		this.iznos = narudzbenica.getIznos();
		this.faktura = getFaktura();
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
	
	
}
