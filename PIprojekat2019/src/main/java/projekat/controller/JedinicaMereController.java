package projekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
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

import projekat.model.JedinicaMere;
import projekat.service.intrfc.JedinicaMereServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/jedinicemere")
@ControllerAdvice
public class JedinicaMereController {
	
	@Autowired
	private JedinicaMereServiceInterface jedinicaMereServiceInterface;
	
//	@Autowired
//	private JedinicaMereService jedinicaMereService;
//	
//	@Autowired
//	private JedinicaMereToJedinicaMereDTO toJedinicaMereDTO;
//	
//	@Autowired
//	private JedinicaMereDTOtoJedinicaMere toJedinicaMere;
//	
	
	@GetMapping(path = "/all")
	public List<JedinicaMere> getAll(){
		return jedinicaMereServiceInterface.findAll();
	}
	
	@GetMapping(path = "/searchByNaziv/{naziv}")
	private ResponseEntity<Void> searchByNaziv(@RequestParam("naziv") String nazivJediniceMere) {
		
		List<JedinicaMere> jediniceMere = new ArrayList<JedinicaMere>();
		
		if(nazivJediniceMere == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	//	JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivJediniceMere);
		
	//	System.out.println(jedinicaMere);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", path = "/saveJedinicaMere")
//	public ResponseEntity<JedinicaMereDTO> saveJedinicaMere(@Validated @RequestBody JedinicaMereDTO jedinicaMereDTO) {
//		
//		System.out.println("Dodajem novu jedinicu mere...");
//		System.out.println(jedinicaMereDTO.toString());
//		JedinicaMere konvertovano = toJedinicaMere.convert(jedinicaMereDTO);
//		System.out.println("Konvertovano "+ konvertovano + " " + konvertovano.getNazivJediniceMere()+ " " +konvertovano.getSkraceniNaziv());
//		
//		JedinicaMere jedinicaMere = jedinicaMereService.save(toJedinicaMere.convert(jedinicaMereDTO));
//		
//		System.out.println("Naziv jedinicaMereDTO: " + jedinicaMereDTO.getNazivJediniceMere());
//		System.out.println("Skraceni naziv: " + jedinicaMereDTO.getSkraceniNaziv());
//		System.out.println(jedinicaMere);
//		System.out.println("Naziv jedinicaMere: " + jedinicaMere.getNazivJediniceMere());
//		System.out.println("Skraceni naziv: " + jedinicaMere.getSkraceniNaziv());
//		
//		return new ResponseEntity<>(toJedinicaMereDTO.convert(jedinicaMere), HttpStatus.OK);
//	}
//	
	
	//moj nacin slanja, bez converter klasa
	@PostMapping(value = "/dodajJedinicuMere")
	private ResponseEntity<Void> dodajJedinicuMere(@RequestParam(name = "naziv_jedinice_mere") String nazivJediniceMere, 
			@RequestParam(name = "skraceni_naziv") String skraceniNaziv){
		
		if(nazivJediniceMere == null || skraceniNaziv == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("Naziv jedinice mere: " + nazivJediniceMere);
		System.out.println("Skraceni naziv: " + skraceniNaziv);
		
		JedinicaMere jedinicaMere = new JedinicaMere();
		jedinicaMere.setNazivJediniceMere(nazivJediniceMere);
		jedinicaMere.setSkraceniNaziv(skraceniNaziv);
		jedinicaMereServiceInterface.save(jedinicaMere);
		
		System.out.println("Dodata je nova jedinica mere");

		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	@PostMapping(value = "/izmeniJedinicuMere/", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	private ResponseEntity<Void> izmeniJedinicuMere(@RequestParam("id") long id,
			@Validated @RequestParam("naziv_jedinice_mere") String naziv,
			@RequestParam("skraceni_naziv") String skraceniNaziv) {
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findOne(id);
		
		if(jedinicaMere != null) {
			jedinicaMere.setIdJediniceMere(id);
			jedinicaMere.setNazivJediniceMere(naziv);
			jedinicaMere.setSkraceniNaziv(skraceniNaziv);
			jedinicaMereServiceInterface.save(jedinicaMere);
			
			System.out.println("Izmena jedinice mere");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", path = "/saveJedinicaMere")
//	private ResponseEntity<JedinicaMere> saveJedinicaMere(@RequestBody JedinicaMere jedinicaMere) {
//		
//		JedinicaMere novaJedinica = jedinicaMereServiceInterface.save(jedinicaMere);
//		
//		return new ResponseEntity<JedinicaMere>(novaJedinica, HttpStatus.OK);
//	}

	@DeleteMapping(value = "/obrisiJedinicuMere/{id}")
	private ResponseEntity<Void> obrisiJedinicuMere(@PathVariable("id") long id){
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findOne(id);
		
		if(jedinicaMere == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		jedinicaMereServiceInterface.remove(jedinicaMere.getIdJediniceMere());
		
		System.out.println("Obrisana je jedinica mere");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
