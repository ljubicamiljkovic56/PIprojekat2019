package projekat.dto;

import java.io.Serializable;
import java.sql.Date;

import projekat.model.PDVKategorija;
import projekat.model.PDVStopa;

@SuppressWarnings("serial")
public class PDVStopaDTO implements Serializable {
	
	private Long idStope;
	private Date datumVazenja;
	private double procenat;
	private PDVKategorija pdvKategorija;
	
	public PDVStopaDTO() {
		super();
	}
	
	
	
	public PDVStopaDTO(Long idStope, Date datumVazenja, double procenat, PDVKategorija pdvKategorija) {
		super();
		this.idStope = idStope;
		this.datumVazenja = datumVazenja;
		this.procenat = procenat;
		this.pdvKategorija = pdvKategorija;
	}



	public PDVStopaDTO(PDVStopa pdvStopa) {
		this.idStope = pdvStopa.getIdStope();
		this.datumVazenja = pdvStopa.getDatumVazenja();
		this.procenat = pdvStopa.getProcenat();
		this.pdvKategorija = pdvStopa.getPdvKategorija();
		
	}
	
	public Long getIdStope() {
		return idStope;
	}
	public void setIdStope(Long idStope) {
		this.idStope = idStope;
	}
	public Date getDatumVazenja() {
		return datumVazenja;
	}
	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}
	public double getProcenat() {
		return procenat;
	}
	public void setProcenat(double procenat) {
		this.procenat = procenat;
	}
	public PDVKategorija getPdvKategorija() {
		return pdvKategorija;
	}
	public void setPdvKategorija(PDVKategorija pdvKategorija) {
		this.pdvKategorija = pdvKategorija;
	}
	
}