package projekat.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "pdv_stopa")
public class PDVStopa implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStope;

	//@Column(name = "naziv_kategorije", columnDefinition = "VARCHAR(20)")
	//private String nazivKategorije;
	
	@Column(name = "datum_vazenja", columnDefinition = "DATE")
	private Date datumVazenja;
	
	@Column(name = "procenat", columnDefinition = "DOUBLE")
	private double procenat;

	@ManyToOne
	private PDVKategorija pdvKategorija;
	
	public PDVStopa() {
		super();
	}

	public PDVStopa(Long idStope, Date datumVazenja, double procenat,
			PDVKategorija pdvKategorija) {
		super();
		this.idStope = idStope;
	//	this.nazivKategorije = nazivKategorije;
		this.datumVazenja = datumVazenja;
		this.procenat = procenat;
		this.pdvKategorija = pdvKategorija;
	}

	public Long getIdStope() {
		return idStope;
	}

	public void setIdStope(Long idStope) {
		this.idStope = idStope;
	}

//	public String getNazivKategorije() {
//		return nazivKategorije;
//	}
//
//	public void setNazivKategorije(String nazivKategorije) {
//		this.nazivKategorije = nazivKategorije;
//	}

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

	@Override
	public String toString() {
		return "PDVStopa [idStope=" + idStope + ", datumVazenja="
				+ datumVazenja + ", procenat=" + procenat + ", pdvKategorija=" + pdvKategorija + "]";
	}	
}