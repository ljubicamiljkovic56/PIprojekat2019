package projekat.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Cenovnik;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {
	
	Cenovnik findByDatumPocetkaVazenja (Date datumVazenja);

	List<Cenovnik> findAll();
}
