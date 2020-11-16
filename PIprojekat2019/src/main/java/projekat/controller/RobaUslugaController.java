package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projekat.model.RobaUsluga;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/roba")
public class RobaUslugaController {

	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	
	@GetMapping(path="/svaroba")
	public List<RobaUsluga> getAll(){
		return robaUslugaServiceInterface.findAll();
	}
}
