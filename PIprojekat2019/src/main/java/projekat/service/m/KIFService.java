package projekat.service.m;

import java.util.List;

import projekat.model.KIF;
public interface KIFService {
	
	KIF findOne(int id);
	
	List<KIF> findAll();
	
	KIF save(KIF kif);
	
	List<KIF> save(List<KIF> kifovi);

	KIF delete(int id);
	
	void delete(List<Integer> ids);

}
