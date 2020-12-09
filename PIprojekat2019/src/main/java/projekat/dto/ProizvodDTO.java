package projekat.dto;

import projekat.model.Proizvod;

public class ProizvodDTO {

	private Long id;
	private String naziv;
	private double cena;
	private String opis;
	
	public ProizvodDTO() {
		super();
	}

	public ProizvodDTO(Long id, String naziv, double cena, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.opis = opis;
	}
	
	public ProizvodDTO(Proizvod proizvod) {
		this.id = proizvod.getId();
		this.naziv = proizvod.getNaziv();
		this.cena = proizvod.getCena();
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
}