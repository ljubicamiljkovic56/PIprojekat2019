package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.NaseljenoMesto;

public interface NaseljenoMestoRepository extends JpaRepository<NaseljenoMesto, Long> {

	NaseljenoMesto findByNazivMesta (String nazivMesta);
	
	List<NaseljenoMesto> findAll();
}
