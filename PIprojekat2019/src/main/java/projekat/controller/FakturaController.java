package projekat.controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import projekat.model.StavkaFakture;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.StavkaFaktureServiceInterface;



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
	
	@Autowired
	private StavkaFaktureServiceInterface stavkaFaktureServiceInterface;
	
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
			@RequestParam("ukupan_iznos") String ukupanIznos, @RequestParam("status_fakture") String statusFakture, 
			@RequestParam("stavka_fakture") String stavkaFakture, @RequestParam("poslovna_godina") String poslovnaGodina,
			@RequestParam("poslovni_partner") String nazivPoslovnogPartnera, @RequestParam("preduzece") String nazivPreduzeca) throws ParseException {
		
		System.out.println("Broj fakture: " + brojFakture);
		System.out.println("Datum fakture: " + datumFakture);
		System.out.println("Datum valute: " + datumValute);
		System.out.println("Ukupna osnovica: " + ukupnaOsnovica);
		System.out.println("Ukupan pdv: " + ukupanPdv);
		System.out.println("Ukupan iznos: " + ukupanIznos);
		System.out.println("Status fakture: " + statusFakture);
		System.out.println("Stavka fakture: " + stavkaFakture);
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
	    int jedinicnaCena = Integer.parseInt(stavkaFakture);
	    
	    StavkaFakture stavkaFakture2 = stavkaFaktureServiceInterface.findByJedinicnaCena(jedinicnaCena);
	    
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
		faktura.setStatusFakture(statusFakture);
		faktura.setStavkaFakture(stavkaFakture2);
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
	    
	    int stavkaFaktureInt = Integer.parseInt(stavkaFakture);
	    
	    StavkaFakture stavkaFakture2 = stavkaFaktureServiceInterface.findByJedinicnaCena(stavkaFaktureInt);
	    
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
			faktura.setStatusFakture(statusFakture);
			faktura.setStavkaFakture(stavkaFakture2);
			faktura.setPoslovnaGodina(poslovnaGodina2);
			faktura.setPoslovniPartner(partner);
			faktura.setPreduzece(preduzece);
			
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
	
	@GetMapping(path = "/fakturaSaStavkamaTabela")
	public List<Faktura> fakturaSaStavkamaTabela() {
		
		List<Faktura> fakture = new ArrayList<Faktura>();
		try {
			
			Connection conn = null;
			Statement stmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			stmt = conn.createStatement();
			String query = "SELECT * FROM faktura, stavka_fakture, poslovna_godina, poslovni_partner, preduzece WHERE faktura.id_stavke_fakture = stavka_fakture.id_stavke "
					+ "AND faktura.id_godine = poslovna_godina.id_godine AND faktura.id_poslovnog_partnera = poslovni_partner.id_poslovnog_partnera AND faktura.id_preduzeca = preduzece.id_preduzeca";
			
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Long idFakture = rset.getLong("id_fakture");
				int brojFakture = rset.getInt("broj_fakture");
				Date datumFakture = rset.getDate("datum_fakture");
				Date datumValute = rset.getDate("datum_valute");
				double ukupnaOsnovica = rset.getDouble("ukupna_osnovica");
				double ukupanPDV = rset.getDouble("ukupan_pdv");
				double ukupanIznos = rset.getDouble("ukupan_iznos");
				String statusFakture = rset.getString("status_fakture");
				
				Long idStavkeFakture = rset.getLong("id_stavke_fakture");
				double kolicina =  rset.getDouble("kolicina");
				double rabat = rset.getDouble("rabat");
				double jedinicnaCena = rset.getDouble("jedinicna_cena");
				double pdvStopa = rset.getDouble("pdv_stopa");
				double osnovicaZaPDV = rset.getDouble("osnovica_za_pdv");
				double iznosPDV = rset.getDouble("iznos_pdv");
				double ukupanIznosStavke = rset.getDouble("ukupan_iznos");
				
				Long idGodine = rset.getLong("id_godine");
				int godina = rset.getInt("godina");
				
				Faktura faktura = new Faktura();
				faktura.setIdFakture(idFakture);
				faktura.setBrojFakture(brojFakture);
				faktura.setDatumFakture(datumFakture);
				faktura.setDatumValute(datumValute);
				faktura.setUkupnaOsnovica(ukupnaOsnovica);
				faktura.setUkupanPDV(ukupanPDV);
				faktura.setUkupanIznos(ukupanIznos);
				faktura.setStatusFakture(statusFakture);
				
				StavkaFakture stavkaFakture = new StavkaFakture();
				stavkaFakture.setIdStavke(idStavkeFakture);
				stavkaFakture.setKolicina(kolicina);
				stavkaFakture.setRabat(rabat);
				stavkaFakture.setJedinicnaCena(jedinicnaCena);
				stavkaFakture.setPdvStopa(pdvStopa);
				stavkaFakture.setOsnovicaZaPDV(osnovicaZaPDV);
				stavkaFakture.setIznosPDV(iznosPDV);
				stavkaFakture.setUkupanIznos(ukupanIznosStavke);
				
				PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
				poslovnaGodina.setIdGodine(idGodine);
				poslovnaGodina.setGodina(godina);
				faktura.setStavkaFakture(stavkaFakture);
				faktura.setPoslovnaGodina(poslovnaGodina);
				fakture.add(faktura);
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fakture;
		
		
	}
	
	@PostMapping(path = "/KIFtabela")
	public List<Faktura> KIFtabela(@RequestParam("datum_fakture_tabela") String datumFaktureString) {
		
		List<Faktura> fakture = new ArrayList<Faktura>();
		
		try {

			Connection conn = null;
			PreparedStatement pstmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			String query = "SELECT * FROM faktura f, stavka_fakture s, poslovna_godina, poslovni_partner, preduzece WHERE f.id_stavke_fakture = s.id_stavke AND f.datum_fakture = ?"
					+ "AND f.id_godine = poslovna_godina.id_godine AND f.id_poslovnog_partnera = poslovni_partner.id_poslovnog_partnera AND f.id_preduzeca = preduzece.id_preduzeca";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, datumFaktureString);
			
			ResultSet rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Long idFakture = rset.getLong("id_fakture");
				int brojFakture = rset.getInt("broj_fakture");
				Date datumFakture = rset.getDate("datum_fakture");
				Date datumValute = rset.getDate("datum_valute");
				double ukupnaOsnovica = rset.getDouble("ukupna_osnovica");
				double ukupanPDV = rset.getDouble("ukupan_pdv");
				double ukupanIznos = rset.getDouble("ukupan_iznos");
				String statusFakture = rset.getString("status_fakture");
				
				Long idStavkeFakture = rset.getLong("id_stavke_fakture");
				double kolicina =  rset.getDouble("kolicina");
				double rabat = rset.getDouble("rabat");
				double jedinicnaCena = rset.getDouble("jedinicna_cena");
				double pdvStopa = rset.getDouble("pdv_stopa");
				double osnovicaZaPDV = rset.getDouble("osnovica_za_pdv");
				double iznosPDV = rset.getDouble("iznos_pdv");
				double ukupanIznosStavke = rset.getDouble("ukupan_iznos");
				
				Long idGodine = rset.getLong("id_godine");
				int godina = rset.getInt("godina");
				
				Faktura faktura = new Faktura();
				faktura.setIdFakture(idFakture);
				faktura.setBrojFakture(brojFakture);
				faktura.setDatumFakture(datumFakture);
				faktura.setDatumValute(datumValute);
				faktura.setUkupnaOsnovica(ukupnaOsnovica);
				faktura.setUkupanPDV(ukupanPDV);
				faktura.setUkupanIznos(ukupanIznos);
				faktura.setStatusFakture(statusFakture);
				
				StavkaFakture stavkaFakture = new StavkaFakture();
				stavkaFakture.setIdStavke(idStavkeFakture);
				stavkaFakture.setKolicina(kolicina);
				stavkaFakture.setRabat(rabat);
				stavkaFakture.setJedinicnaCena(jedinicnaCena);
				stavkaFakture.setPdvStopa(pdvStopa);
				stavkaFakture.setOsnovicaZaPDV(osnovicaZaPDV);
				stavkaFakture.setIznosPDV(iznosPDV);
				stavkaFakture.setUkupanIznos(ukupanIznosStavke);
				
				PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
				poslovnaGodina.setIdGodine(idGodine);
				poslovnaGodina.setGodina(godina);
				faktura.setStavkaFakture(stavkaFakture);
				faktura.setPoslovnaGodina(poslovnaGodina);
				fakture.add(faktura);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return fakture;
		
	}
}
