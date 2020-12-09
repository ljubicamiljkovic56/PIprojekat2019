package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.KupljeniProizvod;
@Repository
public interface KupljeniProizvodRepository extends JpaRepository<KupljeniProizvod, Long> {

	KupljeniProizvod findByNaziv (String naziv);
}
