package projekat.service.intrfc;

import java.util.List;

import projekat.model.Narudzbenica;

public interface NarudzbenicaServiceInterface {
	
	Narudzbenica findByBrojNarudzbenice (int brojNarudzbenice);
	
	Narudzbenica save(Narudzbenica narudzbenica);

	Narudzbenica findOne(Long id);
	
	List<Narudzbenica> findAll();

	void remove(Long id);
}
