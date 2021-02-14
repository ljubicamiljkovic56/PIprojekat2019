package projekat.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projekat.model.Narudzbenica;
import projekat.model.RobaUsluga;
import projekat.model.StavkaNarudzbenice;
import projekat.service.intrfc.NarudzbenicaServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;
import projekat.service.intrfc.StavkaNarudzbeniceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkenarudzbenice")
@ControllerAdvice
public class StavkaNarudzbeniceController {
	
	@Autowired
	private StavkaNarudzbeniceServiceInterface stavkaNarudzbeniceServiceInterface;
	
	@Autowired
	private NarudzbenicaServiceInterface narudzbenicaServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<StavkaNarudzbenice> getAll() {
		return stavkaNarudzbeniceServiceInterface.findAll();
	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<StavkaNarudzbenice>> getAllStavkaNarudzbenice(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
       
		Page<StavkaNarudzbenice> stavkeNarudzbenice = stavkaNarudzbeniceServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(stavkeNarudzbenice.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(stavkeNarudzbenice.getContent());
    }
	
	
	@PostMapping(value = "/dodajStavkuNarudzbenice")
	public ResponseEntity<Void> dodajStavkuNarudzbenice(@RequestParam("jedinica_mere") String jedinicaMere,
			@RequestParam("kolicina") String kolicinaString, @RequestParam("cena") String cenaString,
			@RequestParam("narudzbenica") String broj, 
			@RequestParam("roba") String robaString){
		
		int brojNarudzbenice = Integer.parseInt(broj);
		
		double kolicina = Double.parseDouble(kolicinaString);
		
		double cena = Double.parseDouble(cenaString);
		
	//	double iznos = Double.parseDouble(iznosString);
		
		Narudzbenica narudzbenica1 = narudzbenicaServiceInterface.findByBrojNarudzbenice(brojNarudzbenice);
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(narudzbenica1.getId());
		
		RobaUsluga robaUsluga1 = robaUslugaServiceInterface.findByNazivRobeUsluge(robaString);
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findOne(robaUsluga1.getIdRobeUsluge());
				
		if(jedinicaMere == null || kolicina == 0 || cena == 0 || narudzbenica == null || robaUsluga == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		double iznos = kolicina * cena;
		
		System.out.println("Iznos stavke narudzbenice: " + iznos);
		
		StavkaNarudzbenice stavkaNarudzbenice = new StavkaNarudzbenice();
		stavkaNarudzbenice.setJedinicaMere(jedinicaMere);
		stavkaNarudzbenice.setKolicina(kolicina);
		stavkaNarudzbenice.setCena(cena);
		stavkaNarudzbenice.setIznos(iznos);
		stavkaNarudzbenice.setNarudzbenica(narudzbenica);
		stavkaNarudzbenice.setRobaUsluga(robaUsluga);
		stavkaNarudzbeniceServiceInterface.save(stavkaNarudzbenice);
		
		System.out.println("Dodata je nova stavka narudzbenice");
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	@DeleteMapping(value = "/obrisiStavkuNarudzbenice/{id}")
	private ResponseEntity<Void> obrisiStavkuNarudzbenice(@PathVariable("id") long id) {
		
		StavkaNarudzbenice stavkaNarudzbenice = stavkaNarudzbeniceServiceInterface.findOne(id);
		
		if(stavkaNarudzbenice == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		stavkaNarudzbeniceServiceInterface.remove(stavkaNarudzbenice.getId());
		
		System.out.println("Obrisana je stavka narudzbenice.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<Void> handleNumberFormat() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
