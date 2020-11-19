package projekat.service.intrfc;

import java.util.List;

import projekat.model.Cenovnik;

public interface CenovnikServiceInterface {
	
	Cenovnik save(Cenovnik cenovnik);

	Cenovnik findOne(Long id);

	List<Cenovnik> findAll();
	
	void remove(Long id);

}
