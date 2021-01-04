package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.NaseljenoMesto;
import projekat.repository.NaseljenoMestoRepository;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;

@Transactional
@Service
public class NaseljenoMestoService implements NaseljenoMestoServiceInterface {
	
	@Autowired
	private NaseljenoMestoRepository naseljenoMestoRepository;

	@Override
	public NaseljenoMesto findByNazivMesta(String nazivMesta) {
		return naseljenoMestoRepository.findByNazivMesta(nazivMesta);
	}

	@Override
	public NaseljenoMesto save(NaseljenoMesto naseljenoMesto) {
		return naseljenoMestoRepository.save(naseljenoMesto);
	}

	@Override
	public NaseljenoMesto findOne(Long id) {
		return naseljenoMestoRepository.findOne(id);
	}

	@Override
	public List<NaseljenoMesto> findAll() {
		return naseljenoMestoRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		naseljenoMestoRepository.delete(id);

	}

}
