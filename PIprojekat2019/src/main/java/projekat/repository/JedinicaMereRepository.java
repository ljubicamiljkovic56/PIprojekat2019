package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.JedinicaMere;

public interface JedinicaMereRepository extends JpaRepository<JedinicaMere, Long> {
	
	JedinicaMere findByNazivJediniceMere (String nazivJediniceMere);
	
	JedinicaMere findBySkraceniNaziv (String skraceniNaziv);
	
	List<JedinicaMere> findAll();

}
