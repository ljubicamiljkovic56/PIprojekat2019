package projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PoslovnaGodina")
public class PoslovnaGodina {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGodine;
	
	@Column(name = "godina", columnDefinition = "INT")
	private int godina;
	
	@Column(name = "zakljucena", columnDefinition = "TINYINT(1)")
	private boolean zakljucena;
	
	public PoslovnaGodina(int godina, boolean zakljucena) {
		//this.idGodine = idGodine;
		this.godina = godina;
		this.zakljucena = zakljucena;
	}

	public int getIdGodine() {
		return idGodine;
	}

	public void setIdGodine(int idGodine) {
		this.idGodine = idGodine;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public boolean isZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(boolean zakljucena) {
		this.zakljucena = zakljucena;
	}
	
	
	
}
