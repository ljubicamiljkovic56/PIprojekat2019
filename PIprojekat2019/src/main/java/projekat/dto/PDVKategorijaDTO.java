package projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projekat.model.PDVKategorija;
import projekat.model.PDVStopa;

@SuppressWarnings("serial")
public class PDVKategorijaDTO implements Serializable {
	
	private Long idKategorije;
	private String nazivKategorije;
	private List<PDVStopa> pdvStope = new ArrayList<PDVStopa>();
	
	public PDVKategorijaDTO() {
		super();
	}

	public PDVKategorijaDTO(Long idKategorije, String nazivKategorije, List<PDVStopa> pdvStope) {
		super();
		this.idKategorije = idKategorije;
		this.nazivKategorije = nazivKategorije;
		this.pdvStope = pdvStope;
	}
	
	public PDVKategorijaDTO(PDVKategorija pdvKategorija) {
		this.idKategorije = pdvKategorija.getIdKategorije();
		this.nazivKategorije = pdvKategorija.getNazivKategorije();
		this.pdvStope = pdvKategorija.getPdvStope();
	}

	public Long getIdKategorije() {
		return idKategorije;
	}

	public void setIdKategorije(Long idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public List<PDVStopa> getPdvStope() {
		return pdvStope;
	}

	public void setPdvStope(List<PDVStopa> pdvStope) {
		this.pdvStope = pdvStope;
	}

}