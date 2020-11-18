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
import projekat.model.RobaUsluga;
import projekat.service.intrfc.ProizvodServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/proizvodi")
public class ProizvodController {
	
	@Autowired
	private ProizvodServiceInterface proizvodServiceInterface;
	
	@Autowired 
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
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
	
	@PostMapping(path = "/kupovina")
	private ResponseEntity<Void> kupovina(@RequestParam String naziv_proizvoda) {
		
		Proizvod proizvod = proizvodServiceInterface.findByNaziv(naziv_proizvoda);
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findByNazivRobeUsluge(naziv_proizvoda);
		
		if(proizvod == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		Proizvod kupljeni = new Proizvod();
		kupljeni.setNaziv(naziv_proizvoda);
		kupljeni.setCena(proizvod.getCena());
		kupljeni.setOpis(proizvod.getOpis());
		proizvodServiceInterface.save(kupljeni);
		
		robaUsluga = new RobaUsluga();
		robaUsluga.setNazivRobeUsluge(naziv_proizvoda);
		robaUsluga.setGrupaRobeUsluga(robaUsluga.getGrupaRobeUsluga());
		robaUsluga.setJedinicaMere(robaUsluga.getJedinicaMere());
		robaUsluga.setOpis(robaUsluga.getOpis());
		//robaUsluga2.set

		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	

}
