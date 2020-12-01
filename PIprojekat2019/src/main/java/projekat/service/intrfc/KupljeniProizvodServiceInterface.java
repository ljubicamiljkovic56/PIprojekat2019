package projekat.service.intrfc;

import java.util.List;

import projekat.model.KupljeniProizvod;

public interface KupljeniProizvodServiceInterface {
	
	KupljeniProizvod save(KupljeniProizvod kupljeniProizvod);
    
	KupljeniProizvod findByNaziv(String naziv);

	KupljeniProizvod findOne(Long kupljeniProizvodId);
	
	List<KupljeniProizvod> findAll();

	void remove(Long id);

}
