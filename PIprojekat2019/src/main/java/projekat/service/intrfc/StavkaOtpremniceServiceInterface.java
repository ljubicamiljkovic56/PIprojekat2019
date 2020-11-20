package projekat.service.intrfc;

import java.util.List;

import projekat.model.StavkaOtpremnice;

public interface StavkaOtpremniceServiceInterface {

	StavkaOtpremnice findByRedniBrojProizvoda (int redniBrojProizvoda);
	
	StavkaOtpremnice save(StavkaOtpremnice stavkaOtpremnice);

	StavkaOtpremnice findOne(Long id);

	List<StavkaOtpremnice> findAll();
	
	void remove(Long id);
}
