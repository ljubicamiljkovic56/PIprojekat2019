package projekat.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.PDVStopa;
@Repository
public interface PDVStopaRepository extends JpaRepository<PDVStopa, Long> {
	
	PDVStopa findByProcenat (double procenat);
	
	List<PDVStopa> findAll();

	Page<PDVStopa> findAllByDatumVazenja(Date datumVazenja, Pageable pageable);
	
	Page<PDVStopa> findAllByProcenat(double procenat, Pageable pageable);
	
}
