package projekat.model;

public class RobaUsluga {
	
	private int idRobeUsluge;
	private String nazivRobeUsluge;
	private String opis;
	private boolean roba;
	
	public RobaUsluga(int idRobeUsluge, String nazivRobeUsluge, String opis, boolean roba) {
		this.idRobeUsluge = idRobeUsluge;
		this.nazivRobeUsluge = nazivRobeUsluge;
		this.opis = opis;
		this.roba = roba;
	}

	public int getIdRobeUsluge() {
		return idRobeUsluge;
	}

	public void setIdRobeUsluge(int idRobeUsluge) {
		this.idRobeUsluge = idRobeUsluge;
	}

	public String getNazivRobeUsluge() {
		return nazivRobeUsluge;
	}

	public void setNazivRobeUsluge(String nazivRobeUsluge) {
		this.nazivRobeUsluge = nazivRobeUsluge;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public boolean isRoba() {
		return roba;
	}

	public void setRoba(boolean roba) {
		this.roba = roba;
	}
	
	
	
	
	

}
