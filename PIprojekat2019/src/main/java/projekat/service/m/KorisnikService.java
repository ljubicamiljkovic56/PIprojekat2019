package projekat.service.m;

import java.util.List;

import projekat.model.Korisnik;


public interface KorisnikService {

	
	Korisnik findOne(int id);
	
	List<Korisnik> findAll();
	
	Korisnik save(Korisnik korisnik);
	
	List<Korisnik> save(List<Korisnik> korisnici);
	
	
}
