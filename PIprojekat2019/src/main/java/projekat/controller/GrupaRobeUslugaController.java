package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.GrupaRobeUsluga;
import projekat.model.PDVKategorija;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;
import projekat.service.intrfc.PDVKategorijaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/gruperobe")
public class GrupaRobeUslugaController {

	
	@Autowired
	private GrupaRobeUslugaServiceInterface grupaRobeUslugaServiceInterface;
	
	@Autowired
	private PDVKategorijaServiceInterface pdvKategorijaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<GrupaRobeUsluga> getAll(){
		return grupaRobeUslugaServiceInterface.findAll();
	}
	
	
//	@PostMapping(value = "/pojedinacnaGrupa")
//	private ResponseEntity<GrupaRobeUslugaDTO> pojedinacnaGrupa(@RequestParam("naziv_grupe") String nazivGrupe) {
//		
//		GrupaRobeUsluga grupaRobeUsluga = grupaRobeUslugaServiceInterface.findByNazivGrupe(nazivGrupe);
//		
//		if(grupaRobeUsluga == null) {
//			return new ResponseEntity<GrupaRobeUslugaDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<GrupaRobeUslugaDTO>(new GrupaRobeUslugaDTO(grupaRobeUsluga), HttpStatus.OK);
//		}
//		
//	}
	
	@PostMapping(value = "/dodajGrupu")
	private ResponseEntity<Void> dodajGrupu(@RequestParam("naziv_grupe") String nazivGrupe, 
			@RequestParam("pdvKategorija") String nazivKategorije) {
		
		System.out.println("Naziv grupe: " + nazivGrupe);
	
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findByNazivKategorije(nazivKategorije);
		PDVKategorija pdvKategorija2 = pdvKategorijaServiceInterface.findOne(pdvKategorija.getIdKategorije());
		
		GrupaRobeUsluga grupaRobeUsluga = new GrupaRobeUsluga();
		grupaRobeUsluga.setNazivGrupe(nazivGrupe);
		grupaRobeUsluga.setPdvKategorija(pdvKategorija2);
		grupaRobeUslugaServiceInterface.save(grupaRobeUsluga);
		
		System.out.println("Dodata je nova grupa robe");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
//	@PostMapping(value = "/izmeniGrupu")
//	private ResponseEntity<Void> izmeniGrupu(@RequestParam("naziv_grupe") String nazivGrupe, @RequestParam("novi_naziv") String noviNaziv) {
//		
//		GrupaRobeUsluga grupaRobeUsluga = grupaRobeUslugaServiceInterface.findByNazivGrupe(nazivGrupe);
//		
//		if(grupaRobeUsluga != null) {
//			grupaRobeUsluga.setNazivGrupe(noviNaziv);
//			grupaRobeUslugaServiceInterface.save(grupaRobeUsluga);
//			
//			System.out.println("Izmenjena je grupa robe");
//			
//			
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//		
//	}
	
	@DeleteMapping(value = "/obrisiGrupu/{id}")
	private ResponseEntity<Void> obrisiGrupu(@PathVariable("id") long id){
		
		GrupaRobeUsluga grupaRobeUsluga = grupaRobeUslugaServiceInterface.findOne(id);
		
		if(grupaRobeUsluga == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		grupaRobeUslugaServiceInterface.remove(grupaRobeUsluga.getIdGrupe());
		
		System.out.println("Obrisana je grupa robe");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
}
