package projekat.service.intrfc;

import java.util.List;

import projekat.model.StavkaNarudzbenice;

public interface StavkaNarudzbeniceServiceInterface {

	List<StavkaNarudzbenice> findAll();
	
	StavkaNarudzbenice save (StavkaNarudzbenice stavkaNarudzbenice);
	
	StavkaNarudzbenice findOne(Long id);
	
	void remove(Long id);
}