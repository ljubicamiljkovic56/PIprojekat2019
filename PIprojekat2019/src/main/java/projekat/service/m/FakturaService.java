package projekat.service.m;

import java.util.List;

import projekat.model.Faktura;

public interface FakturaService {

	Faktura findOne(int id);
	
	List<Faktura> findAll();
	
	Faktura save(Faktura faktura);
	
	List<Faktura> save(List<Faktura> fakture);

	Faktura delete(int id);
	
	void delete(List<Integer> ids);
}
