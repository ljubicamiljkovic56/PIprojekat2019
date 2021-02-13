package projekat.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import projekat.model.RobaUsluga;
import projekat.model.StavkaFakture;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.NarudzbenicaServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;
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
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Narudzbenica> getAll() {
		return narudzbenicaServiceInterface.findAll();
	}
	
	@PostMapping(value = "/kreirajFakturu", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	private ResponseEntity<Void> kreirajFakturu(@RequestParam("id") long id,
			@RequestParam("datum_valute") String datumValuteString,
			@RequestParam("rabat") String rabatString,
			@RequestParam("pdv_stopa") String pdvStopaString,
			@RequestParam("broj_fakture") String brojFaktureString,
			@RequestParam("roba") String roba){
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(id);
		
		RobaUsluga roba1 = robaUslugaServiceInterface.findByNazivRobeUsluge(roba);
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findOne(roba1.getIdRobeUsluge());
		
		if(narudzbenica == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			String query = "SELECT cena, kolicina, id_robe FROM narudzbenica, stavka_narudzbenice WHERE narudzbenica.narudzbenica_id = stavka_narudzbenice.id_narudzbenice AND narudzbenica.narudzbenica_id = " + id;
			
			pstmt = conn.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				StavkaFakture stavkaFakture = new StavkaFakture();
				double kolicina = rset.getDouble("kolicina");
				stavkaFakture.setKolicina(kolicina);
				double rabat = Double.parseDouble(rabatString);
				stavkaFakture.setRabat(rabat);
				double jedinicnaCena = rset.getDouble("cena");
				stavkaFakture.setJedinicnaCena(jedinicnaCena);
				double iznos = jedinicnaCena * kolicina;
				stavkaFakture.setIznos(iznos);
				double pdvStopa = Double.parseDouble(pdvStopaString);
				stavkaFakture.setPdvStopa(pdvStopa);
				double osnovicaZaPDV = iznos - rabat;
				stavkaFakture.setOsnovicaZaPDV(osnovicaZaPDV);
				double iznosPDV = (osnovicaZaPDV * pdvStopa)/100;
				stavkaFakture.setIznosPDV(iznosPDV);
				double ukupanIznos = iznos - rabat + iznosPDV;
				stavkaFakture.setUkupanIznos(ukupanIznos);
				
				String datum = datumValuteString;
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = formatter.parse(datum);
			    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			    int brojFakture = Integer.parseInt(brojFaktureString);
				
				Date datumFakture = Date.valueOf(LocalDate.now());
				Faktura faktura = new Faktura();
				faktura.setBrojFakture(brojFakture);
				faktura.setDatumFakture(datumFakture);
				faktura.setDatumValute(sqlDate);
				faktura.setUkupnaOsnovica(stavkaFakture.getIznos());
				faktura.setUkupanPDV(stavkaFakture.getIznosPDV());
				faktura.setUkupanIznos(stavkaFakture.getUkupanIznos());
				faktura.setStatusFakture("F");
				faktura.setPoslovnaGodina(narudzbenica.getPoslovnaGodina());
				faktura.setPreduzece(narudzbenica.getPreduzece());
				faktura.setPoslovniPartner(narudzbenica.getPoslovniPartner());
				faktura.setNarudzbenica(narudzbenica);
				
				fakturaServiceInterface.save(faktura);
				
				stavkaFakture.setPreduzece(faktura.getPreduzece());
				stavkaFakture.setFaktura(faktura);
				stavkaFakture.setRobaUsluga(robaUsluga);
				
				stavkaFaktureServiceInterface.save(stavkaFakture);
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Kreirana je faktura");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
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
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Void> handleNullPointer() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
