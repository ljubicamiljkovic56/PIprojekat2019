package projekat.service.intrfc;

import java.util.List;

import projekat.model.NaseljenoMesto;

public interface NaseljenoMestoServiceInterface {
	
	NaseljenoMesto findByNazivMesta(String nazivMesta);

	NaseljenoMesto save(NaseljenoMesto naseljenoMesto);

	NaseljenoMesto findOne(Long id);

	List<NaseljenoMesto> findAll();
	
	void remove(Long id);
}
