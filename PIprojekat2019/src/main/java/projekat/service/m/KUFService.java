package projekat.service.m;

import java.util.List;
import projekat.model.KUF;

public interface KUFService {
	
	KUF findOne(int id);
	
	List<KUF> findAll();
	
	KUF save(KUF kuf);
	
	List<KUF> save(List<KUF> kufovi);

	KUF delete(int id);
	
	void delete(List<Integer> ids);

}
