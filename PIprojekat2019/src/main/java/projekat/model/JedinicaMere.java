package projekat.model;

public class JedinicaMere {
	
	private int idJediniceMere;
	private String nazivJediniceMere;
	private String skraceniNaziv;
	
	public JedinicaMere(int idJediniceMere, String nazivJediniceMere, String skraceniNaziv) {
		this.idJediniceMere = idJediniceMere;
		this.nazivJediniceMere = nazivJediniceMere;
		this.skraceniNaziv = skraceniNaziv;
	}

	public int getIdJediniceMere() {
		return idJediniceMere;
	}

	public void setIdJediniceMere(int idJediniceMere) {
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
