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

import projekat.dto.CenovnikDTO;
import projekat.model.Cenovnik;
import projekat.service.intrfc.CenovnikServiceInterface;


@CrossOrigin
@RestController
@RequestMapping(value = "api/cenovnici")
public class CenovnikController {
	
	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<Cenovnik> getAll() {
		return cenovnikServiceInterface.findAll();
	}
	
	
	@PostMapping(path = "/pojedinacanCenovnik")
	public ResponseEntity<CenovnikDTO> pojedinacanCenovnik(@RequestParam("datum_vazenja") String datumVazenja) throws ParseException {
		
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
		
		if(cenovnik == null) {
			return new ResponseEntity<CenovnikDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<CenovnikDTO>(new CenovnikDTO(cenovnik), HttpStatus.OK);
		}
		
	}

	
	@PostMapping(path = "/dodajCenovnik")
	public ResponseEntity<Void> dodajCenovnik(@RequestParam("datum_vazenja") String datumVazenja) throws ParseException {
		
		System.out.println("Datum pocetka vazenja: " + datumVazenja);
		
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		
		Cenovnik cenovnik = new Cenovnik();
		cenovnik.setDatumPocetkaVazenja(sqlDate);
		cenovnik.setStavkeCenovnika(cenovnik.getStavkeCenovnika());
		cenovnikServiceInterface.save(cenovnik);
		
		System.out.println("Dodat je novi cenovnik");
		
		return null;
		
	}
	
	@PostMapping(path = "/izmeniCenovnik")
	public ResponseEntity<Void> izmeniCenovnik(@RequestParam("datum_vazenja") String datumVazenja, @RequestParam("novi_datum") String noviDatum) throws ParseException{
		
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    String datum2 = noviDatum;
	    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date date2 = formatter2.parse(datum2);
	    java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
	    
	    Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
	    
	    if(cenovnik != null) {
	    	cenovnik.setDatumPocetkaVazenja(sqlDate2);
	    	cenovnik.setStavkeCenovnika(cenovnik.getStavkeCenovnika());
	    	cenovnikServiceInterface.save(cenovnik);
	    	
	    	System.out.println("Izmenjen je cenovnik");
	    	
	    	return new ResponseEntity<Void>(HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@PostMapping(path = "/obrisiCenovnik")
	public ResponseEntity<Void> obrisiCenovnik(@RequestParam("datum_vazenja") String datumVazenja) throws ParseException {
		
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
		
		if(cenovnik == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		cenovnikServiceInterface.remove(cenovnik.getIdCenovnika());
		
		System.out.println("Obrisan je cenovnik");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
