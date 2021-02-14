package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.RobaUsluga;
import projekat.repository.RobaUslugaRepository;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@Transactional
@Service
public class RobaUslugaService implements RobaUslugaServiceInterface {

	
	@Autowired
	private RobaUslugaRepository robaUslugaRepository;
	
	@Override
	public RobaUsluga save(RobaUsluga robaUsluga) {
		return robaUslugaRepository.save(robaUsluga);
	}

	@Override
	public RobaUsluga findByNazivRobeUsluge(String nazivRobaUsluga) {
		return robaUslugaRepository.findByNazivRobeUsluge(nazivRobaUsluga);
	}

	@Override
	public RobaUsluga findOne(Long id) {
		return robaUslugaRepository.findOne(id);
	}

	@Override
	public List<RobaUsluga> findAll() {
		return robaUslugaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		robaUslugaRepository.delete(id);

	}

	@Override
	public Page<RobaUsluga> findAll(int pageNo, int pageSize) {
		return robaUslugaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

}
