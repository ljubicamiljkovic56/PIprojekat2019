package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.PoslovnaGodina;
import projekat.repository.PoslovnaGodinaRepository;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;

@Transactional
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

	@Override
	public Page<PoslovnaGodina> findAll(int pageNo, int pageSize) {
		return poslovnaGodinaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<PoslovnaGodina> findAllByGodina(int godina, int pageNo, int pageSize) {
		return poslovnaGodinaRepository.findAllByGodina(godina, new PageRequest(pageNo, pageSize));
	}

}
