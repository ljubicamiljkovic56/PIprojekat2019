package projekat.dto;

import projekat.model.JedinicaMere;

public class JedinicaMereDTO {
	
	private Long idJediniceMere;
	private String nazivJediniceMere;
	private String skraceniNaziv;
	
	
	public JedinicaMereDTO() {
		super();
	}


	public JedinicaMereDTO(Long idJediniceMere, String nazivJediniceMere, String skraceniNaziv) {
		super();
		this.idJediniceMere = idJediniceMere;
		this.nazivJediniceMere = nazivJediniceMere;
		this.skraceniNaziv = skraceniNaziv;
	}
	
	
//	public JedinicaMereDTO(JedinicaMere jedinicaMere) {
//		this.idJediniceMere = jedinicaMere.getIdJediniceMere();
//		this.nazivJediniceMere = jedinicaMere.getNazivJediniceMere();
//		this.skraceniNaziv = jedinicaMere.getSkraceniNaziv();
////		//this.robaUsluga = (ArrayList<RobaUsluga>) jedinicaMere.getRobaUsluga();
//	}


	public Long getIdJediniceMere() {
		return idJediniceMere;
	}


	public void setIdJediniceMere(Long idJediniceMere) {
		this.idJediniceMere = idJediniceMere;
	}


	public String getNazivJediniceMere() {
		return nazivJediniceMere;
	}


	public void setNazivJediniceMere(String nazivJediniceMere) {
		this.nazivJediniceMere = nazivJediniceMere;
	}


	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}


	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

}