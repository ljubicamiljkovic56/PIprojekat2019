package projekat.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.Cenovnik;

@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {
	
	Cenovnik findByDatumPocetkaVazenja (Date datumVazenja);

	List<Cenovnik> findAll();
}
