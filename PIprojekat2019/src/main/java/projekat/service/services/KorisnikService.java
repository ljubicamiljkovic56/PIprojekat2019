package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.Korisnik;
import projekat.repository.KorisnikRepository;
import projekat.service.intrfc.KorisnikServiceInterface;

@Service
public class KorisnikService implements KorisnikServiceInterface {
	
	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByUsername(username);
	}

	@Override
	public Korisnik findByUsernameAndPassword(String username, String password) {
		return korisnikRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public Korisnik findOne(Long userId) {
		return korisnikRepository.findOne(userId);
	}

	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		korisnikRepository.delete(id);

	}
	
	public boolean checkUsername(String username) {
		Korisnik korisnik = korisnikRepository.findByUsername(username);
		if(korisnik == null) {
		    return true;
		}else {
		   return false;
		}
	}

}
