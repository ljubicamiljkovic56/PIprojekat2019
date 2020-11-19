package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.GrupaRobeUsluga;

public interface GrupaRobeUslugaRepository extends JpaRepository<GrupaRobeUsluga, Long> {
	
	GrupaRobeUsluga findByNazivGrupe (String nazivGrupe);
	
	List<GrupaRobeUsluga> findAll();

}
