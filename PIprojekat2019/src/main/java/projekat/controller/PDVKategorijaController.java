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
import projekat.model.PDVKategorija;
import projekat.service.intrfc.PDVKategorijaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/pdvkategorije")
@ControllerAdvice
public class PDVKategorijaController {
	
	@Autowired
	private PDVKategorijaServiceInterface pdvKategorijaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<PDVKategorija> getAll(){
		return pdvKategorijaServiceInterface.findAll();
	}

	@GetMapping(path = "/p")
    public ResponseEntity<List<PDVKategorija>> getAllPDVKategorija(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
		Page<PDVKategorija> pdvKategorije = pdvKategorijaServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(pdvKategorije.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(pdvKategorije.getContent());
    }
	
	@PostMapping(value = "/dodajKategoriju")
	public ResponseEntity<Void> dodajKategoriju(@Validated @RequestParam("naziv_kategorije") String nazivKategorije) {
		
		if(nazivKategorije == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("Naziv kategorije: " + nazivKategorije);
		
		PDVKategorija pdvKategorija = new PDVKategorija();
		pdvKategorija.setNazivKategorije(nazivKategorije);
		pdvKategorija.setPdvStope(null);
		pdvKategorijaServiceInterface.save(pdvKategorija);
		
		System.out.println("Dodata je nova kategorija");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/izmeniKategoriju", consumes =  "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniKategoriju(@RequestParam("id") long id, @Validated @RequestParam("naziv_kategorije") String nazivKategorije) {
		
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findOne(id);
		
		if(nazivKategorije == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		if(pdvKategorija != null) {
			pdvKategorija.setIdKategorije(id);
			pdvKategorija.setNazivKategorije(nazivKategorije);
			pdvKategorijaServiceInterface.save(pdvKategorija);
			
			System.out.println("Izmenjena pdv kategorija");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value = "/obrisiKategoriju/{id}")
	public ResponseEntity<Void> obrisiKategoriju(@PathVariable("id") long id) {
		
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findOne(id);
		
		if(pdvKategorija == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		pdvKategorijaServiceInterface.remove(pdvKategorija.getIdKategorije());
		
		System.out.println("Obrisana je pdv kategorija");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}