package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{

	 Korisnik findByUsername(String korisnickoIme);
	    
	 Korisnik findByPassword(String lozinka);
	    
	 List<Korisnik> findAll();
}
