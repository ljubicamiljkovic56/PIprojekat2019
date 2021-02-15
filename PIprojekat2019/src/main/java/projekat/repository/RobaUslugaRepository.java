package projekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.RobaUsluga;
@Repository
public interface RobaUslugaRepository extends JpaRepository<RobaUsluga, Long> {

	RobaUsluga findByNazivRobeUsluge (String nazivRobeUsluge);
	
	List<RobaUsluga> findAll();
	
	Page<RobaUsluga> findAllByNazivRobeUsluge(String nazivRobeUsluge, Pageable pageable);

}
