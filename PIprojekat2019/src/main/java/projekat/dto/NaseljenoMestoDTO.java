package projekat.dto;

import java.io.Serializable;

import projekat.model.NaseljenoMesto;

@SuppressWarnings("serial")
public class NaseljenoMestoDTO implements Serializable {

	private Long idMesta;
	private int pttBroj;
	private String nazivMesta;
	
	public NaseljenoMestoDTO() {
		super();
	}

	public NaseljenoMestoDTO(Long idMesta, int pttBroj, String nazivMesta) {
		super();
		this.idMesta = idMesta;
		this.pttBroj = pttBroj;
		this.nazivMesta = nazivMesta;
	}
	
	public NaseljenoMestoDTO(NaseljenoMesto naseljenoMesto) {
		this.idMesta = naseljenoMesto.getIdMesta();
		this.pttBroj = naseljenoMesto.getPttBroj();
		this.nazivMesta = naseljenoMesto.getNazivMesta();
	}

	public Long getIdMesta() {
		return idMesta;
	}

	public void setIdMesta(Long idMesta) {
		this.idMesta = idMesta;
	}

	public int getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNazivMesta() {
		return nazivMesta;
	}

	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}
}