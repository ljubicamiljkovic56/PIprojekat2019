package projekat.dto;

import projekat.model.KupljeniProizvod;

public class KupljeniProizvodDTO {

	private Long id;
	private String naziv;
	private double cena;
	private double kolicina;
	private String kupac;
	
	public KupljeniProizvodDTO() {
		super();
	}

	public KupljeniProizvodDTO(Long id, String naziv, double cena, double kolicina, String kupac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.kolicina = kolicina;
		this.kupac = kupac;
	}
	
	public KupljeniProizvodDTO(KupljeniProizvod kupljeniProizvod) {
		this.id = kupljeniProizvod.getId();
		this.naziv = kupljeniProizvod.getNaziv();
		this.cena = kupljeniProizvod.getCena();
		this.kolicina = kupljeniProizvod.getKolicina();
		this.kupac = kupljeniProizvod.getKupac();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		this.kupac = kupac;
	}
	
	
}
