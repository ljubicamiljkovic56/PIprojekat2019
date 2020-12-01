package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.KupljeniProizvod;

public interface KupljeniProizvodRepository extends JpaRepository<KupljeniProizvod, Long> {

	KupljeniProizvod findByNaziv (String naziv);
}
