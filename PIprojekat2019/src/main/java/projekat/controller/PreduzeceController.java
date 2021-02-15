package projekat.controller;

import java.text.ParseException;
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
import projekat.model.NaseljenoMesto;
import projekat.model.Preduzece;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/preduzece")
@ControllerAdvice
public class PreduzeceController {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<Preduzece> getAll() {
		return preduzeceServiceInterface.findAll();
	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<Preduzece>> getAllPreduzece(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
       
		Page<Preduzece> preduzeca = preduzeceServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(preduzeca.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(preduzeca.getContent());
    }
	
	@GetMapping(path = "/searchByNaziv")
	private ResponseEntity<List<Preduzece>> searchByNaziv(@RequestParam("naziv") String nazivPreduzeca,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {

		Page<Preduzece> preduzeca = preduzeceServiceInterface.findAllByNazivPreduzeca(nazivPreduzeca, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(preduzeca.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(preduzeca.getContent());
		
	}
	
	@GetMapping(path = "/searchByAdresa")
	private ResponseEntity<List<Preduzece>> searchByAdresa(@RequestParam("adresa") String adresa,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {

		Page<Preduzece> preduzeca = preduzeceServiceInterface.findAllByAdresa(adresa, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(preduzeca.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(preduzeca.getContent());
		
	}
	
	@PostMapping(path = "/dodajPreduzece")
	public ResponseEntity<Void> dodajPreduzece(@Validated @RequestParam("naziv_preduzeca") String nazivPreduzeca,
			@RequestParam("adresa_preduzeca") String adresa, @RequestParam("broj_telefona") String brojTelefona, @RequestParam("fax_preduzeca") String fax,
			@RequestParam("naziv_mesta") String nazivMesta) throws ParseException {

		NaseljenoMesto naseljenoMesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		if(nazivPreduzeca == null || adresa == null || brojTelefona == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		Preduzece preduzece = new Preduzece();
		preduzece.setNazivPreduzeca(nazivPreduzeca);
		preduzece.setAdresa(adresa);
		preduzece.setBrojTelefona(brojTelefona);
		preduzece.setFax(fax);
		preduzece.setNaseljenoMesto(naseljenoMesto);
		preduzeceServiceInterface.save(preduzece);
		
		System.out.println("Dodato je novo preduzece");
				
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniPreduzece", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniPreduzece(@RequestParam("id") long id,
			@RequestParam("naziv_preduzeca") String nazivPreduzeca,
			@RequestParam("adresa_preduzeca") String adresa,
			@RequestParam("broj_telefona") String brojTelefona, @RequestParam("fax_preduzeca") String fax,
			@RequestParam("naziv_mesta") String nazivMesta) throws ParseException {
		
	
		Preduzece preduzece = preduzeceServiceInterface.findOne(id);
		
		NaseljenoMesto naseljenoMesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		if(preduzece != null) {
			preduzece.setIdPreduzeca(id);
			preduzece.setNazivPreduzeca(nazivPreduzeca);
			preduzece.setAdresa(adresa);
			preduzece.setBrojTelefona(brojTelefona);
			preduzece.setFax(fax);
			preduzece.setNaseljenoMesto(naseljenoMesto);
			preduzeceServiceInterface.save(preduzece);
			
			System.out.println("Izmenjeno je preduzece.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	
		
	}
	
	@DeleteMapping(path = "/obrisiPreduzece/{id}")
	public ResponseEntity<Void> obrisiPreduzece(@PathVariable("id") long id) {
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(id);
		
		if(preduzece == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		preduzeceServiceInterface.remove(preduzece.getIdPreduzeca());
		
		System.out.println("Obrisano preduzece.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}