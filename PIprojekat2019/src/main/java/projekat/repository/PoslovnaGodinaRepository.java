package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.PoslovnaGodina;

public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long> {
	
	PoslovnaGodina findByGodina (int godina);
	
	List<PoslovnaGodina> findAll();

}
