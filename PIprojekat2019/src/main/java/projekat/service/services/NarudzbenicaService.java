package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Narudzbenica;
import projekat.repository.NarudzbenicaRepository;
import projekat.service.intrfc.NarudzbenicaServiceInterface;

@Transactional
@Service
public class NarudzbenicaService implements NarudzbenicaServiceInterface {

	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	@Override
	public Narudzbenica save(Narudzbenica narudzbenica) {
		return narudzbenicaRepository.save(narudzbenica);
	}

	@Override
	public Narudzbenica findOne(Long id) {
		return narudzbenicaRepository.findOne(id);
	}

	@Override
	public List<Narudzbenica> findAll() {
		return narudzbenicaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		narudzbenicaRepository.delete(id);

	}

	@Override
	public Narudzbenica findByBrojNarudzbenice(int brojNarudzbenice) {
		return narudzbenicaRepository.findByBrojNarudzbenice(brojNarudzbenice);
	}

	@Override
	public Page<Narudzbenica> findAll(int pageNo, int pageSize) {
		return narudzbenicaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Narudzbenica> findAllByBrojNarudzbenice(int brojNarudzbenice, int pageNo, int pageSize) {
		return narudzbenicaRepository.findAllByBrojNarudzbenice(brojNarudzbenice, new PageRequest(pageNo, pageSize));
	}

	

}
