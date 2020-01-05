package projekat.model;

import java.sql.Date;

public class PDVStopa {
	
	private int idStope;
	private double procenat;
	private Date datumVazenja;
	
	public PDVStopa(int idStope, double procenat, Date datumVazenja) {
		this.idStope = idStope;
		this.procenat = procenat;
		this.datumVazenja = datumVazenja;
	}

	public int getIdStope() {
		return idStope;
	}

	public void setIdStope(int idStope) {
		this.idStope = idStope;
	}

	public double getProcenat() {
		return procenat;
	}

	public void setProcenat(double procenat) {
		this.procenat = procenat;
	}

	public Date getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}
	
	
	

}
