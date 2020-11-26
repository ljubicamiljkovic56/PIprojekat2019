package projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "poslovna_godina")
public class PoslovnaGodina implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGodine;
	
	@Column(name = "godina", columnDefinition = "INT")
	private int godina;
	
	@Column(name = "zakljucena", columnDefinition = "TINYINT(1)")
	private boolean zakljucena;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Faktura> fakture = new ArrayList<Faktura>();
	
	public PoslovnaGodina() {
		super();
	}

	public PoslovnaGodina(Long idGodine, int godina, boolean zakljucena, Preduzece preduzece, List<Faktura> fakture) {
		super();
		this.idGodine = idGodine;
		this.godina = godina;
		this.zakljucena = zakljucena;
	}
	
	public Long getIdGodine() {
		return idGodine;
	}

	public void setIdGodine(Long idGodine) {
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

	@Override
	public String toString() {
		return "PoslovnaGodina [idGodine=" + idGodine + ", godina=" + godina + ", zakljucena=" + zakljucena
				+ "]";
	}
}