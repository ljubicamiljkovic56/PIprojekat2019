package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.StavkaNarudzbenice;
import projekat.service.intrfc.StavkaNarudzbeniceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkenarudzbenice")
public class StavkaNarudzbeniceController {
	
	@Autowired
	private StavkaNarudzbeniceServiceInterface stavkaNarudzbeniceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<StavkaNarudzbenice> getAll() {
		return stavkaNarudzbeniceServiceInterface.findAll();
	}

	@DeleteMapping(value = "/obrisiStavkuNarudzbenice/{id}")
	private ResponseEntity<Void> obrisiStavkuNarudzbenice(@PathVariable("id") long id) {
		
		StavkaNarudzbenice stavkaNarudzbenice = stavkaNarudzbeniceServiceInterface.findOne(id);
		
		if(stavkaNarudzbenice == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		stavkaNarudzbeniceServiceInterface.remove(stavkaNarudzbenice.getId());
		
		System.out.println("Obrisana je stavka narudzbenice.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
