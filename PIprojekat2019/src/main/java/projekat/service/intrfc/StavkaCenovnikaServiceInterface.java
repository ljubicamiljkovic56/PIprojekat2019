package projekat.service.intrfc;

import java.util.List;


import projekat.model.StavkaCenovnika;

public interface StavkaCenovnikaServiceInterface {
	
	StavkaCenovnika findByCena (double cena);
	
	List<StavkaCenovnika> findAll();
	
	StavkaCenovnika save(StavkaCenovnika stavkaCenovnika);

	StavkaCenovnika findOne(Long id);
	
	void remove(Long id);

}
