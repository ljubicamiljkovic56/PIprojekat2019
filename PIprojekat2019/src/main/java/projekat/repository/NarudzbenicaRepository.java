package projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Narudzbenica;

public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Long> {

	Narudzbenica findByNazivRobe (String nazivRobe);
}
