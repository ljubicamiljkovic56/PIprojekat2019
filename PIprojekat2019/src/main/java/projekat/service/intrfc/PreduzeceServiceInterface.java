package projekat.service.intrfc;

import java.util.List;

import projekat.model.Preduzece;



public interface PreduzeceServiceInterface {
	
	Preduzece findByNazivPreduzeca (String nazivPreduzeca);

	Preduzece save(Preduzece preduzece);

	Preduzece findOne(Long id);

	List<Preduzece> findAll();
	
	void remove(Long id);
}
