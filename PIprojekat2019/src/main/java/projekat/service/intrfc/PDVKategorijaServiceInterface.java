package projekat.service.intrfc;

import java.util.List;

import projekat.model.PDVKategorija;

public interface PDVKategorijaServiceInterface {
	
	PDVKategorija findByNazivKategorije(String nazivKategorije);

	PDVKategorija save(PDVKategorija pdvKategorija);

	PDVKategorija findOne(Long id);

	List<PDVKategorija> findAll();
	
	void remove(Long id);

}
