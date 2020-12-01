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

import projekat.model.GrupaRobeUsluga;
import projekat.model.KupljeniProizvod;
import projekat.model.RobaUsluga;
import projekat.model.StavkaFakture;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;
import projekat.service.intrfc.KupljeniProizvodServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;
import projekat.service.intrfc.StavkaFaktureServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/kupljeni_proizvod")
public class KupljeniProizvodController {
	
	@Autowired
	private KupljeniProizvodServiceInterface kupljeniProizvodServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Autowired
	private StavkaFaktureServiceInterface stavkaFaktureServiceInterface;
	
	@Autowired
	private GrupaRobeUslugaServiceInterface grupaRobeUslugaServiceInterface;
	
	@GetMapping(path = "/all")
	public List<KupljeniProizvod> getAll() {
		return kupljeniProizvodServiceInterface.findAll();
	}
	
	@PostMapping(path = "/kupovina")
	public ResponseEntity<Void> kupovina(@RequestParam("naziv") String naziv, @RequestParam("cena") String cena, @RequestParam("opis") String opis,
			@RequestParam("kolicina") String kolicina, @RequestParam("kupac") String kupac) {
		
		
		double cenaDouble = Double.parseDouble(cena);
		double kolicinaDouble = Double.parseDouble(kolicina);
		
		KupljeniProizvod kupljeniProizvod = new KupljeniProizvod();
		kupljeniProizvod.setNaziv(naziv);
		kupljeniProizvod.setCena(cenaDouble);
		kupljeniProizvod.setOpis(opis);
		kupljeniProizvod.setKolicina(kolicinaDouble);
		kupljeniProizvod.setKupac(kupac);
		kupljeniProizvodServiceInterface.save(kupljeniProizvod);
		
		GrupaRobeUsluga grupaRobeUsluga = new GrupaRobeUsluga();
		grupaRobeUsluga.setNazivGrupe("kupljeno");
		grupaRobeUslugaServiceInterface.save(grupaRobeUsluga);
		
		RobaUsluga robaUsluga = new RobaUsluga();
		robaUsluga.setNazivRobeUsluge(naziv);
		robaUsluga.setOpis(opis);
		robaUsluga.setRoba(true);
		robaUsluga.setGrupaRobeUsluga(grupaRobeUsluga);
		//robaUsluga.setJedinicaMere();
		robaUslugaServiceInterface.save(robaUsluga);
		
		StavkaFakture stavkaFakture = new StavkaFakture();
		stavkaFakture.setKolicina(kolicinaDouble);
		stavkaFakture.setRabat(cenaDouble);
		stavkaFakture.setJedinicnaCena(cenaDouble);
		stavkaFakture.setPdvStopa(0);
		stavkaFakture.setOsnovicaZaPDV(cenaDouble);
		stavkaFakture.setIznosPDV(0);
		stavkaFakture.setUkupanIznos(cenaDouble);
		stavkaFakture.setRobaUsluga(robaUsluga);
		stavkaFaktureServiceInterface.save(stavkaFakture);
		
		
		System.out.println("Kupljen je proizvod");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
