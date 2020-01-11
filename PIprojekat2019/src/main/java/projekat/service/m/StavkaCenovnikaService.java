package projekat.service.m;

import java.util.List;

import projekat.model.StavkaCenovnika;


public interface StavkaCenovnikaService {

	StavkaCenovnika findOne(int id);
	
	List<StavkaCenovnika> findAll();
	
	StavkaCenovnika save(StavkaCenovnika stavkaC);
	
	List<StavkaCenovnika> save(List<StavkaCenovnika> stavkeC);

	StavkaCenovnika delete(int id);
	
	void delete(List<Integer> ids);
}
