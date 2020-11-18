package projekat.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
