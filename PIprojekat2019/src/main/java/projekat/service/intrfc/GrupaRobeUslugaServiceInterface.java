package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.GrupaRobeUsluga;

public interface GrupaRobeUslugaServiceInterface {
	
	GrupaRobeUsluga findByNazivGrupe (String nazivGrupe);

	GrupaRobeUsluga save(GrupaRobeUsluga grupaRobe);

	GrupaRobeUsluga findOne(Long id);

	List<GrupaRobeUsluga> findAll();
	
	void remove(Long id);
	
	Page<GrupaRobeUsluga> findAll(int pageNo, int pageSize);

}
