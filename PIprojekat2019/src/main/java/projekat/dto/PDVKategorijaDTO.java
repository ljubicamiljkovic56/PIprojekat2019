package projekat.dto;

public class PDVKategorijaDTO {
	
	private Long idKategorije;
	private String nazivKategorije;

	
	public PDVKategorijaDTO() {
		super();
	}

	public PDVKategorijaDTO(Long idKategorije, String nazivKategorije) {
		super();
		this.idKategorije = idKategorije;
		this.nazivKategorije = nazivKategorije;
	}
	
//	public PDVKategorijaDTO(PDVKategorija pdvKategorija) {
//		this.idKategorije = pdvKategorija.getIdKategorije();
//		this.nazivKategorije = pdvKategorija.getNazivKategorije();
//	}

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

}