package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.StavkaCenovnika;
import projekat.repository.StavkaCenovnikaRepository;
import projekat.service.intrfc.StavkaCenovnikaServiceInterface;

@Transactional
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

	@Override
	public Page<StavkaCenovnika> findAll(int pageNo, int pageSize) {
		return stavkaCenovnikaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<StavkaCenovnika> findAllByCena(double cena, int pageNo, int pageSize) {
		return stavkaCenovnikaRepository.findAllByCena(cena, new PageRequest(pageNo, pageSize));
	}

}
