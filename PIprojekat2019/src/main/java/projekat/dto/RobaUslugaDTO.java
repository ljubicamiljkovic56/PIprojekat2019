package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.GrupaRobeUsluga;
import projekat.model.JedinicaMere;
import projekat.model.StavkaFakture;

@SuppressWarnings("serial")
public class RobaUslugaDTO implements Serializable {
	
	private Long idRobeUsluge;
	private String nazivRobeUsluge;
	private boolean roba;
	private JedinicaMere jedinicaMere;
	private GrupaRobeUsluga grupaRobeUsluga;
	private List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
	
	public RobaUslugaDTO() {
		super();
	}
	
	public RobaUslugaDTO(Long idRobeUsluge, String nazivRobeUsluge, boolean roba, JedinicaMere jedinicaMere,
			GrupaRobeUsluga grupaRobeUsluga, List<StavkaFakture> stavkeFakture) {
		super();
		this.idRobeUsluge = idRobeUsluge;
		this.nazivRobeUsluge = nazivRobeUsluge;
		this.roba = roba;
		this.jedinicaMere = jedinicaMere;
		this.grupaRobeUsluga = grupaRobeUsluga;
		this.stavkeFakture = stavkeFakture;
	}
	public Long getIdRobeUsluge() {
		return idRobeUsluge;
	}
	public void setIdRobeUsluge(Long idRobeUsluge) {
		this.idRobeUsluge = idRobeUsluge;
	}
	public String getNazivRobeUsluge() {
		return nazivRobeUsluge;
	}
	public void setNazivRobeUsluge(String nazivRobeUsluge) {
		this.nazivRobeUsluge = nazivRobeUsluge;
	}
	public boolean isRoba() {
		return roba;
	}
	public void setRoba(boolean roba) {
		this.roba = roba;
	}
	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}
	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}
	public GrupaRobeUsluga getGrupaRobeUsluga() {
		return grupaRobeUsluga;
	}
	public void setGrupaRobeUsluga(GrupaRobeUsluga grupaRobeUsluga) {
		this.grupaRobeUsluga = grupaRobeUsluga;
	}
	public List<StavkaFakture> getStavkeFakture() {
		return stavkeFakture;
	}
	public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}
	

}
