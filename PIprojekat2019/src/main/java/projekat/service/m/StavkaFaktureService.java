package projekat.service.m;

import java.util.List;

import projekat.model.StavkaFakture;

public interface StavkaFaktureService {

	StavkaFakture findOne(int id);
	
	List<StavkaFakture> findAll();
	
	StavkaFakture save(StavkaFakture stavkaF);
	
	List<StavkaFakture> save(List<StavkaFakture> stavkeF);

	StavkaFakture delete(int id);
	
	void delete(List<Integer> ids);
}
