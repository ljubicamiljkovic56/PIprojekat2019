package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "GrupaRobeUsluga")
public class GrupaRobeUsluga {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupe;
	
	@Column(name = "nazivGrupe", columnDefinition = "VARCHAR(10)")
	private String nazivGrupe;
	
	public GrupaRobeUsluga(String nazivGrupe) {
		//this.idGrupe = idGrupe;
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
