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

import projekat.dto.PreduzeceDTO;
import projekat.model.NaseljenoMesto;
import projekat.model.Preduzece;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/preduzece")
public class PreduzeceController {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
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
			@RequestParam("adresa") String adresa, @RequestParam("broj_telefona") String brojTelefona, @RequestParam("fax") String fax,
			@RequestParam("naziv_mesta") String nazivMesta) {
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		Preduzece preduzece = new Preduzece();
		preduzece.setNazivPreduzeca(nazivPreduzeca);
		preduzece.setAdresa(adresa);
		preduzece.setBrojTelefona(brojTelefona);
		preduzece.setFax(fax);
		preduzece.setNaseljenoMesto(mesto);
		preduzece.setCenovnik(preduzece.getCenovnik());
	//	preduzece.setFakture(preduzece.getFakture());
	//	preduzece.setStavkeFakture(preduzece.getStavkeFakture());
		//preduzece.setPoslovneGodine(preduzece.getPoslovneGodine());
	//	preduzece.setPoslovniPartneri(preduzece.getPoslovniPartneri());
		preduzeceServiceInterface.save(preduzece);
		
		System.out.println("Dodato je novo preduzece");
				
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniPreduzece")
	public ResponseEntity<Void> izmeniPreduzece(@RequestParam("naziv_preduzeca") String nazivPreduzeca,
			@RequestParam("novi_naziv") String noviNaziv, @RequestParam("adresa") String adresa,
			@RequestParam("broj_telefona") String brojTelefona, @RequestParam("fax") String fax) {
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(preduzece != null) {
			preduzece.setNazivPreduzeca(noviNaziv);
			preduzece.setAdresa(adresa);
			preduzece.setBrojTelefona(brojTelefona);
			preduzece.setFax(fax);
			preduzece.setNaseljenoMesto(preduzece.getNaseljenoMesto());
			preduzece.setCenovnik(preduzece.getCenovnik());
			//preduzece.setFakture(preduzece.getFakture());
			//preduzece.setStavkeFakture(preduzece.getStavkeFakture());
		//	preduzece.setPoslovneGodine(preduzece.getPoslovneGodine());
		//	preduzece.setPoslovniPartneri(preduzece.getPoslovniPartneri());
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
