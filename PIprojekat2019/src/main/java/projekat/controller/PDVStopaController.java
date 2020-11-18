package projekat.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import projekat.dto.PDVStopaDTO;
import projekat.model.PDVStopa;
import projekat.service.intrfc.PDVStopaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/pdvstope")
public class PDVStopaController {
	
	@Autowired
	private PDVStopaServiceInterface pdvStopaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<PDVStopa> getAll(){
		return pdvStopaServiceInterface.findAll();
	}
	
	@PostMapping(value = "/pojedinacnaPDVStopa")
	public ResponseEntity<PDVStopaDTO> pojedinacnaPDVStopa(@RequestParam("procenat") String procenat) {
		
		double procenatDouble = Double.parseDouble(procenat);
		
		PDVStopa pdvStopa = pdvStopaServiceInterface.findByProcenat(procenatDouble);
		
		if(pdvStopa == null) {
			return new ResponseEntity<PDVStopaDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<PDVStopaDTO>(new PDVStopaDTO(pdvStopa), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/dodajPDVStopu")
	public ResponseEntity<Void> dodajPDVStopu(@RequestParam("procenat") String procenat, @RequestParam("datum_vazenja") String datumVazenja) throws ParseException {
		
		double procenatDouble = Double.parseDouble(procenat);
		String datum = datumVazenja;
		
		System.out.println("Procenat: " + procenat);
		
		PDVStopa pdvStopa = new PDVStopa();
		pdvStopa.setProcenat(procenatDouble);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pdvStopa.setDatumVazenja(sqlDate);
		pdvStopaServiceInterface.save(pdvStopa);
		
		System.out.println("Dodata je nova pdv stopa.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/izmeniPDVStopu")
	public ResponseEntity<Void> izmeniPDVStopu(@RequestParam("procenat") String procenat, @RequestParam("novi_procenat") String novi_procenat,
			@RequestParam("datum_vazenja") String datumVazenja) throws ParseException {
		
		double procenatDouble = Double.parseDouble(procenat);
		double noviProcenatDouble = Double.parseDouble(novi_procenat);
		String datum = datumVazenja;
		
		PDVStopa pdvStopa = pdvStopaServiceInterface.findByProcenat(procenatDouble);
		
		if(pdvStopa != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = formatter.parse(datum);
		    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pdvStopa.setDatumVazenja(sqlDate);
			pdvStopa.setProcenat(noviProcenatDouble);
			pdvStopaServiceInterface.save(pdvStopa);
			
			System.out.println("Izmena pdv stope.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(value = "/obrisiPDVStopu")
	public ResponseEntity<Void> obrisiPDVStopu(@RequestParam("procenat") String procenat) {
		
		double procenatDouble = Double.parseDouble(procenat);
		
		PDVStopa pdvStopa = pdvStopaServiceInterface.findByProcenat(procenatDouble);
		
		if(pdvStopa == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		pdvStopaServiceInterface.remove(pdvStopa.getIdStope());
		
		System.out.println("Obrisana pdv stopa.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
