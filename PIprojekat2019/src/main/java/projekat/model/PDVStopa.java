package projekat.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PDVStopa")
public class PDVStopa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStope;
	
	@Column(name = "procenat", columnDefinition = "DECIMAL")
	private double procenat;
	
	@Column(name = "datumVazenja", columnDefinition = "DATE")
	private Date datumVazenja;
	
	public PDVStopa(double procenat, Date datumVazenja) {
		//this.idStope = idStope;
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
