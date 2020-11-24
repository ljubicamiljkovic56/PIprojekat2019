package projekat.service.intrfc;

import java.util.List;

import projekat.model.PoslovnaGodina;

public interface PoslovnaGodinaServiceInterface {
	
	PoslovnaGodina findByGodina (int godina);
	
	PoslovnaGodina save(PoslovnaGodina poslovnaGodina);

	PoslovnaGodina findOne(Long id);

	List<PoslovnaGodina> findAll();
	
	void remove(Long id);
}