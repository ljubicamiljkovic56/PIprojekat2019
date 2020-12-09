package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.StavkaNarudzbenice;
import projekat.service.intrfc.StavkaNarudzbeniceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkenarudzbenice")
public class StavkaNarudzbeniceController {
	
	@Autowired
	private StavkaNarudzbeniceServiceInterface stavkaNarudzbeniceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<StavkaNarudzbenice> getAll() {
		return stavkaNarudzbeniceServiceInterface.findAll();
	}

}
