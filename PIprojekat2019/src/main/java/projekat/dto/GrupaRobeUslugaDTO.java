package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.GrupaRobeUsluga;
import projekat.model.RobaUsluga;

@SuppressWarnings("serial")
public class GrupaRobeUslugaDTO implements Serializable {
	
	private Long idGrupe;
	private String nazivGrupe;
	private List<RobaUsluga> robaUsluga = new ArrayList<RobaUsluga>();
	
	public GrupaRobeUslugaDTO() {
		super();
	}
	
	
	public GrupaRobeUslugaDTO(Long idGrupe, String nazivGrupe, List<RobaUsluga> robaUsluga) {
		super();
		this.idGrupe = idGrupe;
		this.nazivGrupe = nazivGrupe;
		this.robaUsluga = robaUsluga;
	}
	
	public GrupaRobeUslugaDTO(GrupaRobeUsluga grupaRobe) {
		this.idGrupe = grupaRobe.getIdGrupe();
		this.nazivGrupe = grupaRobe.getNazivGrupe();
	//	this.robaUsluga = grupaRobe.getRobaUsluga();
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
	public List<RobaUsluga> getRobaUsluga() {
		return robaUsluga;
	}
	public void setRobaUsluga(List<RobaUsluga> robaUsluga) {
		this.robaUsluga = robaUsluga;
	}

}