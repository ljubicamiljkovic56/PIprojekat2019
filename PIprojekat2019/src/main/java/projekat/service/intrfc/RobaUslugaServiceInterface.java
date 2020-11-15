package projekat.service.intrfc;

import java.util.List;

import projekat.model.RobaUsluga;



public interface RobaUslugaServiceInterface {
	
	RobaUsluga save(RobaUsluga robaUsluga);
    
	RobaUsluga findByNazivRobeUsluge (String nazivRobaUsluga);

	RobaUsluga findOne(Long id);
	
	List<RobaUsluga> findAll();

	void remove(Long id);

}
