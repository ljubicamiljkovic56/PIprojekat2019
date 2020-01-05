package projekat.model;

public class StavkaFakture {
	
	private int idStavke;
	private double kolicina;
	private double rabat;
	private double jedinicnaCena;
	private double pdvStopa;
	private double osnovicaZaPDV;
	private double iznosPDV;
	private double ukupanIznos;
	
	public StavkaFakture(int idStavke, double kolicina, double rabat, double jedinicnaCena, double pdvStopa,
			double osnovicaZaPDV, double iznosPDV, double ukupanIznos) {
		this.idStavke = idStavke;
		this.kolicina = kolicina;
		this.rabat = rabat;
		this.jedinicnaCena = jedinicnaCena;
		this.pdvStopa = pdvStopa;
		this.osnovicaZaPDV = osnovicaZaPDV;
		this.iznosPDV = iznosPDV;
		this.ukupanIznos = ukupanIznos;
	}

	public int getIdStavke() {
		return idStavke;
	}

	public void setIdStavke(int idStavke) {
		this.idStavke = idStavke;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public double getRabat() {
		return rabat;
	}

	public void setRabat(double rabat) {
		this.rabat = rabat;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public double getPdvStopa() {
		return pdvStopa;
	}

	public void setPdvStopa(double pdvStopa) {
		this.pdvStopa = pdvStopa;
	}

	public double getOsnovicaZaPDV() {
		return osnovicaZaPDV;
	}

	public void setOsnovicaZaPDV(double osnovicaZaPDV) {
		this.osnovicaZaPDV = osnovicaZaPDV;
	}

	public double getIznosPDV() {
		return iznosPDV;
	}

	public void setIznosPDV(double iznosPDV) {
		this.iznosPDV = iznosPDV;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}
	
	

}
