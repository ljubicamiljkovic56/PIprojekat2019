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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "roba_usluga")
public class RobaUsluga implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRobeUsluge;
	
	@Column(name = "naziv_robe_usluge", columnDefinition = "VARCHAR(30)")
	private String nazivRobeUsluge;
	
	@Column(name = "opis", columnDefinition = "VARCHAR(30)")
	private String opis;
	
	@Column(name = "roba", columnDefinition = "TINYINT(1)")
	private boolean roba;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_jedinice_mere")
	//@Column(name = "jedinica_mere")
	private JedinicaMere jedinicaMere;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupe")
	private GrupaRobeUsluga grupaRobeUsluga;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<StavkaFakture> stavkeFakture = new ArrayList<StavkaFakture>();

	public RobaUsluga() {
		super();
	}
	
	public RobaUsluga(Long idRobeUsluge, String nazivRobeUsluge, String opis, boolean roba, JedinicaMere jedinicaMere,
			GrupaRobeUsluga grupaRobeUsluga, List<StavkaFakture> stavkeFakture) {
		super();
		this.idRobeUsluge = idRobeUsluge;
		this.nazivRobeUsluge = nazivRobeUsluge;
		this.opis = opis;
		this.roba = roba;
		this.jedinicaMere = jedinicaMere;
		this.grupaRobeUsluga = grupaRobeUsluga;
		this.stavkeFakture = stavkeFakture;
	}

	public Long getIdRobeUsluge() {
		return idRobeUsluge;
	}

	public void setIdRobeUsluge(Long idRobeUsluge) {
		this.idRobeUsluge = idRobeUsluge;
	}

	public String getNazivRobeUsluge() {
		return nazivRobeUsluge;
	}

	public void setNazivRobeUsluge(String nazivRobeUsluge) {
		this.nazivRobeUsluge = nazivRobeUsluge;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public boolean isRoba() {
		return roba;
	}

	public void setRoba(boolean roba) {
		this.roba = roba;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public GrupaRobeUsluga getGrupaRobeUsluga() {
		return grupaRobeUsluga;
	}

	public void setGrupaRobeUsluga(GrupaRobeUsluga grupaRobeUsluga) {
		this.grupaRobeUsluga = grupaRobeUsluga;
	}

	public List<StavkaFakture> getStavkeFakture() {
		return stavkeFakture;
	}

	public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
		this.stavkeFakture = stavkeFakture;
	}

	@Override
	public String toString() {
		return "RobaUsluga [idRobeUsluge=" + idRobeUsluge + ", nazivRobeUsluge=" + nazivRobeUsluge + ", opis=" + opis
				+ ", roba=" + roba + ", jedinicaMere=" + jedinicaMere + ", grupaRobeUsluga=" + grupaRobeUsluga
				+ ", stavkeFakture=" + stavkeFakture + "]";
	}
}