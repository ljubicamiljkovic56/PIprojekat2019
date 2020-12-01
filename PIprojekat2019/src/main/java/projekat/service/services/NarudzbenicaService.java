package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.Narudzbenica;
import projekat.repository.NarudzbenicaRepository;
import projekat.service.intrfc.NarudzbenicaServiceInterface;

@Service
public class NarudzbenicaService implements NarudzbenicaServiceInterface {

	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	
	@Override
	public Narudzbenica save(Narudzbenica narudzbenica) {
		return narudzbenicaRepository.save(narudzbenica);
	}

	@Override
	public Narudzbenica findByNazivRobe(String nazivRobe) {
		return narudzbenicaRepository.findByNazivRobe(nazivRobe);
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

}
