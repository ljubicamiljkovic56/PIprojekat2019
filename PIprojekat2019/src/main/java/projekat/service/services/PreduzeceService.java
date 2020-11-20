package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.Preduzece;
import projekat.repository.PreduzeceRepository;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Service
public class PreduzeceService implements PreduzeceServiceInterface {
	
	@Autowired
	private PreduzeceRepository preduzeceRepository;

	@Override
	public Preduzece findByNazivPreduzeca(String nazivPreduzeca) {
		return preduzeceRepository.findByNazivPreduzeca(nazivPreduzeca);
	}

	@Override
	public Preduzece save(Preduzece preduzece) {
		return preduzeceRepository.save(preduzece);
	}

	@Override
	public Preduzece findOne(Long id) {
		return preduzeceRepository.findOne(id);
	}

	@Override
	public List<Preduzece> findAll() {
		return preduzeceRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		preduzeceRepository.delete(id);
	}

}