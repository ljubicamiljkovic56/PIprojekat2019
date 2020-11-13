package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.Korisnik;
import projekat.service.intrfc.KorisnikServiceInterface;
import projekat.service.services.KorisnikService;


@CrossOrigin
@RestController
@RequestMapping(value = "api/korisnici")
public class KorisnikController {
	
	@Autowired
	private KorisnikServiceInterface korisnikServiceInterface;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@GetMapping(path = "korisnik/all")
	public List<Korisnik> getAll(){
		return korisnikServiceInterface.findAll();
	}

	@PostMapping(path="korisnik/registracija")
	public ResponseEntity<Korisnik> registracija(@RequestParam("username") String username, @RequestParam("password") String password){

		
		Korisnik korisnik = new Korisnik();
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		boolean provera = korisnikService.checkUsername(username);
		if(provera == true) {
			System.out.println("Mozete se registrovati");
			korisnik.setUsername(username);
			korisnik.setPassword(password);
			korisnik.setUloga("korisnik");

			
			korisnikServiceInterface.save(korisnik);
		
		return new ResponseEntity<Korisnik>(korisnik,HttpStatus.CREATED);
			
		}else  {
			System.out.println("Username vec postoji i ne mozete da se sa njim registrujete");
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
	
	@PostMapping(path="korisnik/loginKorisnika")
	public ResponseEntity<Void> loginKorisnika(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		System.out.println("Login...");
		System.out.println(username);
		System.out.println(password);
		
		Korisnik korisnik = korisnikServiceInterface.findByUsernameAndPassword(username, password);
		if(korisnik == null) {
			System.out.println("Neuspesna prijava");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		System.out.println(korisnik.getUsername());
		return new ResponseEntity<Void>(HttpStatus.OK);
			
		
	}

}
