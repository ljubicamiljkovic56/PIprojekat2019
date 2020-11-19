package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.RobaUsluga;

public interface RobaUslugaRepository extends JpaRepository<RobaUsluga, Long> {

	RobaUsluga findByNazivRobeUsluge (String nazivRobeUsluge);
	
	List<RobaUsluga> findAll();
}
