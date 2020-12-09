package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	 Korisnik findByUsername(String username);
	    
	 Korisnik findByPassword(String password);
	 
	 Korisnik findByUsernameAndPassword(String username, String password);
	    
	 List<Korisnik> findAll();
}
