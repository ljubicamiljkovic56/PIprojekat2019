package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.GrupaRobeUsluga;
import projekat.repository.GrupaRobeUslugaRepository;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;

@Transactional
@Service
public class GrupaRobeUslugaService implements GrupaRobeUslugaServiceInterface {
	
	@Autowired
	private GrupaRobeUslugaRepository grupaRobeUslugaRepository;

	@Override
	public GrupaRobeUsluga findByNazivGrupe(String nazivGrupe) {
		return grupaRobeUslugaRepository.findByNazivGrupe(nazivGrupe);
	}

	@Override
	public GrupaRobeUsluga save(GrupaRobeUsluga grupaRobe) {
		return grupaRobeUslugaRepository.save(grupaRobe);
	}

	@Override
	public GrupaRobeUsluga findOne(Long id) {
		return grupaRobeUslugaRepository.findOne(id);
	}

	@Override
	public List<GrupaRobeUsluga> findAll() {
		return grupaRobeUslugaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		grupaRobeUslugaRepository.delete(id);

	}

	@Override
	public Page<GrupaRobeUsluga> findAll(int pageNo, int pageSize) {
		return grupaRobeUslugaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

}
