package projekat.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekat.dto.OtpremnicaDTO;
import projekat.model.Faktura;
import projekat.model.Otpremnica;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.OtpremnicaServiceInterface;



@CrossOrigin
@RestController
@RequestMapping(value = "api/otpremnice")
public class OtpremnicaController {
	
	@Autowired
	private OtpremnicaServiceInterface otpremnicaServiceInterface;
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Otpremnica> getAll() {
		return otpremnicaServiceInterface.findAll();
	}
	
	@PostMapping(path = "/pojedinacnaOtpremnica")
	public ResponseEntity<OtpremnicaDTO> pojedinacnaOtpremnica(@RequestParam("broj_otpremnice") String brojOtpremnice) {
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		if(otpremnica == null) {
			return new ResponseEntity<OtpremnicaDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<OtpremnicaDTO>(new OtpremnicaDTO(otpremnica), HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "/dodajOtpremnicu")
	public ResponseEntity<Void> dodajOtpremnicu(@RequestParam("broj_otpremnice") String brojOtpremnice, 
			@RequestParam("kupac") String kupac, @RequestParam("adresa_isporuke") String adresaIsporuke, 
			@RequestParam("datum_isporuke") String datumIsporuke, @RequestParam("prevoznik") String prevoznik,
			@RequestParam("faktura") String brojFakture) throws ParseException {
		
		System.out.println("Broj otpremnice: " + brojOtpremnice);
		System.out.println("Kupaac: " + kupac);
		System.out.println("Adresa isporuke: " + adresaIsporuke);
		System.out.println("Datum isporuke: " + datumIsporuke);
		System.out.println("Prevoznik: " + prevoznik);
		System.out.println("Faktura: " +  brojFakture);
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		String datum = datumIsporuke;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    int brojFaktureInt = Integer.parseInt(brojFakture);
	    
	    Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
	    
	    Otpremnica otpremnica = new Otpremnica();
	    otpremnica.setBrojOtpremnice(brojOtpremniceInt);
	    otpremnica.setKupac(kupac);
	    otpremnica.setAdresaIsporuke(adresaIsporuke);
	    otpremnica.setDatumIsporuke(sqlDate);
	    otpremnica.setPrevoznik(prevoznik);
	    otpremnica.setPotpisVozaca(false);
	    otpremnica.setPrimioRobu(false);
	    otpremnica.setStavkeOtpremnice(otpremnica.getStavkeOtpremnice());
	    otpremnica.setFaktura(faktura);
	    otpremnicaServiceInterface.save(otpremnica);
	    
	    System.out.println("Dodata je nova otpremnica");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniOtpremnicu")
	public ResponseEntity<Void> izmeniOtpremnicu(@RequestParam("broj_otpremnice") String brojOtpremnice, 
			@RequestParam("novi_broj") String noviBroj,
			@RequestParam("kupac") String kupac, @RequestParam("adresa_isporuke") String adresaIsporuke, 
			@RequestParam("datum_isporuke") String datumIsporuke, @RequestParam("prevoznik") String prevoznik,
			@RequestParam("faktura") String brojFakture) throws ParseException {
		
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		int noviBrojInt = Integer.parseInt(noviBroj);
		String datum = datumIsporuke;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    int brojFaktureInt = Integer.parseInt(brojFakture);
	    
	    Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		
		if(otpremnica != null) {
			otpremnica.setBrojOtpremnice(noviBrojInt);
			otpremnica.setKupac(kupac);
			otpremnica.setAdresaIsporuke(adresaIsporuke);
			otpremnica.setDatumIsporuke(sqlDate);
			otpremnica.setPrevoznik(prevoznik);
			otpremnica.setPotpisVozaca(true);
			otpremnica.setPrimioRobu(true);
			otpremnica.setFaktura(faktura);
			otpremnica.setStavkeOtpremnice(otpremnica.getStavkeOtpremnice());
			
			System.out.println("Izmenjena je otpremnica.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}

	
	@PostMapping(path = "/obrisiOtpremnicu")
	public ResponseEntity<Void> obrisiOtpremnicu(@RequestParam("broj_otpremnice") String brojOtpremnice){
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		if(otpremnica == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		otpremnicaServiceInterface.remove(otpremnica.getIdOtpremnice());
		
		System.out.println("Obrisana je otpremnica.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
