package projekat.service.intrfc;

import java.util.List;

import projekat.model.GrupaRobeUsluga;

public interface GrupaRobeUslugaServiceInterface {
	
	GrupaRobeUsluga findByNazivGrupe (String nazivGrupe);
	
	void add(GrupaRobeUsluga grupaRobe);

	GrupaRobeUsluga save(GrupaRobeUsluga grupaRobe);

	GrupaRobeUsluga findOne(Long id);

	List<GrupaRobeUsluga> findAll();
	
	void remove(Long id);

}
