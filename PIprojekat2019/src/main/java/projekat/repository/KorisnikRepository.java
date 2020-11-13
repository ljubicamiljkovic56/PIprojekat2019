package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	 Korisnik findByUsername(String username);
	    
	 Korisnik findByPassword(String password);
	 
	 Korisnik findByUsernameAndPassword(String username, String password);
	    
	 List<Korisnik> findAll();
}
