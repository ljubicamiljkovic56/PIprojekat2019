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

import projekat.dto.PoslovniPartnerDTO;
import projekat.model.NaseljenoMesto;
import projekat.model.PoslovniPartner;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
@CrossOrigin
@RestController
@RequestMapping(value = "api/poslovnipartneri")
public class PoslovniPartnerController {

	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<PoslovniPartner> getAll(){
		return poslovniPartnerServiceInterface.findAll();
	}
	
	@PostMapping(path = "/pojedinacanPrikaz")
	public ResponseEntity<PoslovniPartnerDTO> pojedinacanPrikaz(@RequestParam("naziv_poslovnog_partnera") String nazivPoslovnogPartnera) {
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
		
		if(partner == null) {
			return new ResponseEntity<PoslovniPartnerDTO>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<PoslovniPartnerDTO>(new PoslovniPartnerDTO(partner), HttpStatus.OK);
		}
		
	}
	
	@PostMapping(path = "/dodajPoslovnogPartnera")
	public ResponseEntity<Void> dodajPoslovnogPartnera(@RequestParam("naziv_poslovnog_partnera") String nazivPoslovnogPartnera,
			@RequestParam("adresa") String adresa, @RequestParam("telefon") String telefon,
			@RequestParam("fax") String fax, @RequestParam("email") String email, @RequestParam("vrsta_partnera") String vrstaPartnera,
			@RequestParam("mesto") String nazivMesta) {
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		
		PoslovniPartner partner = new PoslovniPartner();
		partner.setNazivPoslovnogPartnera(nazivPoslovnogPartnera);
		partner.setAdresa(adresa);
		partner.setTelefon(telefon);
		partner.setFax(fax);
		partner.setEmail(email);
		partner.setVrstaPartnera(vrstaPartnera);
		partner.setNaseljenoMesto(mesto);
		
		poslovniPartnerServiceInterface.save(partner);
		
		System.out.println("Dodat je novi poslovni partner");
	
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniPoslovnogPartnera")
	public ResponseEntity<Void> izmeniPoslovnogPartnera(@RequestParam("naziv_poslovnog_partnera") String nazivPoslovnogPartnera,
			@RequestParam("novi_naziv") String noviNaziv,
			@RequestParam("adresa") String adresa, @RequestParam("telefon") String telefon,
			@RequestParam("fax") String fax, @RequestParam("email") String email, @RequestParam("vrsta_partnera") String vrstaPartnera,
			@RequestParam("mesto") String nazivMesta){
		
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		if(partner != null) {
			partner.setNazivPoslovnogPartnera(noviNaziv);
			partner.setAdresa(adresa);
			partner.setTelefon(telefon);
			partner.setFax(fax);
			partner.setEmail(email);
			partner.setVrstaPartnera(vrstaPartnera);
			partner.setNaseljenoMesto(mesto);
			
			poslovniPartnerServiceInterface.save(partner);
			
			System.out.println("Izmenjen je poslovni partner");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(path = "/obrisiPoslovnogPartnera")
	public ResponseEntity<Void> obrisiPoslovnogPartnera(@RequestParam("naziv_poslovnog_partnera") String nazivPoslovnogPartnera) {
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
		
		if(partner == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		poslovniPartnerServiceInterface.remove(partner.getIdPoslovnogPartnera());
		
		System.out.println("Izbrisan je poslovni partner");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
