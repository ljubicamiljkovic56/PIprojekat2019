package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.Proizvod;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

	Proizvod findByNaziv(String naziv);
}
