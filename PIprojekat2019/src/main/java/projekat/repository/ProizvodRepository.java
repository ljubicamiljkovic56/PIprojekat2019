package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Proizvod;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

	Proizvod findByNaziv(String naziv);
}
