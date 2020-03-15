package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Korisnik;
import projekat.repository.KorisnikRepository;
import projekat.service.m.KorisnikService;

@Transactional
@Service
public class JpaKorisnikService implements KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Override
	public Korisnik findOne(int id) {
		return korisnikRepository.findOne(id);
	}

	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public List<Korisnik> save(List<Korisnik> korisnici) {
		return korisnikRepository.save(korisnici);
	}
	
	public boolean proveriKorisnickoIme(String korisnickoIme) {
	   Korisnik korisnik = korisnikRepository.findByUsername(korisnickoIme);
	   if(korisnik == null) {
		   return true;
	   }else {
		   return false;
	   }
	}
	
	   
    public Korisnik registracija(Korisnik korisnik) {
    	Korisnik korisnik1 = new Korisnik();
    	korisnik1.setIdKorisnik(korisnik1.getIdKorisnik());
    	korisnik1.setKorisnickoIme(korisnik1.getKorisnickoIme());
    	korisnik1.setLozinka(korisnik1.getLozinka());
    	korisnikRepository.save(korisnik1);
		return korisnik1;
    }
    
    public String proveriKorisnika(String korisnickoIme, String lozinka) {
    	Korisnik korisnik2 = korisnikRepository.findByUsername(korisnickoIme);
    	if(korisnik2 == null) {
    		System.out.println("Nema korisnika sa tim korisnickim imenom");
    	}else {
    		System.out.println("Greska");
    		
    	}
    	return korisnik2.getKorisnickoIme();
    }

}
