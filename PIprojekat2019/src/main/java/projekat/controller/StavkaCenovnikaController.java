package projekat.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import projekat.dto.StavkaCenovnikaDTO;
import projekat.model.Cenovnik;
import projekat.model.RobaUsluga;
import projekat.model.StavkaCenovnika;
import projekat.service.intrfc.CenovnikServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;
import projekat.service.intrfc.StavkaCenovnikaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkecenovnika")
public class StavkaCenovnikaController {

	
	@Autowired
	private StavkaCenovnikaServiceInterface stavkaCenovnikaServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	
	@GetMapping(path = "/all")
	public List<StavkaCenovnika> getAll(){
		return stavkaCenovnikaServiceInterface.findAll();
	}
	
//	@PostMapping(path = "/pojedinacnaStavkaCenovnika")
//	public ResponseEntity<StavkaCenovnikaDTO> pojedinacnaStavkaCenovnika(@RequestParam("cena") String cena) {
//		
//		double cenaDouble = Double.parseDouble(cena);
//		
//		StavkaCenovnika stavkaCenovnika = stavkaCenovnikaServiceInterface.findByCena(cenaDouble);
//		
//		if(stavkaCenovnika == null) {
//			return new ResponseEntity<StavkaCenovnikaDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<StavkaCenovnikaDTO>(new StavkaCenovnikaDTO(stavkaCenovnika), HttpStatus.OK);
//		}
//	}
//	
	@PostMapping(path = "/dodajStavkuCenovnika")
	public ResponseEntity<Void> dodajStavkuCenovnika(@RequestParam("cena") String cena, @RequestParam("roba") String nazivRobe,
			@RequestParam("datum_vazenja") String datumVazenjaCenovnika) throws ParseException {
		
		
		System.out.println("Cena: " + cena);
		System.out.println("Naziv robe: " + nazivRobe);
		System.out.println("Datum vazenja: " + datumVazenjaCenovnika);
		
		double cenaDouble = Double.parseDouble(cena);
		
		String datum = datumVazenjaCenovnika;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
		
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findByNazivRobeUsluge(nazivRobe);
		
		StavkaCenovnika stavkaCenovnika = new StavkaCenovnika();
		stavkaCenovnika.setCena(cenaDouble);
		stavkaCenovnika.setCenovnik(cenovnik);
		stavkaCenovnika.setRobaUsluga(robaUsluga);
		
		stavkaCenovnikaServiceInterface.save(stavkaCenovnika);
		
		
		System.out.println("Dodata je stavka cenovnika");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/izmeniStavkuCenovnika")
	public ResponseEntity<Void> izmeniStavkuCenovnika(@RequestParam("cena") String cena, @RequestParam("nova_cena") String novaCena,
			@RequestParam("roba") String nazivRobe,
			@RequestParam("datum_vazenja") String datumVazenjaCenovnika) throws ParseException {
		

		double cenaDouble = Double.parseDouble(cena);
		double novaCenaDouble = Double.parseDouble(novaCena);
		
		String datum = datumVazenjaCenovnika;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
	    
		StavkaCenovnika stavkaCenovnika = stavkaCenovnikaServiceInterface.findByCena(cenaDouble);
		
		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findByNazivRobeUsluge(nazivRobe);
		
		if(stavkaCenovnika != null) {
			stavkaCenovnika.setCena(novaCenaDouble);
			stavkaCenovnika.setCenovnik(cenovnik);
			stavkaCenovnika.setRobaUsluga(robaUsluga);
			stavkaCenovnikaServiceInterface.save(stavkaCenovnika);
			
			
			System.out.println("Izmenjena je stavka cenovnika.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(path = "/obrisiStavkuCenovnika") 
	public ResponseEntity<Void> obrisiStavkuCenovnika(@RequestParam("cena") String cena) {
		
		double cenaDouble = Double.parseDouble(cena);
		
		StavkaCenovnika stavkaCenovnika = stavkaCenovnikaServiceInterface.findByCena(cenaDouble);
		
		if(stavkaCenovnika == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		stavkaCenovnikaServiceInterface.remove(stavkaCenovnika.getIdStavke());
		
		System.out.println("Obrisana je stavka cenovnika.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
