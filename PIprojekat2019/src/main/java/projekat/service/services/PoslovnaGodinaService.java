package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.PoslovnaGodina;
import projekat.repository.PoslovnaGodinaRepository;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;

@Service
public class PoslovnaGodinaService implements PoslovnaGodinaServiceInterface {
	
	@Autowired
	private PoslovnaGodinaRepository poslovnaGodinaRepository;

	@Override
	public PoslovnaGodina findByGodina(int godina) {
		return poslovnaGodinaRepository.findByGodina(godina);
	}

	@Override
	public PoslovnaGodina save(PoslovnaGodina poslovnaGodina) {
		return poslovnaGodinaRepository.save(poslovnaGodina);
	}

	@Override
	public PoslovnaGodina findOne(Long id) {
		return 	poslovnaGodinaRepository.findOne(id);
	}

	@Override
	public List<PoslovnaGodina> findAll() {
		return poslovnaGodinaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		poslovnaGodinaRepository.delete(id);

	}

}
