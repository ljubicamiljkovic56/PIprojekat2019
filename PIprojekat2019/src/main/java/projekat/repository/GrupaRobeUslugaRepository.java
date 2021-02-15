package projekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.GrupaRobeUsluga;
@Repository
public interface GrupaRobeUslugaRepository extends JpaRepository<GrupaRobeUsluga, Long> {
	
	GrupaRobeUsluga findByNazivGrupe (String nazivGrupe);
	
	List<GrupaRobeUsluga> findAll();

	Page<GrupaRobeUsluga> findAllByNazivGrupe(String nazivGrupe, Pageable pageable);
}
