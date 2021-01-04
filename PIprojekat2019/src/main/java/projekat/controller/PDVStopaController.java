package projekat.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.PDVKategorija;
import projekat.model.PDVStopa;
import projekat.service.intrfc.PDVKategorijaServiceInterface;
import projekat.service.intrfc.PDVStopaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/pdvstope")
public class PDVStopaController {
	
	@Autowired
	private PDVStopaServiceInterface pdvStopaServiceInterface;
	
	@Autowired
	private PDVKategorijaServiceInterface pdvKategorijaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<PDVStopa> getAll(){
		return pdvStopaServiceInterface.findAll();
	}
	
//	@PostMapping(value = "/pojedinacnaPDVStopa")
//	public ResponseEntity<PDVStopaDTO> pojedinacnaPDVStopa(@RequestParam("procenat") String procenat) {
//		
//		double procenatDouble = Double.parseDouble(procenat);
//		
//		PDVStopa pdvStopa = pdvStopaServiceInterface.findByProcenat(procenatDouble);
//		
//		if(pdvStopa == null) {
//			return new ResponseEntity<PDVStopaDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<PDVStopaDTO>(new PDVStopaDTO(pdvStopa), HttpStatus.OK);
//		}
//	}
	
	@PostMapping(value = "/dodajPDVStopu")
	public ResponseEntity<Void> dodajPDVStopu(@Validated @RequestParam("datum_vazenja") String datumVazenja, @RequestParam("procenat") String procenat, 
			@RequestParam("pdvKategorija") String nazivKategorije) throws ParseException {
		
		double procenatDouble = Double.parseDouble(procenat);
		String datum = datumVazenja;
		
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findByNazivKategorije(nazivKategorije);
	
		PDVKategorija pdvKategorija2 = pdvKategorijaServiceInterface.findOne(pdvKategorija.getIdKategorije());
		
		System.out.println("Procenat: " + procenat);
		System.out.println("Datum: " + datum);
		System.out.println("Naziv pdv kategorije: " + nazivKategorije);
		
		PDVStopa pdvStopa = new PDVStopa();
		pdvStopa.setProcenat(procenatDouble);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pdvStopa.setDatumVazenja(sqlDate);
		pdvStopa.setPdvKategorija(pdvKategorija2);
		pdvStopaServiceInterface.save(pdvStopa);
		
		System.out.println("Dodata je nova pdv stopa.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/izmeniPDVStopu", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniPDVStopu(@RequestParam("id") long id, @RequestParam("datum_vazenja") String datumVazenja,
			@RequestParam("procenat") String procenat, @RequestParam("pdvKategorija") String nazivKategorije) throws ParseException {
		
		PDVStopa pdvStopa = pdvStopaServiceInterface.findOne(id);
		
		double procenatDouble = Double.parseDouble(procenat);
		String datum = datumVazenja;
		
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findByNazivKategorije(nazivKategorije);
		
		PDVKategorija pdvKategorija2 = pdvKategorijaServiceInterface.findOne(pdvKategorija.getIdKategorije());

		if(pdvStopa != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = formatter.parse(datum);
		    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		    pdvStopa.setIdStope(id);
			pdvStopa.setDatumVazenja(sqlDate);
			pdvStopa.setProcenat(procenatDouble);
			pdvStopa.setPdvKategorija(pdvKategorija2);
			pdvStopaServiceInterface.save(pdvStopa);
			
			System.out.println("Izmena pdv stope.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@DeleteMapping(value = "/obrisiPDVStopu/{id}")
	public ResponseEntity<Void> obrisiPDVStopu(@PathVariable("id") long id) {
		
		PDVStopa pdvStopa = pdvStopaServiceInterface.findOne(id);
		
		if(pdvStopa == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		pdvStopaServiceInterface.remove(pdvStopa.getIdStope());
		
		System.out.println("Obrisana pdv stopa.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
