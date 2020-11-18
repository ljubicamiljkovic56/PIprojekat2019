package projekat.service.intrfc;

import java.util.List;

import projekat.model.JedinicaMere;

public interface JedinicaMereServiceInterface {

	JedinicaMere findByNazivJediniceMere (String nazivJediniceMere);
	
	JedinicaMere findBySkraceniNaziv (String skraceniNaziv);
	
	void add(JedinicaMere jedinicaMere);

	JedinicaMere save(JedinicaMere jedinicaMere);

	JedinicaMere findOne(Long id);

	List<JedinicaMere> findAll();
	
	void remove(Long id);

}
