package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.Faktura;

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
