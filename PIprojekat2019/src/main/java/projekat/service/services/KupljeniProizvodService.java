package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.KupljeniProizvod;
import projekat.repository.KupljeniProizvodRepository;
import projekat.service.intrfc.KupljeniProizvodServiceInterface;

@Service
public class KupljeniProizvodService implements KupljeniProizvodServiceInterface {
	
	@Autowired
	private KupljeniProizvodRepository kupljeniProizvodRepository;

	@Override
	public KupljeniProizvod save(KupljeniProizvod kupljeniProizvod) {
		return kupljeniProizvodRepository.save(kupljeniProizvod);
	}

	@Override
	public KupljeniProizvod findByNaziv(String naziv) {
		return kupljeniProizvodRepository.findByNaziv(naziv);
	}

	@Override
	public KupljeniProizvod findOne(Long kupljeniProizvodId) {
		return kupljeniProizvodRepository.findOne(kupljeniProizvodId);
	}

	@Override
	public List<KupljeniProizvod> findAll() {
		return kupljeniProizvodRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		kupljeniProizvodRepository.delete(id);
	}

}
