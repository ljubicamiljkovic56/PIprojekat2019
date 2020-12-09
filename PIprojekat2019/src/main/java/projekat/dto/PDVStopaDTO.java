package projekat.dto;

import java.sql.Date;

public class PDVStopaDTO {
	
	private Long idStope;
	private Date datumVazenja;
	private double procenat;
	private Long idPDVKategorije;
	
	public PDVStopaDTO() {
		super();
	}
	

	public PDVStopaDTO(Long idStope, Date datumVazenja, double procenat, Long idPDVKategorije) {
		super();
		this.idStope = idStope;
		this.datumVazenja = datumVazenja;
		this.procenat = procenat;
		this.idPDVKategorije = idPDVKategorije;
	}

//	public PDVStopaDTO(PDVStopa pdvStopa) {
//		this.idStope = pdvStopa.getIdStope();
//		this.datumVazenja = pdvStopa.getDatumVazenja();
//		this.procenat = pdvStopa.getProcenat();
//
//		
//	}
	
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


	public Long getIdPDVKategorije() {
		return idPDVKategorije;
	}


	public void setIdPDVKategorije(Long idPDVKategorije) {
		this.idPDVKategorije = idPDVKategorije;
	}
	
	
}