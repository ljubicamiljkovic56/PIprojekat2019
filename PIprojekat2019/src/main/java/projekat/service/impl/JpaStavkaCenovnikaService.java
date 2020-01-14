package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.StavkaCenovnika;
import projekat.repository.StavkaCenovnikaRepository;
import projekat.service.m.StavkaCenovnikaService;

@Transactional
@Service
public class JpaStavkaCenovnikaService implements StavkaCenovnikaService {

	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	
	@Override
	public StavkaCenovnika findOne(int id) {
		return stavkaCenovnikaRepository.findOne(id);
	}

	@Override
	public List<StavkaCenovnika> findAll() {
		return stavkaCenovnikaRepository.findAll();
	}

	@Override
	public StavkaCenovnika save(StavkaCenovnika stavkaC) {
		return stavkaCenovnikaRepository.save(stavkaC);
	}

	@Override
	public List<StavkaCenovnika> save(List<StavkaCenovnika> stavkeC) {
		return stavkaCenovnikaRepository.save(stavkeC);
	}

	@Override
	public StavkaCenovnika delete(int id) {
		StavkaCenovnika stavkaCenovnika = stavkaCenovnikaRepository.findOne(id);
		if(stavkaCenovnika == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojece stavke cenovnika");
		}
		stavkaCenovnikaRepository.delete(stavkaCenovnika);
		return stavkaCenovnika;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}

	}

}
