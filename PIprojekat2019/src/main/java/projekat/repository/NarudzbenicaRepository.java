package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.Narudzbenica;

@Repository
public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long> {
	
	Narudzbenica findByBrojNarudzbenice (int brojNarudzbenice);

}
