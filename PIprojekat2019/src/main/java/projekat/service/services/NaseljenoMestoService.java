package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Override
	public Page<NaseljenoMesto> findAll(int pageNo, int pageSize) {
		return naseljenoMestoRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<NaseljenoMesto> findAllByNazivMesta(String nazivMesta, int pageNo, int pageSize) {
		return naseljenoMestoRepository.findAllByNazivMesta(nazivMesta, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<NaseljenoMesto> findAllByPttBroj(int pttBroj, int pageNo, int pageSize) {
		return naseljenoMestoRepository.findAllByPttBroj(pttBroj, new PageRequest(pageNo, pageSize));
	}

}
