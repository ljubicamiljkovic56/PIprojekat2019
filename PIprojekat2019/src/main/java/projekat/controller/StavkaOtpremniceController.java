package projekat.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
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
import projekat.model.StavkaOtpremnice;
import projekat.service.intrfc.StavkaOtpremniceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkeotpremnice")
@ControllerAdvice
public class StavkaOtpremniceController {
	
	@Autowired
	private StavkaOtpremniceServiceInterface stavkaOtpremniceServicenterface;
	
	
	@GetMapping(path = "/all")
	public List<StavkaOtpremnice> getAll() {
		return stavkaOtpremniceServicenterface.findAll();
	}
	
	@PostMapping(path = "/dodajStavkuOtpremnice")
	public ResponseEntity<Void> dodajStavkuOtpremnice(@RequestParam("redni_broj_proizvoda") String redniBrojProizvoda,
			@RequestParam("jedinica_mere") String nazivJediniceMere, @RequestParam("cena") String cena,
			@RequestParam("kolicina") String kolicina, @RequestParam("napomena") String napomena){
		
		System.out.println("Redni broj proizvoda: " + redniBrojProizvoda);
		System.out.println("Jedinica mere: " + nazivJediniceMere);
		System.out.println("Cena: " + cena);
		System.out.println("Kolicina: " + kolicina);
		System.out.println("Napomena: " + napomena);
		
		int redniBrojProizvodaInt = Integer.parseInt(redniBrojProizvoda);
		
		double cenaDouble = Double.parseDouble(cena);
		double kolicinaDouble = Double.parseDouble(kolicina);
		
		StavkaOtpremnice stavkaOtpremnice = new StavkaOtpremnice();
		stavkaOtpremnice.setRedniBrojProizvoda(redniBrojProizvodaInt);
		stavkaOtpremnice.setJedinicaMere(nazivJediniceMere);
		stavkaOtpremnice.setCena(cenaDouble);
		stavkaOtpremnice.setKolicina(kolicinaDouble);
		stavkaOtpremnice.setNapomena(napomena);
		stavkaOtpremniceServicenterface.save(stavkaOtpremnice);
		
		System.out.println("Dodata je stavka otpremnice.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path =  "/izmeniStavkuOtpremnice")
	public ResponseEntity<Void> izmeniStavkuOtpremnice(@RequestParam("redni_broj_proizvoda") String redniBrojProizvoda,
			@RequestParam("novi_broj") String noviBroj,
			@RequestParam("jedinica_mere") String nazivJediniceMere, @RequestParam("cena") String cena,
			@RequestParam("kolicina") String kolicina, @RequestParam("napomena") String napomena) {
			
		int redniBrojProizvodaInt = Integer.parseInt(redniBrojProizvoda);
		
		StavkaOtpremnice stavkaOtpremnice = stavkaOtpremniceServicenterface.findByRedniBrojProizvoda(redniBrojProizvodaInt);
		
		int noviBrojInt = Integer.parseInt(noviBroj);
		
		double cenaDouble = Double.parseDouble(cena);
		double kolicinaDouble = Double.parseDouble(kolicina);
		
		if(stavkaOtpremnice != null) {
			stavkaOtpremnice.setRedniBrojProizvoda(noviBrojInt);
			stavkaOtpremnice.setJedinicaMere(nazivJediniceMere);
			stavkaOtpremnice.setCena(cenaDouble);
			stavkaOtpremnice.setKolicina(kolicinaDouble);
			stavkaOtpremnice.setNapomena(napomena);
			stavkaOtpremniceServicenterface.save(stavkaOtpremnice);
			
			System.out.println("Izmenjena je stavka otpremnice.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(path = "/obrisiStavkuOtpremnice/{id}")
	public ResponseEntity<Void> obrisiStavkuOtpremnice(@PathVariable("id") long id) {
		
		StavkaOtpremnice stavkaOtpremnice = stavkaOtpremniceServicenterface.findOne(id);
		
		if(stavkaOtpremnice == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		stavkaOtpremniceServicenterface.remove(stavkaOtpremnice.getIdStavkeOtpremnice());
		
		System.out.println("Obrisana je stavka otpremnice");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
