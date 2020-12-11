package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.PDVKategorija;
import projekat.repository.PDVKategorijaRepository;
import projekat.service.intrfc.PDVKategorijaServiceInterface;

@Service
public class PDVKategorijaService implements PDVKategorijaServiceInterface {
	
	@Autowired
	private PDVKategorijaRepository pdvKategorijaRepository;

	@Override
	public PDVKategorija findByNazivKategorije(String nazivKategorije) {
		return pdvKategorijaRepository.findByNazivKategorije(nazivKategorije);
	}

	@Override
	public PDVKategorija save(PDVKategorija pdvKategorija) {
		return pdvKategorijaRepository.save(pdvKategorija);
	}

	@Override
	public PDVKategorija findOne(Long id) {
		return pdvKategorijaRepository.findOne(id);
	}

	@Override
	public List<PDVKategorija> findAll() {
		return pdvKategorijaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		pdvKategorijaRepository.delete(id);
	}
}