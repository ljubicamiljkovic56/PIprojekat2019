package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.Preduzece;

public interface PreduzeceServiceInterface {
	
	Preduzece findByNazivPreduzeca (String nazivPreduzeca);

	Preduzece save(Preduzece preduzece);

	Preduzece findOne(Long id);

	List<Preduzece> findAll();
	
	void remove(Long id);
	
	Page<Preduzece> findAll(int pageNo, int pageSize);
	
	Page<Preduzece> findAllByNazivPreduzeca (String nazivPreduzeca, int pageNo, int pageSize);
	
	Page<Preduzece> findAllByAdresa (String adresa, int pageNo, int pageSize);
}
