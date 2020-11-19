package projekat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projekat.service.intrfc.CenovnikServiceInterface;


@CrossOrigin
@RestController
@RequestMapping(value = "api/cenovnici")
public class CenovnikController {
	
	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	


}
