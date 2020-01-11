package projekat.service.m;

import java.util.List;

import projekat.model.StavkaOtpremnice;

public interface StavkaOtpremniceService {
	
	StavkaOtpremnice findOne(int id);
	
	List<StavkaOtpremnice> findAll();
	
	StavkaOtpremnice save(StavkaOtpremnice stavkaO);
	
	List<StavkaOtpremnice> save(List<StavkaOtpremnice> stavkeO);

	StavkaOtpremnice delete(int id);
	
	void delete(List<Integer> ids);

}
