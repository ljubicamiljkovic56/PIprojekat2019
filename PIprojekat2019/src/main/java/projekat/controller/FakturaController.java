package projekat.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
@RequestMapping(value = "api/fakture")
public class FakturaController {
	
//	@Autowired
//	private FakturaService fakturaService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Faktura>> getFakture() {
//
//		List<Faktura> fakture = fakturaService.findAll();
//
//		return new ResponseEntity<>(fakture, HttpStatus.OK);
//	}
//
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<List<Faktura>> dodajFakturu(){
//		return null;
//
//	}
}
