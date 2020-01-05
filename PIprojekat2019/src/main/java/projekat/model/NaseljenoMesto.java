package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "NaseljenoMesto")
public class NaseljenoMesto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMesta;
	
	@Column(name = "pttBroj", columnDefinition = "INT")
	private int pttBroj;
	
	@Column(name = "nazivMesta", columnDefinition = "VARCHAR(15)")
	private String nazivMesta;
	
	public NaseljenoMesto(int pttBroj, String nazivMesta) {
		//this.idMesta = idMesta;
		this.pttBroj = pttBroj;
		this.nazivMesta = nazivMesta;
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
	
	
	
	

}
