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
import projekat.model.NaseljenoMesto;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/mesto")
public class NaseljenoMestoController {

	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<NaseljenoMesto> getAll() {
		return naseljenoMestoServiceInterface.findAll();
	}
	
//	@PostMapping(path = "/pojedinacnoMesto")
//	public ResponseEntity<NaseljenoMestoDTO> pojedinacnoMesto(@RequestParam("naziv_mesta") String nazivMesta) {
//		
//		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
//		
//		if(mesto == null) {
//			return new ResponseEntity<NaseljenoMestoDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<NaseljenoMestoDTO>(new NaseljenoMestoDTO(mesto), HttpStatus.OK);
//		}
//		
//	}
	
	@PostMapping(path = "/dodajMesto")
	public ResponseEntity<Void> dodajMesto(@RequestParam("naziv_mesta") String nazivMesta, @RequestParam("ptt_broj") String pttBroj) {
		
		System.out.println("Naziv naseljenog mesta: " + nazivMesta);
		System.out.println("Ptt broj naseljnog mesta: " + pttBroj);
		
		int pttBrojInt = Integer.parseInt(pttBroj);
		
		NaseljenoMesto mesto = new NaseljenoMesto();
		mesto.setNazivMesta(nazivMesta);
		mesto.setPttBroj(pttBrojInt);
		naseljenoMestoServiceInterface.save(mesto);
		
		System.out.println("Dodato je naseljeno mesto.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/izmeniMesto")
	public ResponseEntity<Void> izmeniMesto(@RequestParam("naziv_mesta") String nazivMesta, @RequestParam("novi_naziv") String noviNaziv,
			@RequestParam("ptt_broj") String pttBroj) {
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		int pttBrojInt = Integer.parseInt(pttBroj);
		
		if(mesto != null) {
			mesto.setNazivMesta(noviNaziv);
			mesto.setPttBroj(pttBrojInt);
			naseljenoMestoServiceInterface.save(mesto);
			
			System.out.println("Izmenjeno je naseljeno mesto");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value = "/obrisiMesto/{id}")
	public ResponseEntity<Void> obrisiMesto(@PathVariable("id") long id){
		
		NaseljenoMesto naseljenoMesto = naseljenoMestoServiceInterface.findOne(id);
		
		if(naseljenoMesto == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		naseljenoMestoServiceInterface.remove(naseljenoMesto.getIdMesta());
		
		System.out.println("Obrisano je mesto");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
