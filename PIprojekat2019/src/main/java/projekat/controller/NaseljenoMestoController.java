package projekat.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
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
import projekat.service.intrfc.NaseljenoMestoServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/mesto")
@ControllerAdvice
public class NaseljenoMestoController {

	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<NaseljenoMesto> getAll() {
		return naseljenoMestoServiceInterface.findAll();
	}
	
	@PostMapping(path = "/dodajMesto")
	public ResponseEntity<Void> dodajMesto(@Validated @RequestParam("naziv_mesta") String nazivMesta, @RequestParam("ptt_broj") String pttBroj) {
		
		System.out.println("Naziv naseljenog mesta: " + nazivMesta);
		System.out.println("Ptt broj naseljnog mesta: " + pttBroj);
		
		if(nazivMesta == null || pttBroj == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		int pttBrojInt = Integer.parseInt(pttBroj);
			
		NaseljenoMesto mesto = new NaseljenoMesto();
		mesto.setNazivMesta(nazivMesta);
		mesto.setPttBroj(pttBrojInt);
		naseljenoMestoServiceInterface.save(mesto);
		
		System.out.println("Dodato je naseljeno mesto.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/izmeniMesto", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniMesto(@RequestParam("id") long id, @RequestParam("naziv_mesta") String nazivMesta,
			@RequestParam("ptt_broj") String pttBroj) {
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findOne(id);
		
		int pttBrojInt = Integer.parseInt(pttBroj);
		
		if(mesto != null) {
			mesto.setIdMesta(id);
			mesto.setNazivMesta(nazivMesta);
			mesto.setPttBroj(pttBrojInt);
			naseljenoMestoServiceInterface.save(mesto);
			
			System.out.println("Izmenjeno je naseljeno mesto");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value = "/obrisiMesto/{id}")
	public ResponseEntity<Void> obrisiMesto(@PathVariable("id") long id){
		
		NaseljenoMesto naseljenoMesto = naseljenoMestoServiceInterface.findOne(id);
		
		if(naseljenoMesto == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		naseljenoMestoServiceInterface.remove(naseljenoMesto.getIdMesta());
		
		System.out.println("Obrisano je mesto");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
