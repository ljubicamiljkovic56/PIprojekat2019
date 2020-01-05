package projekat.model;

public class StavkaCenovnika {
	
	private int idStavke;
	private double cena;
	
	public StavkaCenovnika(int idStavke, double cena) {
		this.idStavke = idStavke;
		this.cena = cena;
	}

	public int getIdStavke() {
		return idStavke;
	}

	public void setIdStavke(int idStavke) {
		this.idStavke = idStavke;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	

}
