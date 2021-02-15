package projekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.NaseljenoMesto;
@Repository
public interface NaseljenoMestoRepository extends JpaRepository<NaseljenoMesto, Long> {

	NaseljenoMesto findByNazivMesta (String nazivMesta);
	
	List<NaseljenoMesto> findAll();
	
	Page<NaseljenoMesto> findAllByNazivMesta (String nazivMesta, Pageable pageable);
	
	Page<NaseljenoMesto> findAllByPttBroj (int pttBroj, Pageable pageable);
}
