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
import projekat.model.JedinicaMere;
import projekat.service.intrfc.JedinicaMereServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/jedinicemere")
@ControllerAdvice
public class JedinicaMereController {
	
	@Autowired
	private JedinicaMereServiceInterface jedinicaMereServiceInterface;
	
	@GetMapping(path = "/all")
	public List<JedinicaMere> getAll(){
		return jedinicaMereServiceInterface.findAll();
	}
	
//	@GetMapping(path = "/pag")
//	public ResponseEntity<List<JedinicaMereDTO>> getJediniceMerePage(Pageable page) {
//		Page<JedinicaMere> jedinice =  jedinicaMereServiceInterface.findAll(page);
//		
//		List<JedinicaMereDTO> jediniceDTO = new ArrayList<>();
//		for (JedinicaMere jedinica : jedinice) {
//			jediniceDTO.add(new JedinicaMereDTO(jedinica));
//		}
//		
//		return new ResponseEntity<>(jediniceDTO, HttpStatus.OK);
//	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<JedinicaMere>> getAllJedinicaMere(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
       
		Page<JedinicaMere> jediniceMere = jedinicaMereServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(jediniceMere.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(jediniceMere.getContent());
    }
	
	@GetMapping(path = "/searchByNaziv/{naziv}")
	private ResponseEntity<Void> searchByNaziv(@RequestParam("naziv") String nazivJediniceMere) {
		
		if(nazivJediniceMere == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
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
