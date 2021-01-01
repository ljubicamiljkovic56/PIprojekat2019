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
import projekat.model.JedinicaMere;
import projekat.model.RobaUsluga;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;
import projekat.service.intrfc.JedinicaMereServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/roba")
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
	
//	@PostMapping(path = "/pojedinacnaRoba")
//	public ResponseEntity<RobaUslugaDTO> pojedinacnaRoba(@RequestParam("naziv_robe") String nazivRobe) {
//		
//		RobaUsluga roba = robaUslugaServiceInterface.findByNazivRobeUsluge(nazivRobe);
//		
//		if(roba == null) {
//			return new ResponseEntity<RobaUslugaDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<RobaUslugaDTO>(new RobaUslugaDTO(roba), HttpStatus.OK);
//		}
//		
//	}
	
	@PostMapping(path = "/dodajRobu")
	public ResponseEntity<Void> dodajRobu(@RequestParam("naziv_robe") String nazivRobe, 
			@RequestParam("opis") String opis, @RequestParam("roba") String roba,
			@RequestParam("naziv_mere") String nazivMere, @RequestParam("naziv_grupe") String nazivGrupe) {
		
		GrupaRobeUsluga grupa = grupaRobeUslugaServiceInterface.findByNazivGrupe(nazivGrupe);
		GrupaRobeUsluga grupa2 = grupaRobeUslugaServiceInterface.findOne(grupa.getIdGrupe());
		
		JedinicaMere mera = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivMere);
		JedinicaMere mera2 = jedinicaMereServiceInterface.findOne(mera.getIdJediniceMere());
		
		
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
	
//	@PostMapping(path = "/izmeniRobu")
//	public ResponseEntity<Void> izmeniRobu(@RequestParam("naziv_robe") String nazivRobe, 
//			@RequestParam("novi_naziv") String noviNaziv, @RequestParam("opis") String opis, @RequestParam("naziv_grupe") String nazivGrupe,
//			@RequestParam("naziv_mere") String nazivMere) {
//		
//		RobaUsluga roba = robaUslugaServiceInterface.findByNazivRobeUsluge(nazivRobe);
//		
//		GrupaRobeUsluga grupa = grupaRobeUslugaServiceInterface.findByNazivGrupe(nazivGrupe);
//		
//		JedinicaMere mera = jedinicaMereServiceInterface.findByNazivJediniceMere(nazivMere);
//		
//		if(roba != null) {
//			roba.setNazivRobeUsluge(noviNaziv);
//			roba.setOpis(opis);
//			roba.setRoba(true);
//			roba.setGrupaRobeUsluga(grupa);
//			roba.setJedinicaMere(mera);
//			robaUslugaServiceInterface.save(roba);
//			
//			System.out.println("Izmena robe");
//			
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//		
//		
//	}
	
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
}
