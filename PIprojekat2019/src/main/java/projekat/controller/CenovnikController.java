package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.Cenovnik;

@CrossOrigin
@RestController
@RequestMapping(value = "api/cenovnici")
public class CenovnikController {
	
//	@Autowired
//	private CenovnikService cenovnikService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Cenovnik>> getCenovnici() {
//
//		List<Cenovnik> cenovnici = cenovnikService.findAll();
//
//		return new ResponseEntity<>(cenovnici, HttpStatus.OK);
//	}
//	
//	

}
