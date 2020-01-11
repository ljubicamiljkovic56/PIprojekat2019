package projekat.service.m;

import java.util.List;

import projekat.model.Cenovnik;

public interface CenovnikService {

	
	Cenovnik findOne(int id);
	
	List<Cenovnik> findAll();
	
	Cenovnik save(Cenovnik cenovnik);
	
	List<Cenovnik> save(List<Cenovnik> cenovnici);

	Cenovnik delete(int id);
	
	void delete(List<Integer> ids);
}
