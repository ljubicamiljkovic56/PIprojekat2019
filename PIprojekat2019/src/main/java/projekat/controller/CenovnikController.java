package projekat.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import projekat.model.Cenovnik;
import projekat.model.Preduzece;
import projekat.model.StavkaCenovnika;
import projekat.service.intrfc.CenovnikServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.StavkaCenovnikaServiceInterface;


@CrossOrigin
@RestController
@RequestMapping(value = "api/cenovnici")
@ControllerAdvice
public class CenovnikController {
	
	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private StavkaCenovnikaServiceInterface stavkaCenovnikaServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<Cenovnik> getAll() {
		return cenovnikServiceInterface.findAll();
	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<Cenovnik>> getAllCenovnik(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
       
		Page<Cenovnik> cenovnici = cenovnikServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(cenovnici.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(cenovnici.getContent());
    }
	
	@PostMapping(path = "/dodajCenovnik")
	public ResponseEntity<Void> dodajCenovnik(@Validated @RequestParam("datum_vazenja") String datumVazenja,
			@RequestParam("preduzece") String nazivPreduzeca) throws ParseException {
		
		System.out.println("Datum pocetka vazenja: " + datumVazenja);
		
		String datum = datumVazenja;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
	    
	    if(datumVazenja == null || nazivPreduzeca == null) {
	    	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	    }
		
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
	
	@PostMapping(value = "/kopirajCenovnik")
	public ResponseEntity<Void> kopirajCenovnik(@RequestParam("datum_vazenja") String datumVazenjaString) throws ParseException{
		
		String datum = datumVazenjaString;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	    Cenovnik cenovnik1 = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
	    Cenovnik cenovnik = cenovnikServiceInterface.findOne(cenovnik1.getIdCenovnika());
	    
	    if(cenovnik != null) {
	    	Cenovnik cenovnikCopy = new Cenovnik();
	    	cenovnikCopy.setDatumPocetkaVazenja(cenovnik.getDatumPocetkaVazenja());
	    	cenovnikCopy.setPreduzece(cenovnik.getPreduzece());
	    	
	    	List<StavkaCenovnika> stavkeCenovnika = cenovnik.getStavkeCenovnika();
			
			for(StavkaCenovnika stavkaCenovnika : stavkeCenovnika) {
				StavkaCenovnika novaStavka = new StavkaCenovnika();
				novaStavka.setCena(stavkaCenovnika.getCena());
				novaStavka.setCenovnik(stavkaCenovnika.getCenovnik());
				novaStavka.setRobaUsluga(stavkaCenovnika.getRobaUsluga());
				
				cenovnikCopy.getStavkeCenovnika().add(novaStavka);
				stavkaCenovnikaServiceInterface.save(novaStavka);
			}
			
			cenovnikServiceInterface.save(cenovnikCopy);
	    	//cenovnikCopy.setStavkeCenovnika(stavkeCenovnika);
	    	
	    }
	    
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ParseException.class)
	public ResponseEntity<Void> handleParse() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}