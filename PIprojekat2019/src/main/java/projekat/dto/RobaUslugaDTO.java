package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.GrupaRobeUsluga;
import projekat.model.JedinicaMere;
import projekat.model.RobaUsluga;
import projekat.model.StavkaFakture;
import projekat.model.StavkaOtpremnice;

@SuppressWarnings("serial")
public class RobaUslugaDTO implements Serializable {
	
	private Long idRobeUsluge;
	private String nazivRobeUsluge;
	private String opis;
	private boolean roba;
	private JedinicaMere jedinicaMere;
	private GrupaRobeUsluga grupaRobeUsluga;
	private List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();
	private List<StavkaOtpremnice> stavkeOtpremnice = new ArrayList<StavkaOtpremnice>();
	
	public RobaUslugaDTO() {
		super();
	}
	
	public RobaUslugaDTO(Long idRobeUsluge, String nazivRobeUsluge, boolean roba, String opis, JedinicaMere jedinicaMere,
			GrupaRobeUsluga grupaRobeUsluga, List<StavkaFakture> stavkeFakture, List<StavkaOtpremnice> stavkeOtpremnice) {
		super();
		this.idRobeUsluge = idRobeUsluge;
		this.nazivRobeUsluge = nazivRobeUsluge;
		this.opis = opis;
		this.roba = roba;
		this.jedinicaMere = jedinicaMere;
		this.grupaRobeUsluga = grupaRobeUsluga;
		this.stavkeFakture = stavkeFakture;
		this.stavkeOtpremnice = stavkeOtpremnice;
	}
	
	public RobaUslugaDTO(RobaUsluga robaUsluga) {
		this.idRobeUsluge = robaUsluga.getIdRobeUsluge();
		this.nazivRobeUsluge = robaUsluga.getNazivRobeUsluge();
		this.roba = true;
		this.opis = robaUsluga.getOpis();
		this.jedinicaMere = robaUsluga.getJedinicaMere();
		this.grupaRobeUsluga = robaUsluga.getGrupaRobeUsluga();
	//	this.stavkeFakture = robaUsluga.getStavkeFakture();
		//this.stavkeOtpremnice = robaUsluga.getStavkeOtpremnice();
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

	public List<StavkaOtpremnice> getStavkeOtpremnice() {
		return stavkeOtpremnice;
	}

	public void setStavkeOtpremnice(List<StavkaOtpremnice> stavkeOtpremnice) {
		this.stavkeOtpremnice = stavkeOtpremnice;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	

}
