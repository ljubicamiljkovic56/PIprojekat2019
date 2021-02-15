package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.RobaUsluga;

public interface RobaUslugaServiceInterface {
	
	RobaUsluga save(RobaUsluga robaUsluga);
    
	RobaUsluga findByNazivRobeUsluge (String nazivRobaUsluga);

	RobaUsluga findOne(Long id);
	
	List<RobaUsluga> findAll();

	void remove(Long id);

	Page<RobaUsluga> findAll(int pageNo, int pageSize);
	
	Page<RobaUsluga> findAllByNazivRobeUsluge(String nazivRobeUsluge, int pageNo, int pageSize);
}
