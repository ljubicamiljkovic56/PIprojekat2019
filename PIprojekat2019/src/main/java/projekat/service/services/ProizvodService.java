package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.Proizvod;
import projekat.repository.ProizvodRepository;
import projekat.service.intrfc.ProizvodServiceInterface;

@Service
public class ProizvodService implements ProizvodServiceInterface {
	
	@Autowired
	ProizvodRepository proizvodRepository;

	@Override
	public Proizvod save(Proizvod proizvod) {
		return proizvodRepository.save(proizvod);
	}

	@Override
	public Proizvod findByNaziv(String naziv) {
		return proizvodRepository.findByNaziv(naziv);
	}

	@Override
	public Proizvod findOne(Long proizvodId) {
		return proizvodRepository.findOne(proizvodId);
	}

	@Override
	public List<Proizvod> findAll() {
		return proizvodRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		 proizvodRepository.delete(id);
		
	}

}
