package projekat.dto;

public class RobaUslugaDTO {
	
	private Long idRobeUsluge;
	private String nazivRobeUsluge;
	private String opis;
	private boolean roba;
	private Long idJedinicaMere;
	private Long idGrupeRobeUsluga;
	
	public RobaUslugaDTO() {
		super();
	}
	
	

	public RobaUslugaDTO(Long idRobeUsluge, String nazivRobeUsluge, String opis, boolean roba, Long idJedinicaMere,
			Long idGrupeRobeUsluga) {
		super();
		this.idRobeUsluge = idRobeUsluge;
		this.nazivRobeUsluge = nazivRobeUsluge;
		this.opis = opis;
		this.roba = roba;
		this.idJedinicaMere = idJedinicaMere;
		this.idGrupeRobeUsluga = idGrupeRobeUsluga;
	}


//	
//	public RobaUslugaDTO(RobaUsluga robaUsluga) {
//		this.idRobeUsluge = robaUsluga.getIdRobeUsluge();
//		this.nazivRobeUsluge = robaUsluga.getNazivRobeUsluge();
//		this.roba = true;
//		this.opis = robaUsluga.getOpis();
//		this.jedinicaMere = robaUsluga.getJedinicaMere();
//		this.grupaRobeUsluga = robaUsluga.getGrupaRobeUsluga();
//	}
//	
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
	
	public boolean isRoba() {
		return roba;
	}
	
	public void setRoba(boolean roba) {
		this.roba = roba;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}



	public Long getIdJedinicaMere() {
		return idJedinicaMere;
	}



	public void setIdJedinicaMere(Long idJedinicaMere) {
		this.idJedinicaMere = idJedinicaMere;
	}



	public Long getIdGrupeRobeUsluga() {
		return idGrupeRobeUsluga;
	}



	public void setIdGrupeRobeUsluga(Long idGrupeRobeUsluga) {
		this.idGrupeRobeUsluga = idGrupeRobeUsluga;
	}

}