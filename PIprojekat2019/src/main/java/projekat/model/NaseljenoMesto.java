package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "naseljeno_mesto")
public class NaseljenoMesto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMesta;
	
	@Column(name = "ptt_broj", columnDefinition = "INT")
	private int pttBroj;
	
	@Column(name = "naziv_mesta", columnDefinition = "VARCHAR(15)")
	private String nazivMesta;
	
	@OneToOne
	private Preduzece preduzece;
	
	@OneToOne
	private PoslovniPartner poslovniPartner;

	public NaseljenoMesto() {
		super();
	}
	
	public NaseljenoMesto(int idMesta, int pttBroj, String nazivMesta, Preduzece preduzece,
			PoslovniPartner poslovniPartner) {
		super();
		this.idMesta = idMesta;
		this.pttBroj = pttBroj;
		this.nazivMesta = nazivMesta;
		this.preduzece = preduzece;
		this.poslovniPartner = poslovniPartner;
	}

	public int getIdMesta() {
		return idMesta;
	}

	public void setIdMesta(int idMesta) {
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

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	@Override
	public String toString() {
		return "NaseljenoMesto [idMesta=" + idMesta + ", pttBroj=" + pttBroj + ", nazivMesta=" + nazivMesta
				+ ", preduzece=" + preduzece + ", poslovniPartner=" + poslovniPartner + "]";
	}
	
	
}
