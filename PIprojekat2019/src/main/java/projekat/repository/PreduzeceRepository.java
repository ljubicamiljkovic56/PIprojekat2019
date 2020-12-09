package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.Preduzece;

@Repository
public interface PreduzeceRepository extends JpaRepository<Preduzece, Long> {
	
	Preduzece findByNazivPreduzeca (String nazivPreduzeca);
	
	List<Preduzece> findAll();

}
