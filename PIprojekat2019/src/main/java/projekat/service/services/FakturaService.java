package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.Faktura;
import projekat.repository.FakturaRepository;
import projekat.service.intrfc.FakturaServiceInterface;

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

}
