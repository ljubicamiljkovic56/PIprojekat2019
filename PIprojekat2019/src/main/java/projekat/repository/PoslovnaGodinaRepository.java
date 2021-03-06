package projekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.PoslovnaGodina;

@Repository
public interface PoslovnaGodinaRepository extends JpaRepository<PoslovnaGodina, Long> {
	
	PoslovnaGodina findByGodina (int godina);
	
	List<PoslovnaGodina> findAll();
	
	Page<PoslovnaGodina> findAllByGodina (int godina, Pageable pageable);

}
