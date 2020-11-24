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

import projekat.dto.FakturaDTO;
import projekat.model.Faktura;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;

import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;



@CrossOrigin
@RestController
@RequestMapping(value = "api/fakture")
public class FakturaController {
	
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Faktura> getAll() {
		return fakturaServiceInterface.findAll();
	}
	
	@PostMapping(path = "/pojedinacnaFaktura")
	public ResponseEntity<FakturaDTO> pojedinacnaFaktura(@RequestParam("broj_fakture") String brojFakture) {
		
		int brojFaktureInt = Integer.parseInt(brojFakture);
		
		Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		
		if(faktura == null) {
			return new ResponseEntity<FakturaDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<FakturaDTO>(new FakturaDTO(faktura), HttpStatus.OK);
		}
	}
	
	@PostMapping(path =  "/dodajFakturu")
	public ResponseEntity<Void> dodajFakturu(@RequestParam("broj_fakture") String brojFakture, 
			@RequestParam("datum_fakture") String datumFakture, @RequestParam("datum_valute") String datumValute,
			@RequestParam("ukupna_osnovica") String ukupnaOsnovica, @RequestParam("ukupan_pdv") String ukupanPdv, 
			@RequestParam("ukupan_iznos") String ukupanIznos, @RequestParam("status_fakture") String statusFakture, @RequestParam("poslovna_godina") String poslovnaGodina,
			@RequestParam("poslovni_partner") String nazivPoslovnogPartnera, @RequestParam("preduzece") String nazivPreduzeca) throws ParseException {
		
		System.out.println("Broj fakture: " + brojFakture);
		System.out.println("Datum fakture: " + datumFakture);
		System.out.println("Datum valute: " + datumValute);
		System.out.println("Ukupna osnovica: " + ukupnaOsnovica);
		System.out.println("Ukupan pdv: " + ukupanPdv);
		System.out.println("Ukupan iznos: " + ukupanIznos);
		System.out.println("Status fakture: " + statusFakture);
		System.out.println("Poslovna godina: " + poslovnaGodina);
		System.out.println("Poslovni partner: " + nazivPoslovnogPartnera);
		System.out.println("Preduzece: " + nazivPreduzeca);
		
		int brojFaktureInt = Integer.parseInt(brojFakture);
		
		String datum = datumFakture;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    String datum2 = datumValute;
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date2 = formatter2.parse(datum2);
	    java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
	    
	    double ukupnaOsnovicaDouble = Double.parseDouble(ukupnaOsnovica);
	    double ukupanPdvDouble = Double.parseDouble(ukupanPdv);
	    double ukupanIznosDouble = Double.parseDouble(ukupanIznos);
	    
	    int godinaInt = Integer.parseInt(poslovnaGodina);
	    
	    PoslovnaGodina poslovnaGodina2 = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
	    
	    PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
	    
	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		Faktura faktura = new Faktura();
		faktura.setBrojFakture(brojFaktureInt);
		faktura.setDatumFakture(sqlDate);
		faktura.setDatumValute(sqlDate2);
		faktura.setUkupnaOsnovica(ukupnaOsnovicaDouble);
		faktura.setUkupanPDV(ukupanPdvDouble);
		faktura.setUkupanIznos(ukupanIznosDouble);
	//	faktura.setStatusFakture();
		faktura.setStavkeFakture(faktura.getStavkeFakture());
		faktura.setPoslovnaGodina(poslovnaGodina2);
		faktura.setPoslovniPartner(partner);
		faktura.setPreduzece(preduzece);
		fakturaServiceInterface.save(faktura);
		
		System.out.println("Dodata ja faktura");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniFakturu")
	public ResponseEntity<Void> izmeniFakturu(@RequestParam("broj_fakture") String brojFakture, @RequestParam("novi_broj") String noviBroj,
			@RequestParam("datum_fakture") String datumFakture, @RequestParam("datum_valute") String datumValute,
			@RequestParam("ukupna_osnovica") String ukupnaOsnovica, @RequestParam("ukupan_pdv") String ukupanPdv, 
			@RequestParam("ukupan_iznos") String ukupanIznos, @RequestParam("status_fakture") String statusFakture, 
			@RequestParam("stavka_fakture") String stavkaFakture, @RequestParam("poslovna_godina") String poslovnaGodina,
			@RequestParam("poslovni_partner") String nazivPoslovnogPartnera, @RequestParam("preduzece") String nazivPreduzeca) throws ParseException{
		
		int brojFaktureInt = Integer.parseInt(brojFakture);
		
		Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		
		int noviBrojInt = Integer.parseInt(noviBroj);
		
		String datum = datumFakture;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    String datum2 = datumValute;
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date2 = formatter2.parse(datum2);
	    java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
	    
	    double ukupnaOsnovicaDouble = Double.parseDouble(ukupnaOsnovica);
	    double ukupanPdvDouble = Double.parseDouble(ukupanPdv);
	    double ukupanIznosDouble = Double.parseDouble(ukupanIznos);
	    
	    int godinaInt = Integer.parseInt(poslovnaGodina);
	    
	    PoslovnaGodina poslovnaGodina2 = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
	    
	    PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
	    
	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(faktura != null) {
			faktura.setBrojFakture(noviBrojInt);
			faktura.setDatumFakture(sqlDate);
			faktura.setDatumValute(sqlDate2);
			faktura.setUkupnaOsnovica(ukupnaOsnovicaDouble);
			faktura.setUkupanPDV(ukupanPdvDouble);
			faktura.setUkupanIznos(ukupanIznosDouble);
			faktura.setPoslovnaGodina(poslovnaGodina2);
			faktura.setPoslovniPartner(partner);
			faktura.setPreduzece(preduzece);
			faktura.setStavkeFakture(faktura.getStavkeFakture());
			
			fakturaServiceInterface.save(faktura);
			
			System.out.println("Izmenjena je faktura.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	@PostMapping(path = "/obrisiFakturu")
	public ResponseEntity<Void> obrisiFakturu(@RequestParam("broj_fakture") String brojFakture) {
		
		int brojFaktureInt = Integer.parseInt(brojFakture);
		
		Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		
		if(faktura == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		fakturaServiceInterface.remove(faktura.getIdFakture());
		
		System.out.println("Obrisana je faktura.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
