package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Faktura;
import projekat.model.PoslovnaGodina;
import projekat.model.Preduzece;

@SuppressWarnings("serial")
public class PoslovnaGodinaDTO implements Serializable {
	
	private Long idGodine;
	private int godina;
	private boolean zakljucena;
	private Preduzece preduzece;
	private List<Faktura> fakture = new ArrayList<Faktura>();
	
	public PoslovnaGodinaDTO() {
		super();
	}

	public PoslovnaGodinaDTO(Long idGodine, int godina, boolean zakljucena, Preduzece preduzece,
			List<Faktura> fakture) {
		super();
		this.idGodine = idGodine;
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.preduzece = preduzece;
		this.fakture = fakture;
	}
	
	public PoslovnaGodinaDTO(PoslovnaGodina poslovnaGodina) {
		this.idGodine = poslovnaGodina.getIdGodine();
		this.godina = poslovnaGodina.getGodina();
		this.zakljucena = false;
	//	this.preduzece = poslovnaGodina.getPreduzece();
	//	this.fakture = poslovnaGodina.getFakture();
	}

	public Long getIdGodine() {
		return idGodine;
	}

	public void setIdGodine(Long idGodine) {
		this.idGodine = idGodine;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public boolean isZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(boolean zakljucena) {
		this.zakljucena = zakljucena;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}
	
}