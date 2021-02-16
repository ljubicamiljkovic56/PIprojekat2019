package projekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.StavkaNarudzbenice;
@Repository
public interface StavkaNarudzbeniceRepository extends JpaRepository<StavkaNarudzbenice, Long> {
	
	List<StavkaNarudzbenice> findAll();

	Page<StavkaNarudzbenice> findAllByCena (double cena, Pageable pageable);
}
