package projekat.service.intrfc;

import java.util.List;

import projekat.model.Proizvod;

public interface ProizvodServiceInterface {
	
	Proizvod save(Proizvod proizvod);
    
	Proizvod findByNaziv(String naziv);

	Proizvod findOne(Long proizvodId);
	
	List<Proizvod> findAll();

	void remove(Long id);

}
