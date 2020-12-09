package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.PDVKategorija;
@Repository
public interface PDVKategorijaRepository extends JpaRepository<PDVKategorija, Long> {
	
	PDVKategorija findByNazivKategorije (String nazivKategorije);
	
	List<PDVKategorija> findAll();

}
