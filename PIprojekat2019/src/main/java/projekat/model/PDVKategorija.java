package projekat.model;

public class PDVKategorija {
	
	private int idKategorije;
	private String nazivKategorije;
	
	public PDVKategorija(int idKategorije, String nazivKategorije) {
		this.idKategorije = idKategorije;
		this.nazivKategorije = nazivKategorije;
	}

	public int getIdKategorije() {
		return idKategorije;
	}

	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}
	
	
	

}
