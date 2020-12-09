package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.StavkaFakture;
@Repository
public interface StavkaFaktureRepository extends JpaRepository<StavkaFakture, Long> {
	
	StavkaFakture findByJedinicnaCena (double jedinicnaCena);
	
	List<StavkaFakture> findAll();

}
