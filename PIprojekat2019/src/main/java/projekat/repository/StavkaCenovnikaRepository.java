package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.StavkaCenovnika;

public interface StavkaCenovnikaRepository extends JpaRepository<StavkaCenovnika, Long> {
	
	StavkaCenovnika findByCena (double cena);
	
	List<StavkaCenovnika> findAll();

}
