package projekat.service.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.JedinicaMere;
import projekat.repository.JedinicaMereRepository;
import projekat.service.intrfc.JedinicaMereServiceInterface;
@Transactional
@Service
public class JedinicaMereService implements JedinicaMereServiceInterface {
	
	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;

	@Override
	public JedinicaMere findByNazivJediniceMere(String nazivJediniceMere) {
		return jedinicaMereRepository.findByNazivJediniceMere(nazivJediniceMere);
	}

	@Override
	public JedinicaMere findBySkraceniNaziv(String skraceniNaziv) {
		return jedinicaMereRepository.findBySkraceniNaziv(skraceniNaziv);
	}

	@Override
	public JedinicaMere save(JedinicaMere jedinicaMere) {
		return jedinicaMereRepository.save(jedinicaMere);
		
	}

	@Override
	public JedinicaMere findOne(Long id) {
		return jedinicaMereRepository.findOne(id);
	}

	@Override
	public List<JedinicaMere> findAll() {
		return jedinicaMereRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		jedinicaMereRepository.delete(id);

	}

}
