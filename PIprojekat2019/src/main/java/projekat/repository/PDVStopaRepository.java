package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.PDVStopa;
@Repository
public interface PDVStopaRepository extends JpaRepository<PDVStopa, Long> {
	
	PDVStopa findByProcenat (double procenat);
	
	List<PDVStopa> findAll();

}
