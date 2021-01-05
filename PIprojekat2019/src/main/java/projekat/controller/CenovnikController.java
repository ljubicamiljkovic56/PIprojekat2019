package projekat.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projekat.model.Cenovnik;
import projekat.model.Preduzece;
import projekat.service.intrfc.CenovnikServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;


@CrossOrigin
@RestController
@RequestMapping(value = "api/cenovnici")
public class CenovnikController {
	
	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<Cenovnik> getAll() {
		return cenovnikServiceInterface.findAll();
	}
	
	
//	@PostMapping(path = "/pojedinacanCenovnik")
//	public ResponseEntity<CenovnikDTO> pojedinacanCenovnik(@RequestParam("datum_vazenja") String datumVazenja) throws ParseException {
//		
//		String datum = datumVazenja;
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = formatter.parse(datum);
//	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		
//		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
//		
//		if(cenovnik == null) {
//			return new ResponseEntity<CenovnikDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<CenovnikDTO>(new CenovnikDTO(cenovnik), HttpStatus.OK);
//		}
//		
//	}

	
	@PostMapping(path = "/dodajCenovnik")
	public ResponseEntity<Void> dodajCenovnik(@RequestParam("datum_vazenja") String datumVazenja,
			@RequestParam("preduzece") String nazivPreduzeca) throws ParseException {
		
		System.out.println("Datum pocetka vazenja: " + datumVazenja);
		
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		Cenovnik cenovnik = new Cenovnik();
		cenovnik.setDatumPocetkaVazenja(sqlDate);
		cenovnik.setPreduzece(preduzece);
		cenovnikServiceInterface.save(cenovnik);
		
		System.out.println("Dodat je novi cenovnik");
		
		return null;
		
	}
	
	@PostMapping(path = "/izmeniCenovnik", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniCenovnik(@RequestParam("id") long id,
			@RequestParam("datum_vazenja") String datumVazenja, 
			@RequestParam("preduzece") String nazivPreduzeca) throws ParseException{
	    
	    Cenovnik cenovnik = cenovnikServiceInterface.findOne(id);
	    
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
	    
	    if(cenovnik != null) {
	    	cenovnik.setIdCenovnika(id);
	    	cenovnik.setDatumPocetkaVazenja(sqlDate);
	    	cenovnik.setPreduzece(preduzece);
	    	cenovnikServiceInterface.save(cenovnik);
	    	
	    	System.out.println("Izmenjen je cenovnik");
	    	
	    	return new ResponseEntity<Void>(HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@DeleteMapping(path = "/obrisiCenovnik/{id}")
	public ResponseEntity<Void> obrisiCenovnik(@PathVariable("id") long id) {
		
		Cenovnik cenovnik = cenovnikServiceInterface.findOne(id);
		
		if(cenovnik == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		cenovnikServiceInterface.remove(cenovnik.getIdCenovnika());
		
		System.out.println("Obrisan je cenovnik");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
