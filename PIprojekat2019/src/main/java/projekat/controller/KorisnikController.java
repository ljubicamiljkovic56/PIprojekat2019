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

import projekat.service.impl.JpaKorisnikService;


@CrossOrigin
@RestController
@RequestMapping(value = "api/korisnici")
public class KorisnikController {
	
	@Autowired
	public JpaKorisnikService jpaKorisnikService;
	
	@GetMapping(path = "korisnik/all")
	public List<Korisnik> getAll(){
		return jpaKorisnikService.findAll();
	}

	@PostMapping(path="korisnik/registracija")
	public ResponseEntity<Korisnik> registracija( 
			@RequestParam String korisnickoIme, @RequestParam String lozinka){
	
		System.out.println(korisnickoIme + "-" + lozinka);
		Korisnik korisnik = new Korisnik();
		boolean provera = jpaKorisnikService.proveriKorisnickoIme(korisnickoIme);
		if(provera == true) {
			System.out.println("Mozete se registrovati");
			korisnik.setKorisnickoIme(korisnickoIme);
			korisnik.setLozinka(lozinka);
			
			jpaKorisnikService.registracija(korisnik);
			
			return new ResponseEntity<Korisnik>(korisnik,HttpStatus.CREATED);
			
		}else  {
			System.out.println("Username vec postoji i ne mozete da se sa njim registrujete");
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
	
	@PostMapping(path="korisnik/login")
	public ResponseEntity<String> loginKorisnika(@RequestParam String korisnickoIme, @RequestParam String lozinka) {
		
		System.out.println(korisnickoIme);
		System.out.println(lozinka);
		
		String korisnik = jpaKorisnikService.proveriKorisnika(korisnickoIme, lozinka);
	
		return new ResponseEntity<String>(korisnik, HttpStatus.CREATED);
	}

}
