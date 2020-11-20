package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Preduzece;

public interface PreduzeceRepository extends JpaRepository<Preduzece, Long> {
	
	Preduzece findByNazivPreduzeca (String nazivPreduzeca);
	
	List<Preduzece> findAll();

}
