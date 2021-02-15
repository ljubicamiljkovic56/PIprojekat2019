package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.NaseljenoMesto;

public interface NaseljenoMestoServiceInterface {
	
	NaseljenoMesto findByNazivMesta(String nazivMesta);

	NaseljenoMesto save(NaseljenoMesto naseljenoMesto);

	NaseljenoMesto findOne(Long id);

	List<NaseljenoMesto> findAll();
	
	void remove(Long id);
	
	Page<NaseljenoMesto> findAll(int pageNo, int pageSize);
	
	Page<NaseljenoMesto> findAllByNazivMesta (String nazivMesta, int pageNo, int pageSize);
	
	Page<NaseljenoMesto> findAllByPttBroj (int pttBroj, int pageNo, int pageSize);
}
