package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "grupa_robe_usluga")
public class GrupaRobeUsluga implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGrupe;
	
	@Column(name = "naziv_grupe", columnDefinition = "VARCHAR(20)")
	private String nazivGrupe;
	
	@OneToMany(fetch = FetchType.EAGER)
	private RobaUsluga robaUsluga;

	public GrupaRobeUsluga(Long idGrupe, String nazivGrupe, RobaUsluga robaUsluga) {
		super();
		this.idGrupe = idGrupe;
		this.nazivGrupe = nazivGrupe;
		this.robaUsluga = robaUsluga;
	}

	public Long getIdGrupe() {
		return idGrupe;
	}

	public void setIdGrupe(Long idGrupe) {
		this.idGrupe = idGrupe;
	}

	public String getNazivGrupe() {
		return nazivGrupe;
	}

	public void setNazivGrupe(String nazivGrupe) {
		this.nazivGrupe = nazivGrupe;
	}

	public RobaUsluga getRobaUsluga() {
		return robaUsluga;
	}

	public void setRobaUsluga(RobaUsluga robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

	@Override
	public String toString() {
		return "GrupaRobeUsluga [idGrupe=" + idGrupe + ", nazivGrupe=" + nazivGrupe + ", robaUsluga=" + robaUsluga
				+ "]";
	}	
}