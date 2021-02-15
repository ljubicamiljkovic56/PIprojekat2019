package projekat.service.intrfc;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.Cenovnik;

public interface CenovnikServiceInterface {
	
	Cenovnik findByDatumPocetkaVazenja (Date datumVazenja);
	
	Cenovnik save(Cenovnik cenovnik);

	Cenovnik findOne(Long id);

	List<Cenovnik> findAll();
	
	void remove(Long id);
	
	Page<Cenovnik> findAll(int pageNo, int pageSize);
	
	Page<Cenovnik> findAllByDatumPocetkaVazenja(Date datumPocetkaVazenja, int pageNo, int pageSize);
	

}
