package projekat.controller;

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

import projekat.dto.StavkaFaktureDTO;
import projekat.model.Preduzece;
import projekat.model.RobaUsluga;
import projekat.model.StavkaFakture;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;
import projekat.service.intrfc.StavkaFaktureServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/stavkefakture")
public class StavkaFaktureController {
	
	@Autowired
	private StavkaFaktureServiceInterface stavkaFaktureServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<StavkaFakture> getAll(){
		return stavkaFaktureServiceInterface.findAll();
	}
	
//	@PostMapping(path = "/pojedinacnaStavkaFakture")
//	public ResponseEntity<StavkaFaktureDTO> pojedinacnaStavkaFakture(@RequestParam("jedinicna_cena") String jedinicnaCena) {
//		
//		double jedinicnaCenaDouble = Double.parseDouble(jedinicnaCena);
//		
//		StavkaFakture stavkaFakture = stavkaFaktureServiceInterface.findByJedinicnaCena(jedinicnaCenaDouble);
//		
//		if(stavkaFakture == null) {
//			return new ResponseEntity<StavkaFaktureDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<StavkaFaktureDTO>(new StavkaFaktureDTO(stavkaFakture), HttpStatus.OK);
//		}
//		
//	}
//	
	@PostMapping(path = "/dodajStavkuFakture")
	public ResponseEntity<Void> dodajStavkuFakture(@RequestParam("kolicina") String kolicina,
			@RequestParam("rabat") String rabat, @RequestParam("jedinicna_cena") String jedinicnaCena, 
			@RequestParam("pdv_stopa") String pdvStopa, @RequestParam("osnovica_pdv") String osnovicaZaPDV, 
			@RequestParam("iznos_pdv") String iznosPDV, @RequestParam("ukupan_iznos") String ukupanIznos,
			@RequestParam("naziv_preduzeca") String nazivPreduzeca, @RequestParam("roba") String roba) {
		
		System.out.println("Kolicina: " + kolicina);
		System.out.println("Rabat: " + rabat);
		System.out.println("Jedinicna cena: " + jedinicnaCena);
		System.out.println("PDV stopa: " + pdvStopa);
		System.out.println("Osnovica za pdv: " + osnovicaZaPDV);
		System.out.println("Iznos pdv: " + iznosPDV);
		System.out.println("Ukupan iznos: " + ukupanIznos);
		System.out.println("Naziv preduzeca: " + nazivPreduzeca);
		System.out.println("Roba: " + roba);
		
		
		double kolicinaDouble = Double.parseDouble(kolicina);
		double rabatDouble = Double.parseDouble(rabat);
		double jedinicnaCenaDouble = Double.parseDouble(jedinicnaCena);
		
		double pdvStopaDouble = Double.parseDouble(pdvStopa);
		double osnovicaZaPDVDouble = Double.parseDouble(osnovicaZaPDV);
		double iznosPDVDouble = Double.parseDouble(iznosPDV);
		double ukupanIznosDouble = Double.parseDouble(ukupanIznos);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findByNazivRobeUsluge(roba); 
		
		StavkaFakture stavkaFakture = new StavkaFakture();
		stavkaFakture.setKolicina(kolicinaDouble);
		stavkaFakture.setRabat(rabatDouble);
		stavkaFakture.setJedinicnaCena(jedinicnaCenaDouble);
		stavkaFakture.setPdvStopa(pdvStopaDouble);
		stavkaFakture.setOsnovicaZaPDV(osnovicaZaPDVDouble);
		stavkaFakture.setIznosPDV(iznosPDVDouble);
		stavkaFakture.setUkupanIznos(ukupanIznosDouble);
		stavkaFakture.setPreduzece(preduzece);
		stavkaFakture.setRobaUsluga(robaUsluga);
		stavkaFaktureServiceInterface.save(stavkaFakture);
		
		System.out.println("Dodata je stavka fakture");

		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniStavkuFakture")
	public ResponseEntity<Void> izmeniStavkuFakture (@RequestParam("jedinicna_cena") String jedinicnaCena,
			@RequestParam("kolicina") String kolicina,
			@RequestParam("rabat") String rabat, @RequestParam("nova_cena") String novaJedinicnaCena, 
			@RequestParam("pdv_stopa") String pdvStopa, @RequestParam("osnovica_pdv") String osnovicaZaPDV, 
			@RequestParam("iznos_pdv") String iznosPDV, @RequestParam("ukupan_iznos") String ukupanIznos,
			@RequestParam("naziv_preduzeca") String nazivPreduzeca, @RequestParam("roba") String roba) {
		
		double jedinicnaCenaDouble = Double.parseDouble(jedinicnaCena);
		
		StavkaFakture stavkaFakture = stavkaFaktureServiceInterface.findByJedinicnaCena(jedinicnaCenaDouble);
		
		double kolicinaDouble = Double.parseDouble(kolicina);
		double rabatDouble = Double.parseDouble(rabat);
		double novaJedinicnaCenaDouble = Double.parseDouble(novaJedinicnaCena);
		
		double pdvStopaDouble = Double.parseDouble(pdvStopa);
		double osnovicaZaPDVDouble = Double.parseDouble(osnovicaZaPDV);
		double iznosPDVDouble = Double.parseDouble(iznosPDV);
		double ukupanIznosDouble = Double.parseDouble(ukupanIznos);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		RobaUsluga robaUsluga = robaUslugaServiceInterface.findByNazivRobeUsluge(roba); 
		
		if(stavkaFakture != null) {
			stavkaFakture.setKolicina(kolicinaDouble);
			stavkaFakture.setRabat(rabatDouble);
			stavkaFakture.setJedinicnaCena(novaJedinicnaCenaDouble);
			stavkaFakture.setPdvStopa(pdvStopaDouble);
			stavkaFakture.setOsnovicaZaPDV(osnovicaZaPDVDouble);
			stavkaFakture.setIznosPDV(iznosPDVDouble);
			stavkaFakture.setUkupanIznos(ukupanIznosDouble);
			stavkaFakture.setPreduzece(preduzece);
			stavkaFakture.setRobaUsluga(robaUsluga);
			
			stavkaFaktureServiceInterface.save(stavkaFakture);
			
			System.out.println("Izmenjena je stavka fakture.");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	@PostMapping(path = "/obrisiStavkuFakture")
	public ResponseEntity<Void> obrisiStavkuFakture(@RequestParam("jedinicna_cena") String jedinicnaCena) {
		
		double jedinicnaCenaDouble = Double.parseDouble(jedinicnaCena);
		
		StavkaFakture stavkaFakture = stavkaFaktureServiceInterface.findByJedinicnaCena(jedinicnaCenaDouble);
		
		if(stavkaFakture == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		stavkaFaktureServiceInterface.remove(stavkaFakture.getIdStavke());
		
		System.out.println("Obrisana je stavka fakture.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
