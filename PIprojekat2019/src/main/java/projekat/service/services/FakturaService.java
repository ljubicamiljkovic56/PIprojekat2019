package projekat.service.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projekat.model.Faktura;
import projekat.repository.FakturaRepository;
import projekat.service.intrfc.FakturaServiceInterface;

@Transactional
@Service
public class FakturaService implements FakturaServiceInterface {
	
	@Autowired
	private FakturaRepository fakturaRepository;

	@Override
	public Faktura findByBrojFakture(int brojFakture) {
		return fakturaRepository.findByBrojFakture(brojFakture);
	}

	@Override
	public Faktura save(Faktura faktura) {
		return fakturaRepository.save(faktura);
	}

	@Override
	public Faktura findOne(Long id) {
		return fakturaRepository.findOne(id);
	}

	@Override
	public List<Faktura> findAll() {
		return fakturaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		fakturaRepository.delete(id);
		
	}

	@Override
	public Page<Faktura> findAll(int pageNo, int pageSize) {
		return fakturaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Faktura> findAllByBrojFakture(int brojFakture, int pageNo, int pageSize) {
		return fakturaRepository.findAllByBrojFakture(brojFakture, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Faktura> findAllByStatusFakture(String statusFakture, int pageNo, int pageSize) {
		return fakturaRepository.findAllByStatusFakture(statusFakture, new PageRequest(pageNo, pageSize));
	}

}
