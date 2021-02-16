package projekat.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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
import projekat.model.NaseljenoMesto;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
@CrossOrigin
@RestController
@RequestMapping(value = "api/poslovnipartneri")
@ControllerAdvice
public class PoslovniPartnerController {

	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	
	@GetMapping(path = "/all")
	public List<PoslovniPartner> getAll(){
		return poslovniPartnerServiceInterface.findAll();
	}
	
	@GetMapping(path = "/p")
    public ResponseEntity<List<PoslovniPartner>> getAllPoslovniPartner(
                        @RequestParam("pageNo") Integer pageNo, 
                        @RequestParam("pageSize") Integer pageSize) 
    {
       
		Page<PoslovniPartner> partneri = poslovniPartnerServiceInterface.findAll(pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(partneri.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(partneri.getContent());
    }
	
	@GetMapping(path = "/searchByNaziv")
	private ResponseEntity<List<PoslovniPartner>> searchByNaziv(@RequestParam("naziv") String nazivPoslovnogPartnera,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {

		Page<PoslovniPartner> partner = poslovniPartnerServiceInterface.findAllByNazivPoslovnogPartnera(nazivPoslovnogPartnera, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(partner.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(partner.getContent());
		
	}
	
	@GetMapping(path = "/searchByAdresa")
	private ResponseEntity<List<PoslovniPartner>> searchByAdresa(@RequestParam("adresa") String adresa,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {

		Page<PoslovniPartner> partner = poslovniPartnerServiceInterface.findAllByAdresa(adresa, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.set("total", String.valueOf(partner.getTotalPages()));
        return ResponseEntity.ok().headers(headers).body(partner.getContent());
		
	}
	
	@GetMapping(path = "/searchByEmail")
	private ResponseEntity<List<PoslovniPartner>> searchByEmail(@RequestParam("email") String email, 
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {
		
		Page<PoslovniPartner> partner = poslovniPartnerServiceInterface.findAllByEmail(email, pageNo, pageSize);
		HttpHeaders headers = new HttpHeaders();
	    headers.set("total", String.valueOf(partner.getTotalPages()));
	    return ResponseEntity.ok().headers(headers).body(partner.getContent());
		
	}
	
	@GetMapping(path = "/searchByVrstaPartnera")
	private ResponseEntity<List<PoslovniPartner>> searchByVrstaPartnera(@RequestParam("vrsta") String vrstaPartnera,
			@RequestParam("pageNo") Integer pageNo, 
            @RequestParam("pageSize") Integer pageSize) {
		
		Page<PoslovniPartner> partner = poslovniPartnerServiceInterface.findAllByVrstaPartnera(vrstaPartnera, pageNo, pageSize);
		HttpHeaders headers = new HttpHeaders();
	    headers.set("total", String.valueOf(partner.getTotalPages()));
	    return ResponseEntity.ok().headers(headers).body(partner.getContent());
	}
	
	@PostMapping(path = "/dodajPoslovnogPartnera")
	public ResponseEntity<Void> dodajPoslovnogPartnera(@Validated @RequestParam("naziv_poslovnog_partnera") String nazivPoslovnogPartnera,
			@RequestParam("adresa") String adresa, @RequestParam("telefon") String telefon,
			@RequestParam("fax") String fax, @RequestParam("email") String email, @RequestParam("vrsta_partnera") String vrstaPartnera,
			@RequestParam("mesto") String nazivMesta, @RequestParam("preduzece") String nazivPreduzeca) {
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		Preduzece preduzece2 = preduzeceServiceInterface.findOne(preduzece.getIdPreduzeca());
		

		if(nazivPoslovnogPartnera == null || adresa == null || telefon == null || email == null || vrstaPartnera == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		PoslovniPartner partner = new PoslovniPartner();
		partner.setNazivPoslovnogPartnera(nazivPoslovnogPartnera);
		partner.setAdresa(adresa);
		partner.setTelefon(telefon);
		partner.setFax(fax);
		partner.setEmail(email);
		partner.setVrstaPartnera(vrstaPartnera);
		partner.setNaseljenoMesto(mesto);
		partner.setPreduzece(preduzece2);
		poslovniPartnerServiceInterface.save(partner);
		
		System.out.println("Dodat je novi poslovni partner");
	
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniPoslovnogPartnera", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	public ResponseEntity<Void> izmeniPoslovnogPartnera(@RequestParam("id") long id,
			@RequestParam("naziv_poslovnog_partnera") String nazivPoslovnogPartnera,
			@RequestParam("adresa") String adresa, 
			@RequestParam("telefon") String telefon,
			@RequestParam("fax") String fax, 
			@RequestParam("email") String email, 
			@RequestParam("vrsta_partnera") String vrstaPartnera,
			@RequestParam("mesto") String nazivMesta, @RequestParam("preduzece") String nazivPreduzeca){
		
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findOne(id);
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findByNazivMesta(nazivMesta);
		
		Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
		
		if(partner != null) {
			partner.setIdPoslovnogPartnera(id);
			partner.setNazivPoslovnogPartnera(nazivPoslovnogPartnera);
			partner.setAdresa(adresa);
			partner.setTelefon(telefon);
			partner.setFax(fax);
			partner.setEmail(email);
			partner.setVrstaPartnera(vrstaPartnera);
			partner.setNaseljenoMesto(mesto);
			partner.setPreduzece(preduzece);
			poslovniPartnerServiceInterface.save(partner);
			
			System.out.println("Izmenjen je poslovni partner");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(path = "/obrisiPoslovnogPartnera/{id}")
	public ResponseEntity<Void> obrisiPoslovnogPartnera(@PathVariable("id") long id) {
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findOne(id);
		
		if(partner == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		poslovniPartnerServiceInterface.remove(partner.getIdPoslovnogPartnera());
		
		System.out.println("Izbrisan je poslovni partner");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
