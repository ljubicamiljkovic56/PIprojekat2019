package projekat.controller;

//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekat.model.Faktura;
import projekat.model.Narudzbenica;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.model.StavkaFakture;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.NarudzbenicaServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.StavkaFaktureServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/narudzbenica")
@ControllerAdvice
public class NarudzbenicaController {

	@Autowired
	private NarudzbenicaServiceInterface narudzbenicaServiceInterface;
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
	@Autowired
	private StavkaFaktureServiceInterface stavkaFaktureServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Narudzbenica> getAll() {
		return narudzbenicaServiceInterface.findAll();
	}
	
	@PostMapping(value = "/dodajNarudzbenicu")
	public ResponseEntity<Void> dodajNarudzbenicu(@Validated @RequestParam("broj_narudzbenice") String brojString,
			@RequestParam("preduzece") String nazivPreduzeca, @RequestParam("poslovni_partner") String nazivPoslovnogPartnera,
			@RequestParam("godina") String godinaString) {
		
		int brojNarudzbenice = Integer.parseInt(brojString);
		
		Preduzece preduzece1 = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		Preduzece preduzece = preduzeceServiceInterface.findOne(preduzece1.getIdPreduzeca());
		
		PoslovniPartner poslovniPartner1 = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
		PoslovniPartner poslovniPartner = poslovniPartnerServiceInterface.findOne(poslovniPartner1.getIdPoslovnogPartnera());
		
		int godina = Integer.parseInt(godinaString);
		
		PoslovnaGodina poslovnaGodina1 = poslovnaGodinaServiceInterface.findByGodina(godina);
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findOne(poslovnaGodina1.getIdGodine());
		
		if(brojNarudzbenice == 0 || preduzece == null || poslovniPartner == null || godina == 0) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		Narudzbenica narudzbenica = new Narudzbenica();
		narudzbenica.setBrojNarudzbenice(brojNarudzbenice);
		narudzbenica.setPreduzece(preduzece);
		narudzbenica.setPoslovniPartner(poslovniPartner);
		narudzbenica.setPoslovnaGodina(poslovnaGodina);
		narudzbenicaServiceInterface.save(narudzbenica);
		
		System.out.println("Dodata je nova narudzbenica");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/obrisiNarudzbenicu/{id}")
	private ResponseEntity<Void> obrisiNarudzbenicu(@PathVariable("id") long id) {
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(id);
		
		if(narudzbenica == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		narudzbenicaServiceInterface.remove(narudzbenica.getId());
		
		System.out.println("Obrisana je narudzbenica.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/kreirajFakturu/{id}")
	private ResponseEntity<Void> kreirajFakturu(@PathVariable("id") long id){
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(id);
		
		if(narudzbenica == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		narudzbenica.getStavkeNarudzbenice();
		
		Faktura faktura = new Faktura();
		fakturaServiceInterface.save(faktura);
		
		StavkaFakture stavkaFakture = new StavkaFakture();
	//	stavkaFakture.setKolicina();
		stavkaFakture.setFaktura(faktura);
		stavkaFaktureServiceInterface.save(stavkaFakture);
		
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Void> handleNullPointer() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
