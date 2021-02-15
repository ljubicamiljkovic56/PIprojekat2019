package projekat.service.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<JedinicaMere> findPaginated(int pageNo, int pageSize) {
		return jedinicaMereRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<JedinicaMere> findAllByNazivJediniceMere(String nazivJediniceMere, int pageNo, int pageSize) {
		return jedinicaMereRepository.findAllByNazivJediniceMere(nazivJediniceMere, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<JedinicaMere> findAll(Pageable pageable){
		return jedinicaMereRepository.findAll(pageable);
	}

    public List<JedinicaMere> getAllJedinicaMere(Integer pageNo, Integer pageSize)
    {
        Pageable paging = new PageRequest(pageNo, pageSize);
 
        Page<JedinicaMere> pagedResult = jedinicaMereRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<JedinicaMere>();
        }
    }

	@Override
	public Page<JedinicaMere> findAll(int pageNo, int pageSize) {
		return jedinicaMereRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<JedinicaMere> findAllBySkraceniNaziv(String skraceniNaziv, int pageNo, int pageSize) {
		return jedinicaMereRepository.findAllBySkraceniNaziv(skraceniNaziv, new PageRequest(pageNo, pageSize));
	}

}
