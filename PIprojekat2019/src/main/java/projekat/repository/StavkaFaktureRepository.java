package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.StavkaFakture;

public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, Long> {
	
	StavkaFakture findByJedinicnaCena (double jedinicnaCena);
	
	List<StavkaFakture> findAll();

}
