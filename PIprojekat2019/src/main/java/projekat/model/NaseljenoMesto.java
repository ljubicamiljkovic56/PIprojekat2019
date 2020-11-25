package projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "naseljeno_mesto")
public class NaseljenoMesto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMesta;
	
	@Column(name = "ptt_broj", columnDefinition = "INT")
	private int pttBroj;
	
	@Column(name = "naziv_mesta", columnDefinition = "VARCHAR(20)")
	private String nazivMesta;

	public NaseljenoMesto() {
		super();
	}
	
	public NaseljenoMesto(Long idMesta, int pttBroj, String nazivMesta) {
		super();
		this.idMesta = idMesta;
		this.pttBroj = pttBroj;
		this.nazivMesta = nazivMesta;
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

	@Override
	public String toString() {
		return "NaseljenoMesto [idMesta=" + idMesta + ", pttBroj=" + pttBroj + ", nazivMesta=" + nazivMesta
				+  "]";
	}
}