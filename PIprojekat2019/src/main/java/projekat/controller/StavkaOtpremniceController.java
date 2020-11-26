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

import projekat.dto.StavkaOtpremniceDTO;
import projekat.model.StavkaOtpremnice;
import projekat.service.intrfc.StavkaOtpremniceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkeotpremnice")
public class StavkaOtpremniceController {
	
	@Autowired
	private StavkaOtpremniceServiceInterface stavkaOtpremniceServicenterface;
	
//	@Autowired
//	private JedinicaMereServiceInterface jedinicaMereServiceInterface;
	
	//@Autowired
	//private OtpremnicaServiceInterface otpremnicaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<StavkaOtpremnice> getAll() {
		return stavkaOtpremniceServicenterface.findAll();
	}
	
	@PostMapping(path = "/pojedinacnaStavkaOtpremnice")
	public ResponseEntity<StavkaOtpremniceDTO> pojedinacnaStavkaOtpremnice(@RequestParam("redni_broj_proizvoda") String redniBrojProizvoda) {

		int redniBrojProizvodaInt = Integer.parseInt(redniBrojProizvoda);
		
		StavkaOtpremnice stavkaOtpremnice = stavkaOtpremniceServicenterface.findByRedniBrojProizvoda(redniBrojProizvodaInt);
		
		if(stavkaOtpremnice == null) {
			return new ResponseEntity<StavkaOtpremniceDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<StavkaOtpremniceDTO>(new StavkaOtpremniceDTO(stavkaOtpremnice), HttpStatus.OK);
		}
		
	}
	
	@PostMapping(path = "/dodajStavkuOtpremnice")
	public ResponseEntity<Void> dodajStavkuOtpremnice(@RequestParam("redni_broj_proizvoda") String redniBrojProizvoda,
			@RequestParam("jedinica_mere") String nazivJediniceMere, @RequestParam("cena") String cena,
			@RequestParam("kolicina") String kolicina, @RequestParam("napomena") String napomena, @RequestParam("otpremnica") String brojOtpremnice){
		
		System.out.println("Redni broj proizvoda: " + redniBrojProizvoda);
		System.out.println("Jedinica mere: " + nazivJediniceMere);
		System.out.println("Cena: " + cena);
		System.out.println("Kolicina: " + kolicina);
		System.out.println("Napomena: " + napomena);
		System.out.println("Otpremnica: " + brojOtpremnice);
		
		int redniBrojProizvodaInt = Integer.parseInt(redniBrojProizvoda);
		
	//	JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivJediniceMere);
		
		double cenaDouble = Double.parseDouble(cena);
		double kolicinaDouble = Double.parseDouble(kolicina);
		
		//int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
	//	Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		StavkaOtpremnice stavkaOtpremnice = new StavkaOtpremnice();
		stavkaOtpremnice.setRedniBrojProizvoda(redniBrojProizvodaInt);
		stavkaOtpremnice.setJedinicaMere(nazivJediniceMere);
		stavkaOtpremnice.setCena(cenaDouble);
		stavkaOtpremnice.setKolicina(kolicinaDouble);
		stavkaOtpremnice.setNapomena(napomena);
	//	stavkaOtpremnice.setOtpremnica(otpremnica);
		stavkaOtpremniceServicenterface.save(stavkaOtpremnice);
		
		System.out.println("Dodata je stavka otpremnice.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path =  "/izmeniStavkuOptremnice")
	public ResponseEntity<Void> izmeniStavkuOtpremnice(@RequestParam("redni_broj_proizvoda") String redniBrojProizvoda,
			@RequestParam("novi_broj") String noviBroj,
			@RequestParam("jedinica_mere") String nazivJediniceMere, @RequestParam("cena") String cena,
			@RequestParam("kolicina") String kolicina, @RequestParam("napomena") String napomena, @RequestParam("otpremnica") String brojOtpremnice) {
			
		int redniBrojProizvodaInt = Integer.parseInt(redniBrojProizvoda);
		
		StavkaOtpremnice stavkaOtpremnice = stavkaOtpremniceServicenterface.findByRedniBrojProizvoda(redniBrojProizvodaInt);
		
		int noviBrojInt = Integer.parseInt(noviBroj);
		
		double cenaDouble = Double.parseDouble(cena);
		double kolicinaDouble = Double.parseDouble(kolicina);
		
	//	int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
	//	Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		if(stavkaOtpremnice != null) {
			stavkaOtpremnice.setRedniBrojProizvoda(noviBrojInt);
			stavkaOtpremnice.setJedinicaMere(nazivJediniceMere);
			stavkaOtpremnice.setCena(cenaDouble);
			stavkaOtpremnice.setKolicina(kolicinaDouble);
			stavkaOtpremnice.setNapomena(napomena);
			//stavkaOtpremnice.setOtpremnica(otpremnica);
			stavkaOtpremniceServicenterface.save(stavkaOtpremnice);
			
			System.out.println("Izmenjena je stavka otpremnice.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(path = "/obrisiStavkuOtpremnice")
	public ResponseEntity<Void> obrisiStavkuOtpremnice(@RequestParam("redni_broj_proizvoda") String redniBrojProizvoda) {
		
		int redniBrojProizvodaInt = Integer.parseInt(redniBrojProizvoda);
		
		StavkaOtpremnice stavkaOtpremnice = stavkaOtpremniceServicenterface.findByRedniBrojProizvoda(redniBrojProizvodaInt);
		
		if(stavkaOtpremnice == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		stavkaOtpremniceServicenterface.remove(stavkaOtpremnice.getIdStavkeOtpremnice());
		
		System.out.println("Obrisana je stavka otpremnice");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
