package projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "pdv?kategorija")
public class PDVKategorija implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idKategorije;
	
	@Column(name = "naziv_kategorije", columnDefinition = "VARCHAR(20)")
	private String nazivKategorije;
	
	@OneToMany(mappedBy = "pdvkategorija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PDVStopa> pdvStope = new ArrayList<PDVStopa>();

	public PDVKategorija(Long idKategorije, String nazivKategorije, List<PDVStopa> pdvStope) {
		super();
		this.idKategorije = idKategorije;
		this.nazivKategorije = nazivKategorije;
		this.pdvStope = pdvStope;
	}

	public Long getIdKategorije() {
		return idKategorije;
	}

	public void setIdKategorije(Long idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNazivKategorije() {
		return nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public List<PDVStopa> getPdvStope() {
		return pdvStope;
	}

	public void setPdvStope(List<PDVStopa> pdvStope) {
		this.pdvStope = pdvStope;
	}

	@Override
	public String toString() {
		return "PDVKategorija [idKategorije=" + idKategorije + ", nazivKategorije=" + nazivKategorije + ", pdvStope="
				+ pdvStope + "]";
	}	
}