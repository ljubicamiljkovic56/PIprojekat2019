package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.StavkaNarudzbenice;

public interface StavkaNarudzbeniceServiceInterface {

	List<StavkaNarudzbenice> findAll();
	
	StavkaNarudzbenice save (StavkaNarudzbenice stavkaNarudzbenice);
	
	StavkaNarudzbenice findOne(Long id);
	
	void remove(Long id);
	
	Page<StavkaNarudzbenice> findAll(int pageNo, int pageSize);
}
