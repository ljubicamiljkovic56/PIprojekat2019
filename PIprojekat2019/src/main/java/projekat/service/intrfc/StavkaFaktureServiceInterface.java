package projekat.service.intrfc;

import java.util.List;

import projekat.model.StavkaFakture;


public interface StavkaFaktureServiceInterface {
	
	StavkaFakture save(StavkaFakture stavkaFakture);

	StavkaFakture findOne(Long id);

	List<StavkaFakture> findAll();
	
	void remove(Long id);


}
