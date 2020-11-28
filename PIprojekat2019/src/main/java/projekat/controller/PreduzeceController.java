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

import projekat.dto.PreduzeceDTO;
import projekat.model.Cenovnik;
import projekat.model.NaseljenoMesto;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.service.intrfc.CenovnikServiceInterface;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/preduzece")
public class PreduzeceController {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Preduzece> getAll() {
		return preduzeceServiceInterface.findAll();
	}
	
	
	@PostMapping(path = "/pojedinacnoPreduzece")
	public ResponseEntity<PreduzeceDTO> pojedinacnoPreduzece(@RequestParam("naziv_preduzeca") String nazivPreduzeca){
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(preduzece == null) {
			return new ResponseEntity<PreduzeceDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<PreduzeceDTO>(new PreduzeceDTO(preduzece), HttpStatus.OK);
		}
	}
	
	
	
	@PostMapping(path = "/dodajPreduzece")
	public ResponseEntity<Void> dodajPreduzece(@RequestParam("naziv_preduzeca") String nazivPreduzeca,
			@RequestParam("adresa_preduzeca") String adresa, @RequestParam("broj_telefona") String brojTelefona, @RequestParam("fax_preduzeca") String fax,
			@RequestParam("godina") String godina,
			@RequestParam("naziv_mesta") String nazivMesta, @RequestParam("naziv_poslovnog_partnera") String nazivPartnera,
			@RequestParam("datum_vazenja") String datumCenovnika) throws ParseException {
		
		int godinaInt = Integer.parseInt(godina);
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		PoslovniPartner poslovniPartner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPartnera);
		
		String datum = datumCenovnika;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
		
		Preduzece preduzece = new Preduzece();
		preduzece.setNazivPreduzeca(nazivPreduzeca);
		preduzece.setAdresa(adresa);
		preduzece.setBrojTelefona(brojTelefona);
		preduzece.setFax(fax);
		preduzece.setPoslovnaGodina(poslovnaGodina);
		preduzece.setNaseljenoMesto(mesto);
		preduzece.setPoslovniPartner(poslovniPartner);
		preduzece.setCenovnik(cenovnik);
		preduzeceServiceInterface.save(preduzece);
		
		System.out.println("Dodato je novo preduzece");
				
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniPreduzece")
	public ResponseEntity<Void> izmeniPreduzece(@RequestParam("naziv_preduzeca") String nazivPreduzeca,
			@RequestParam("novi_naziv") String noviNaziv, @RequestParam("adresa_preduzeca") String adresa,
			@RequestParam("broj_telefona") String brojTelefona, @RequestParam("fax_preduzeca") String fax,
			@RequestParam("godina") String godina,
			@RequestParam("naziv_mesta") String nazivMesta, @RequestParam("naziv_poslovnog_partnera") String nazivPartnera,
			@RequestParam("datum_vazenja") String datumCenovnika) throws ParseException {
		
	
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		int godinaInt = Integer.parseInt(godina);
		
		PoslovnaGodina poslovnaGodina = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		PoslovniPartner poslovniPartner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPartnera);
		
		String datum = datumCenovnika;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Cenovnik cenovnik = cenovnikServiceInterface.findByDatumPocetkaVazenja(sqlDate);
		
		if(preduzece != null) {
			preduzece.setNazivPreduzeca(noviNaziv);
			preduzece.setAdresa(adresa);
			preduzece.setBrojTelefona(brojTelefona);
			preduzece.setFax(fax);
			preduzece.setPoslovnaGodina(poslovnaGodina);
			preduzece.setNaseljenoMesto(mesto);
			preduzece.setPoslovniPartner(poslovniPartner);
			preduzece.setCenovnik(cenovnik);
			preduzeceServiceInterface.save(preduzece);
			
			System.out.println("Izmenjeno je preduzece.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	
		
	}
	
	@PostMapping(path = "/obrisiPreduzece")
	public ResponseEntity<Void> obrisiPreduzece(@RequestParam("naziv_preduzeca") String nazivPreduzeca) {
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(preduzece == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		preduzeceServiceInterface.remove(preduzece.getIdPreduzeca());
		
		System.out.println("Obrisano preduzece.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
