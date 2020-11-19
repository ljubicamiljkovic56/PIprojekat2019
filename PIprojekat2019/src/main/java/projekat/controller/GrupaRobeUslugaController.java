package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekat.dto.GrupaRobeUslugaDTO;
import projekat.model.GrupaRobeUsluga;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/gruperobe")
public class GrupaRobeUslugaController {

	
	@Autowired
	private GrupaRobeUslugaServiceInterface grupaRobeUslugaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<GrupaRobeUsluga> getAll(){
		return grupaRobeUslugaServiceInterface.findAll();
	}
	
	
	@PostMapping(value = "/pojedinacnaGrupa")
	private ResponseEntity<GrupaRobeUslugaDTO> pojedinacnaGrupa(@RequestParam("naziv_grupe") String nazivGrupe) {
		return null;
		
	}
	
	@PostMapping(value = "/dodajGrupu")
	private ResponseEntity<Void> dodajGrupu(@RequestParam("naziv_grupe") String nazivGrupe) {
		return null;
		
	}
	
	@PostMapping(value = "/izmeniGrupu")
	private ResponseEntity<Void> izmeniGrupu(@RequestParam("naziv_grupe") String nazivGrupe) {
		return null;
		
	}
	
	@PostMapping(value = "/obrisiGrupu")
	private ResponseEntity<Void> obrisiGrupu(@RequestParam("naziv_grupe") String nazivGrupe){
		return null;
		
	}
	
}
