package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.RobaUsluga;
import projekat.repository.RobaUslugaRepository;
import projekat.service.intrfc.RobaUslugaServiceInterface;

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

}
