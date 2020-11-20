package projekat.service.intrfc;

import java.util.List;

import projekat.model.Faktura;

public interface FakturaServiceInterface {
	
	Faktura findByBrojFakture (int brojFakture);
	
	Faktura save(Faktura faktura);

	Faktura findOne(Long id);

	List<Faktura> findAll();
	
	void remove(Long id);


}
