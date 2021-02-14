package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.Narudzbenica;

public interface NarudzbenicaServiceInterface {
	
	Narudzbenica findByBrojNarudzbenice (int brojNarudzbenice);
	
	Narudzbenica save(Narudzbenica narudzbenica);

	Narudzbenica findOne(Long id);
	
	List<Narudzbenica> findAll();

	void remove(Long id);
	
	Page<Narudzbenica> findAll(int pageNo, int pageSize);
}
