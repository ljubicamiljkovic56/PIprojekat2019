package projekat.service.intrfc;

import java.util.List;

import projekat.model.Korisnik;

public interface KorisnikServiceInterface {
	
	Korisnik findByUsername(String username);

	Korisnik findByUsernameAndPassword(String username, String password);
	
	void add(Korisnik korisnik);

	Korisnik save(Korisnik korisnik);

	Korisnik findOne(Long userId);

	List<Korisnik> findAll();
	
	void remove(Long id);

}
