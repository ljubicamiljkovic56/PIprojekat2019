package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Faktura;

public interface FakturaRepository extends JpaRepository<Faktura, Long> {

	Faktura findByBrojFakture (int brojFakture);
	
	List<Faktura> findAll();
}
