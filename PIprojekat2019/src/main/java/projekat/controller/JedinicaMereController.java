package projekat.controller;

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

import projekat.dto.JedinicaMereDTO;
import projekat.model.JedinicaMere;
import projekat.service.intrfc.JedinicaMereServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/jedinicemere")
public class JedinicaMereController {
	
	@Autowired
	private JedinicaMereServiceInterface jedinicaMereServiceInterface;
	
	@GetMapping(path = "/all")
	public List<JedinicaMere> getAll(){
		return jedinicaMereServiceInterface.findAll();
	}
	
	@PostMapping(value = "/pojedinacnaJedinicaMere")
	public ResponseEntity<JedinicaMereDTO> pojedinacnaJedinicaMere(@RequestParam("naziv_jedinice_mere") String nazivJediniceMere) {
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivJediniceMere);
		
		if(jedinicaMere == null) {
			return new ResponseEntity<JedinicaMereDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<JedinicaMereDTO>(new JedinicaMereDTO(jedinicaMere), HttpStatus.OK);
		}
		
	}
	
	@PostMapping(value = "/dodajJedinicuMere")
	private ResponseEntity<Void> dodajJedinicuMere(@RequestParam("naziv_jedinice_mere") String nazivJediniceMere, @RequestParam("skraceni_naziv") String skraceniNaziv){
		
		System.out.println("Naziv jedinice mere: " + nazivJediniceMere);
		System.out.println("Skraceni naziv: " + skraceniNaziv);
		
		JedinicaMere jedinicaMere = new JedinicaMere();
		jedinicaMere.setNazivJediniceMere(nazivJediniceMere);
		jedinicaMere.setSkraceniNaziv(skraceniNaziv);
		jedinicaMereServiceInterface.save(jedinicaMere);
		
		System.out.println("Dodata je nova jedinica mere");

		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/izmeniJedinicuMere")
	private ResponseEntity<Void> izmeniJedinicuMere(@RequestParam("naziv_jedinice_mere") String nazivJediniceMere, 
			@RequestParam("novi_naziv") String noviNaziv, 
			@RequestParam("skraceni_naziv") String skraceniNaziv) {
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivJediniceMere);
		
		if(jedinicaMere != null) {
			jedinicaMere.setNazivJediniceMere(noviNaziv);
			jedinicaMere.setSkraceniNaziv(skraceniNaziv);
			jedinicaMereServiceInterface.save(jedinicaMere);
			
			System.out.println("Izmena jedinice mere");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
					
	}
	
	@PostMapping(value = "/obrisiJedinicuMere")
	private ResponseEntity<Void> obrisiJedinicuMere(@RequestParam("naziv_jedinice_mere") String nazivJediniceMere) {
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivJediniceMere);
		
		if(jedinicaMere == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		jedinicaMereServiceInterface.remove(jedinicaMere.getIdJediniceMere());
		
		System.out.println("Obrisana je jedinica mere");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
		
	
}
