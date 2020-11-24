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

import projekat.dto.PoslovnaGodinaDTO;
import projekat.model.PoslovnaGodina;
import projekat.model.Preduzece;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/poslovnegodine")
public class PoslovnaGodinaController {
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<PoslovnaGodina> getAll() {
		return poslovnaGodinaServiceInterface.findAll();
	}
	
	@PostMapping(path = "/pojedinacnaGodina")
	public ResponseEntity<PoslovnaGodinaDTO> pojedinacnaGodina(@RequestParam("godina") String godina) {
		
		int godinaInt = Integer.parseInt(godina);
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
		
		if(poslovnaGodina == null) {
			return new ResponseEntity<PoslovnaGodinaDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<PoslovnaGodinaDTO>(new PoslovnaGodinaDTO(poslovnaGodina), HttpStatus.OK);
		}
		
		
	}
	
	@PostMapping(path = "/dodajGodinu")
	public ResponseEntity<Void> dodajGodinu(@RequestParam("godina") String godina, @RequestParam("preduzece") String nazivPreduzeca) {
		
		int godinaInt = Integer.parseInt(godina);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
		poslovnaGodina.setGodina(godinaInt);
		poslovnaGodina.setZakljucena(false);
		poslovnaGodina.setPreduzece(preduzece);
	//	poslovnaGodina.setFakture(poslovnaGodina.getFakture());
		poslovnaGodinaServiceInterface.save(poslovnaGodina);
		
		System.out.println("Dodata je nova poslovna godina.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
	
	@PostMapping(path = "/izmeniGodinu")
	public ResponseEntity<Void> izmeniGodinu(@RequestParam("godina") String godina, @RequestParam("godina2") String godina2,
			@RequestParam("preduzece") String nazivPreduzeca) {
	
		int godinaInt = Integer.parseInt(godina);
		int godinaInt2 = Integer.parseInt(godina2);
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(poslovnaGodina != null) {
			poslovnaGodina.setGodina(godinaInt2);
			poslovnaGodina.setPreduzece(preduzece);
			poslovnaGodina.setZakljucena(false);
			poslovnaGodina.setPreduzece(preduzece);
//			poslovnaGodina.setFakture(poslovnaGodina.getFakture());
			poslovnaGodinaServiceInterface.save(poslovnaGodina);
			
			System.out.println("Izmenjena je poslovna godina.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	
		
	}

	@PostMapping(path = "/obrisiGodinu")
	public ResponseEntity<Void> obrisiGodinu(@RequestParam("godina") String godina) {
		
		int godinaInt = Integer.parseInt(godina);
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
		
		if(poslovnaGodina == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		poslovnaGodinaServiceInterface.remove(poslovnaGodina.getIdGodine());
		
		System.out.println("Obrisana je godina.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
