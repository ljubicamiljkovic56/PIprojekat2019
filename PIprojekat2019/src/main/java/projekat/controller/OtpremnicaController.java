package projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.Otpremnica;

@CrossOrigin
@RestController
@RequestMapping(value = "api/otpremnice")
public class OtpremnicaController {
	
//	@Autowired
//	private OtpremnicaService otpremnicaService;
//	
//	@RequestMapping
//	public ResponseEntity<List<Otpremnica>> getOtpremnice() {
//
//		List<Otpremnica> otpremnice = otpremnicaService.findAll();
//
//		return new ResponseEntity<>(otpremnice, HttpStatus.OK);
//	}

}
