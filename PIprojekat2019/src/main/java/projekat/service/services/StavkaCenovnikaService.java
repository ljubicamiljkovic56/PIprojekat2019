package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import projekat.model.StavkaCenovnika;
import projekat.repository.StavkaCenovnikaRepository;
import projekat.service.intrfc.StavkaCenovnikaServiceInterface;

@Service
public class StavkaCenovnikaService implements StavkaCenovnikaServiceInterface {
	
	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;

	@Override
	public StavkaCenovnika findByCena(double cena) {
		return stavkaCenovnikaRepository.findByCena(cena);
	}

	@Override
	public List<StavkaCenovnika> findAll() {
		return stavkaCenovnikaRepository.findAll();
	}

	@Override
	public StavkaCenovnika save(StavkaCenovnika stavkaCenovnika) {
		return stavkaCenovnikaRepository.save(stavkaCenovnika);
	}

	@Override
	public StavkaCenovnika findOne(Long id) {
		return stavkaCenovnikaRepository.findOne(id);
	}

	@Override
	public void remove(Long id) {
		stavkaCenovnikaRepository.delete(id);
	}

}
