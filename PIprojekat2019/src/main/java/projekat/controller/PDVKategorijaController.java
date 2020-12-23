package projekat.controller;


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
import projekat.service.intrfc.PDVKategorijaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/pdvkategorije")
public class PDVKategorijaController {
	
	@Autowired
	private PDVKategorijaServiceInterface pdvKategorijaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<PDVKategorija> getAll(){
		return pdvKategorijaServiceInterface.findAll();
	}

	
//	@PostMapping(value = "/pojedinacnaKategorija")
//	public ResponseEntity<PDVKategorijaDTO> pojedinacnaKategorija(@RequestParam("naziv_kategorije") String nazivKategorije) {
//		
//		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findByNazivKategorije(nazivKategorije);
//		
//		if(pdvKategorija == null) {
//			return new ResponseEntity<PDVKategorijaDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<PDVKategorijaDTO>(new PDVKategorijaDTO(pdvKategorija), HttpStatus.OK);
//		}
//		
//	}
	
	@PostMapping(value = "/dodajKategoriju")
	public ResponseEntity<Void> dodajKategoriju(@Validated @RequestParam("naziv_kategorije") String nazivKategorije) {
		
		System.out.println("Naziv kategorije: " + nazivKategorije);
		
		PDVKategorija pdvKategorija = new PDVKategorija();
		pdvKategorija.setNazivKategorije(nazivKategorije);
		pdvKategorija.setPdvStope(null);
		pdvKategorijaServiceInterface.save(pdvKategorija);
		
		System.out.println("Dodata je nova kategorija");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/izmeniKategoriju")
	public ResponseEntity<Void> izmeniKategoriju(@RequestParam("naziv_kategorije") String nazivKategorije,
			@RequestParam("novi_naziv") String noviNaziv) {
		
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findByNazivKategorije(nazivKategorije);
		
		if(pdvKategorija != null) {
			pdvKategorija.setNazivKategorije(noviNaziv);
			pdvKategorija.setPdvStope(pdvKategorija.getPdvStope());
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
}
