package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "RobaUsluga")
public class RobaUsluga {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRobeUsluge;
	
	@Column(name = "nazivRobeUsluge", columnDefinition = "VARCHAR(10)")
	private String nazivRobeUsluge;
	
	@Column(name = "opis", columnDefinition = "VARCHAR(20)")
	private String opis;
	
	@Column(name = "roba", columnDefinition = "TINYINT(1)")
	private boolean roba;
	
	public RobaUsluga(String nazivRobeUsluge, String opis, boolean roba) {
		//this.idRobeUsluge = idRobeUsluge;
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
