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

import projekat.dto.ProizvodDTO;
import projekat.model.Proizvod;
import projekat.service.intrfc.ProizvodServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/proizvodi")
public class ProizvodController {
	
	@Autowired
	private ProizvodServiceInterface proizvodServiceInterface;
	
	@GetMapping(path="/sviproizvodi")
	public List<Proizvod> getAll(){
		return proizvodServiceInterface.findAll();
	}
	
	@PostMapping(path = "/proizvod/naziv")
	public ResponseEntity<ProizvodDTO> pojedinacanProizvod(@RequestParam String naziv_proizvoda) {
		
		Proizvod proizvod = proizvodServiceInterface.findByNaziv(naziv_proizvoda);
		
		if(proizvod == null) {
			return new ResponseEntity<ProizvodDTO>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<ProizvodDTO>(new ProizvodDTO(proizvod), HttpStatus.OK);
		}
		
	}
	

}
