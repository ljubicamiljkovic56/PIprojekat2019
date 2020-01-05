package projekat.model;

public class PoslovnaGodina {

	private int idGodine;
	private int godina;
	private boolean zakljucena;
	
	public PoslovnaGodina(int idGodine, int godina, boolean zakljucena) {
		this.idGodine = idGodine;
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
