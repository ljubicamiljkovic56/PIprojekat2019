package projekat.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import projekat.model.GrupaRobeUsluga;
import projekat.model.JedinicaMere;
import projekat.model.RobaUsluga;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;
import projekat.service.intrfc.JedinicaMereServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/roba")
@ControllerAdvice
public class RobaUslugaController {

	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Autowired
	private GrupaRobeUslugaServiceInterface grupaRobeUslugaServiceInterface;
	
	@Autowired
	private JedinicaMereServiceInterface jedinicaMereServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<RobaUsluga> getAll(){
		return robaUslugaServiceInterface.findAll();
	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<RobaUsluga>> getAllRobaUsluga(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) {
       
		Page<RobaUsluga> roba = robaUslugaServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(roba.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(roba.getContent());
    }
	
	@GetMapping(path = "/searchByNaziv")
	private ResponseEntity<List<RobaUsluga>> searchByNaziv(@RequestParam("naziv") String nazivRobeUsluge,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {

		Page<RobaUsluga> roba = robaUslugaServiceInterface.findAllByNazivRobeUsluge(nazivRobeUsluge, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(roba.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(roba.getContent());
		
	}
	
	@PostMapping(path = "/dodajRobu")
	public ResponseEntity<Void> dodajRobu(@RequestParam("naziv_robe") String nazivRobe, 
			@RequestParam("opis") String opis, @RequestParam("roba") String roba,
			@RequestParam("naziv_mere") String nazivMere, @RequestParam("naziv_grupe") String nazivGrupe) {
		
		GrupaRobeUsluga grupa = grupaRobeUslugaServiceInterface.findByNazivGrupe(nazivGrupe);
		GrupaRobeUsluga grupa2 = grupaRobeUslugaServiceInterface.findOne(grupa.getIdGrupe());
		
		JedinicaMere mera = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivMere);
		JedinicaMere mera2 = jedinicaMereServiceInterface.findOne(mera.getIdJediniceMere());
		
		if(nazivRobe == null || grupa == null || mera == null || grupa2 == null || mera2 == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
		RobaUsluga robaUsluga = new RobaUsluga();
		robaUsluga.setNazivRobeUsluge(nazivRobe);
		robaUsluga.setOpis(opis);
		
		if(roba.equalsIgnoreCase("Da")) {
			robaUsluga.setRoba(true);
		}else {
			robaUsluga.setRoba(false);
		}
		
		robaUsluga.setJedinicaMere(mera2);
		robaUsluga.setGrupaRobeUsluga(grupa2);
		robaUslugaServiceInterface.save(robaUsluga);
		
		System.out.println("Dodata je nova roba");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniRobu", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniRobu(@RequestParam("id") long id, @RequestParam("naziv_robe") String nazivRobe, 
			@RequestParam("opis") String opis, @RequestParam("roba") String roba, @RequestParam("naziv_mere") String nazivMere, 
			@RequestParam("naziv_grupe") String nazivGrupe) {
	
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findOne(id);
		
		JedinicaMere mera = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivMere);
		
		GrupaRobeUsluga grupa = grupaRobeUslugaServiceInterface.findByNazivGrupe(nazivGrupe);
			
		if(roba != null) {
			robaUsluga.setIdRobeUsluge(id);
			robaUsluga.setNazivRobeUsluge(nazivRobe);
			robaUsluga.setOpis(opis);
		
			if(roba.equalsIgnoreCase("Da")) {
				robaUsluga.setRoba(true);
			}else {
				robaUsluga.setRoba(false);
			}
			
			robaUsluga.setJedinicaMere(mera);
			robaUsluga.setGrupaRobeUsluga(grupa);
			robaUslugaServiceInterface.save(robaUsluga);
			
			System.out.println("Izmena robe");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@DeleteMapping(path = "/obrisiRobu/{id}")
	public ResponseEntity<Void> obrisiRobu(@PathVariable("id") long id) {
		
		RobaUsluga roba = robaUslugaServiceInterface.findOne(id);
		
		if(roba == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		robaUslugaServiceInterface.remove(roba.getIdRobeUsluge());
		
		System.out.println("Obrisana je roba");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Void> handleNullPointer() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
