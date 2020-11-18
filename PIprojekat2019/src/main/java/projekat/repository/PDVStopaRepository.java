package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.PDVStopa;

public interface PDVStopaRepository extends JpaRepository<PDVStopa, Long> {
	
	PDVStopa findByProcenat (double procenat);
	
	List<PDVStopa> findAll();

}
