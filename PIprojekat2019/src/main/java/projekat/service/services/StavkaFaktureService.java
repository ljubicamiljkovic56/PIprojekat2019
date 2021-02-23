package projekat.service.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.StavkaFakture;
import projekat.repository.StavkaFaktureRepository;
import projekat.service.intrfc.StavkaFaktureServiceInterface;

@Transactional
@Service
public class StavkaFaktureService implements StavkaFaktureServiceInterface {
	
	@Autowired
	private StavkaFaktureRepository stavkaFaktureRepository;

	@Override
	public StavkaFakture save(StavkaFakture stavkaFakture) {
		return stavkaFaktureRepository.save(stavkaFakture);
	}

	@Override
	public StavkaFakture findOne(Long id) {
		return stavkaFaktureRepository.findOne(id);
	}

	@Override
	public List<StavkaFakture> findAll() {
		return stavkaFaktureRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		stavkaFaktureRepository.delete(id);

	}

	@Override
	public StavkaFakture findByJedinicnaCena(double jedinicnaCena) {
		return stavkaFaktureRepository.findByJedinicnaCena(jedinicnaCena);
	}

	@Override
	public Page<StavkaFakture> findAll(int pageNo, int pageSize) {
		return stavkaFaktureRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<StavkaFakture> findAllByIznos(double iznos, int pageNo, int pageSize) {
		return stavkaFaktureRepository.findAllByIznos(iznos, new PageRequest(pageNo, pageSize));
	}

	@Override
	public List<StavkaFakture> findByFaktura(Long idFakture) {
		return stavkaFaktureRepository.findByFaktura(idFakture);
	}

}
