package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.PDVKategorija;

public interface PDVKategorijaServiceInterface {
	
	PDVKategorija findByNazivKategorije(String nazivKategorije);

	PDVKategorija save(PDVKategorija pdvKategorija);

	PDVKategorija findOne(Long id);

	List<PDVKategorija> findAll();
	
	void remove(Long id);
	
	Page<PDVKategorija> findAll(int pageNo, int pageSize);
	
	Page<PDVKategorija> findAllByNazivKategorije(String nazivKategorije, int pageNo, int pageSize);

}
