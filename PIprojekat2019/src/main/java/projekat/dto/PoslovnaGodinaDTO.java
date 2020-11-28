package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.Faktura;
import projekat.model.PoslovnaGodina;

@SuppressWarnings("serial")
public class PoslovnaGodinaDTO implements Serializable {
	
	private Long idGodine;
	private int godina;
	private boolean zakljucena;
	private List<Faktura> fakture = new ArrayList<Faktura>();
	
	public PoslovnaGodinaDTO() {
		super();
	}

	public PoslovnaGodinaDTO(Long idGodine, int godina, boolean zakljucena,
			List<Faktura> fakture) {
		super();
		this.idGodine = idGodine;
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.fakture = fakture;
	}
	
	public PoslovnaGodinaDTO(PoslovnaGodina poslovnaGodina) {
		this.idGodine = poslovnaGodina.getIdGodine();
		this.godina = poslovnaGodina.getGodina();
		this.zakljucena = poslovnaGodina.isZakljucena();
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

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}
	
}