package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
