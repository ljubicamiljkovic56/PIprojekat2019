package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.StavkaFakture;
import projekat.repository.StavkaFaktureRepository;
import projekat.service.m.StavkaFaktureService;

@Transactional
@Service
public class JpaStavkaFaktureService implements StavkaFaktureService {

	@Autowired
	private StavkaFaktureRepository stavkaFaktureRepository;
	
	@Override
	public StavkaFakture findOne(int id) {
		return stavkaFaktureRepository.findOne(id);
	}

	@Override
	public List<StavkaFakture> findAll() {
		return stavkaFaktureRepository.findAll();
	}

	@Override
	public StavkaFakture save(StavkaFakture stavkaF) {
		return stavkaFaktureRepository.save(stavkaF);
	}

	@Override
	public List<StavkaFakture> save(List<StavkaFakture> stavkeF) {
		return stavkaFaktureRepository.save(stavkeF);
	}

	@Override
	public StavkaFakture delete(int id) {
		StavkaFakture stavkaFakture = stavkaFaktureRepository.findOne(id);
		if(stavkaFakture == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojece stavke fakture");
		}
		stavkaFaktureRepository.delete(stavkaFakture);
		return stavkaFakture;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}

	}

}
