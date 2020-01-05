package projekat.model;

public class GrupaRobeUsluga {
	
	private int idGrupe;
	private String nazivGrupe;
	
	public GrupaRobeUsluga(int idGrupe, String nazivGrupe) {
		this.idGrupe = idGrupe;
		this.nazivGrupe = nazivGrupe;
	}

	public int getIdGrupe() {
		return idGrupe;
	}

	public void setIdGrupe(int idGrupe) {
		this.idGrupe = idGrupe;
	}

	public String getNazivGrupe() {
		return nazivGrupe;
	}

	public void setNazivGrupe(String nazivGrupe) {
		this.nazivGrupe = nazivGrupe;
	}
	
	
	

}
