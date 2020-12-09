package projekat.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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

import projekat.model.Faktura;
import projekat.model.Narudzbenica;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.model.StavkaFakture;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.NarudzbenicaServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.StavkaFaktureServiceInterface;

@CrossOrigin
@RestController
@RequestMapping(value = "api/narudzbenica")
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
	
	@GetMapping(path = "/all")
	public List<Narudzbenica> getAll() {
		return narudzbenicaServiceInterface.findAll();
	}
	
	@GetMapping(path = "/fakturaNarudzbenicaTable")
	public List<Narudzbenica> fakturaSaNarudzbenicom() {
		
		List<Narudzbenica> narudzbenice = new ArrayList<Narudzbenica>();
		try {
			
			Connection conn = null;
			Statement stmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			stmt = conn.createStatement();
			String query = "SELECT * FROM  narudzbenica n, faktura f, poslovna_godina, poslovni_partner, preduzece WHERE n.id_fakture = f.id_fakture "
					+ "AND f.id_godine = poslovna_godina.id_godine AND f.id_poslovnog_partnera = poslovni_partner.id_poslovnog_partnera AND f.id_preduzeca = preduzece.id_preduzeca";
			
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Long id  = rset.getLong("narudzbenica_id");
				String nazivRobe = rset.getString("naziv_robe");
				String jedinica_mere = rset.getString("jedinica_mere");
				double cena = rset.getDouble("cena");
				double kolicina = rset.getDouble("kolicina");
				double iznos = rset.getDouble("iznos");
				
				Long idFakture = rset.getLong("id_fakture");
				int brojFakture = rset.getInt("broj_fakture");
				Date datumFakture = rset.getDate("datum_fakture");
				Date datumValute = rset.getDate("datum_valute");
				double ukupnaOsnovica = rset.getDouble("ukupna_osnovica");
				double ukupanPDV = rset.getDouble("ukupan_pdv");
				double ukupanIznos = rset.getDouble("ukupan_iznos");
				String statusFakture = rset.getString("status_fakture");
				
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
				
				PoslovnaGodina poslovnaGodina = new PoslovnaGodina();
				poslovnaGodina.setIdGodine(idGodine);
				poslovnaGodina.setGodina(godina);
				faktura.setPoslovnaGodina(poslovnaGodina);
			
				Narudzbenica narudzbenica = new Narudzbenica();

				

				narudzbenice.add(narudzbenica);
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return narudzbenice;
	}
	
	@PostMapping(path = "/fakturaINarudzbenica")
	public ResponseEntity<Void> fakturaINarudzbenica(
			@RequestParam("broj_fakture") String brojFakture, 
			@RequestParam("datum_fakture") String datumFakture, @RequestParam("datum_valute") String datumValute,
			@RequestParam("ukupna_osnovica") String ukupnaOsnovica, @RequestParam("ukupan_pdv") String ukupanPdv, 
			@RequestParam("ukupan_iznos") String ukupanIznos, @RequestParam("status_fakture") String statusFakture, 
			@RequestParam("stavka_fakture") String stavkaFakture, @RequestParam("poslovna_godina") String poslovnaGodina,
			@RequestParam("poslovni_partner") String nazivPoslovnogPartnera, @RequestParam("preduzece") String nazivPreduzeca, 
			@RequestParam("naziv") String nazivRobe, @RequestParam("jedinica_mere") String jedinicaMere, 
			@RequestParam("kolicina") String kolicina,@RequestParam("cena") String cena, 
			@RequestParam("iznos") String iznos) throws ParseException {
		
		
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
		faktura.setPoslovnaGodina(poslovnaGodina2);
		faktura.setPoslovniPartner(partner);
		faktura.setPreduzece(preduzece);
		fakturaServiceInterface.save(faktura);
		
		double cenaDouble = Double.parseDouble(cena);
		double kolicinaDouble = Double.parseDouble(kolicina);
		double iznosDouble = Double.parseDouble(iznos);
		
		Narudzbenica narudzbenica = new Narudzbenica();
		narudzbenicaServiceInterface.save(narudzbenica);
		
		System.out.println("Dodata je faktura sa narudzbenicom");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
}
