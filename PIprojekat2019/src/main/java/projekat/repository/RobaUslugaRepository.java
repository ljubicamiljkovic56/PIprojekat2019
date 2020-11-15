package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.RobaUsluga;

public interface RobaUslugaRepository extends JpaRepository<RobaUsluga, Long> {

	RobaUsluga findByNazivRobeUsluge (String nazivRobeUsluge);
}
