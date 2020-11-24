package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.StavkaOtpremnice;
import projekat.repository.StavkaOtpremniceRepository;
import projekat.service.intrfc.StavkaOtpremniceServiceInterface;

@Service
public class StavkaOtpremniceService implements StavkaOtpremniceServiceInterface {
	
	@Autowired
	private StavkaOtpremniceRepository stavkaOtpremniceRepository;

	@Override
	public StavkaOtpremnice findByRedniBrojProizvoda(int redniBrojProizvoda) {
		return stavkaOtpremniceRepository.findByRedniBrojProizvoda(redniBrojProizvoda);
	}

	@Override
	public StavkaOtpremnice save(StavkaOtpremnice stavkaOtpremnice) {
		return stavkaOtpremniceRepository.save(stavkaOtpremnice);
	}

	@Override
	public StavkaOtpremnice findOne(Long id) {
		return stavkaOtpremniceRepository.findOne(id);
	}

	@Override
	public List<StavkaOtpremnice> findAll() {
		return stavkaOtpremniceRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		stavkaOtpremniceRepository.delete(id);

	}

}