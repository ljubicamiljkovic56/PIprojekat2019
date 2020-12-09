package projekat.dto;

public class GrupaRobeUslugaDTO {
	
	private Long idGrupe;
	private String nazivGrupe;
	private Long idPDVKategorija;
	
	public GrupaRobeUslugaDTO() {
		super();
	}
	

	public GrupaRobeUslugaDTO(Long idGrupe, String nazivGrupe, Long idPDVKategorija) {
		super();
		this.idGrupe = idGrupe;
		this.nazivGrupe = nazivGrupe;
		this.idPDVKategorija = idPDVKategorija;
	}


	public Long getIdGrupe() {
		return idGrupe;
	}


	public void setIdGrupe(Long idGrupe) {
		this.idGrupe = idGrupe;
	}


	public String getNazivGrupe() {
		return nazivGrupe;
	}


	public void setNazivGrupe(String nazivGrupe) {
		this.nazivGrupe = nazivGrupe;
	}


	public Long getIdPDVKategorija() {
		return idPDVKategorija;
	}


	public void setIdPDVKategorija(Long idPDVKategorija) {
		this.idPDVKategorija = idPDVKategorija;
	}



//	public GrupaRobeUslugaDTO(GrupaRobeUsluga grupaRobe) {
//		this.idGrupe = grupaRobe.getIdGrupe();
//		this.nazivGrupe = grupaRobe.getNazivGrupe();
//	}


}