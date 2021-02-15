package projekat.controller;

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
import projekat.model.PoslovnaGodina;
import projekat.model.Preduzece;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
@CrossOrigin
@RestController
@RequestMapping(value = "api/poslovnegodine")
@ControllerAdvice
public class PoslovnaGodinaController {
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<PoslovnaGodina> getAll() {
		return poslovnaGodinaServiceInterface.findAll();
	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<PoslovnaGodina>> getAllPoslovnaGodina(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
       
		Page<PoslovnaGodina> godine = poslovnaGodinaServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(godine.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(godine.getContent());
    }
	
	@GetMapping(path = "/searchByGodina")
	private ResponseEntity<List<PoslovnaGodina>> searchByGodina(@RequestParam("godina") String godinaString,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {

		int godina = Integer.parseInt(godinaString);
		
		Page<PoslovnaGodina> godine = poslovnaGodinaServiceInterface.findAllByGodina(godina, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(godine.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(godine.getContent());
		
	}
	
	
	@PostMapping(path = "/dodajGodinu")
	public ResponseEntity<Void> dodajGodinu(@Validated @RequestParam("godina") String godina, 
			@RequestParam("zakljucena") String zakljucena, 
			@RequestParam("preduzece") String nazivPreduzeca) {
		
		int godinaInt = Integer.parseInt(godina);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(godina == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
		poslovnaGodina.setGodina(godinaInt);
		
		if(zakljucena.equalsIgnoreCase("Da")) {
			poslovnaGodina.setZakljucena(true);
		}else {
			poslovnaGodina.setZakljucena(false);
		}
		
		poslovnaGodina.setPreduzece(preduzece);
		poslovnaGodinaServiceInterface.save(poslovnaGodina);
		
		System.out.println("Dodata je nova poslovna godina.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
	
	@PostMapping(path = "/izmeniGodinu", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniGodinu(@RequestParam("id") long id,
			@RequestParam("godina") String godina, @RequestParam("zakljucena") String zakljucena,
			@RequestParam("preduzece") String nazivPreduzeca) {
	
		int godinaInt = Integer.parseInt(godina);
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findOne(id);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(poslovnaGodina != null) {
			poslovnaGodina.setIdGodine(id);
			poslovnaGodina.setGodina(godinaInt);
			
			if(zakljucena.equalsIgnoreCase("Da")) {
				poslovnaGodina.setZakljucena(true);
			}else {
				poslovnaGodina.setZakljucena(false);
			}
			poslovnaGodina.setPreduzece(preduzece);
			
			poslovnaGodinaServiceInterface.save(poslovnaGodina);
			
			System.out.println("Izmenjena je poslovna godina.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	
		
	}

	@DeleteMapping(path = "/obrisiGodinu/{id}")
	public ResponseEntity<Void> obrisiGodinu(@PathVariable("id") long id) {
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findOne(id);
		
		if(poslovnaGodina == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		poslovnaGodinaServiceInterface.remove(poslovnaGodina.getIdGodine());
		
		System.out.println("Obrisana je godina.");
		
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