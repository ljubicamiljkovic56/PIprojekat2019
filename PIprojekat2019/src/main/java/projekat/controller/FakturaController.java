package projekat.controller;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import projekat.model.Faktura;
import projekat.service.intrfc.FakturaServiceInterface;



@CrossOrigin
@RestController
@RequestMapping(value = "api/fakture")
@ControllerAdvice
public class FakturaController {
	
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
//	@Autowired
//	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
//	
//	@Autowired
//	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
//	
//	@Autowired
//	private PreduzeceServiceInterface preduzeceServiceInterface;
//	
//	@Autowired
//	private StavkaFaktureServiceInterface stavkaFaktureServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Faktura> getAll() {
		return fakturaServiceInterface.findAll();
	}
	
//	@PostMapping(path =  "/dodajFakturu")
//	public ResponseEntity<Void> dodajFakturu(@RequestParam("broj_fakture") String brojFakture, 
//			@RequestParam("datum_fakture") String datumFakture, @RequestParam("datum_valute") String datumValute,
//			@RequestParam("ukupna_osnovica") String ukupnaOsnovica, @RequestParam("ukupan_pdv") String ukupanPdv, 
//			@RequestParam("ukupan_iznos") String ukupanIznos, @RequestParam("status_fakture") String statusFakture, 
//			@RequestParam("stavka_fakture") String stavkaFakture, @RequestParam("poslovna_godina") String poslovnaGodina,
//			@RequestParam("poslovni_partner") String nazivPoslovnogPartnera, @RequestParam("preduzece") String nazivPreduzeca) throws ParseException {
//		
//		System.out.println("Broj fakture: " + brojFakture);
//		System.out.println("Datum fakture: " + datumFakture);
//		System.out.println("Datum valute: " + datumValute);
//		System.out.println("Ukupna osnovica: " + ukupnaOsnovica);
//		System.out.println("Ukupan pdv: " + ukupanPdv);
//		System.out.println("Ukupan iznos: " + ukupanIznos);
//		System.out.println("Status fakture: " + statusFakture);
//		System.out.println("Stavka fakture: " + stavkaFakture);
//		System.out.println("Poslovna godina: " + poslovnaGodina);
//		System.out.println("Poslovni partner: " + nazivPoslovnogPartnera);
//		System.out.println("Preduzece: " + nazivPreduzeca);
//		
//		int brojFaktureInt = Integer.parseInt(brojFakture);
//		
//		String datum = datumFakture;
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = formatter.parse(datum);
//	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//	    
//	    String datum2 = datumValute;
//		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date2 = formatter2.parse(datum2);
//	    java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
//	    
//	    double ukupnaOsnovicaDouble = Double.parseDouble(ukupnaOsnovica);
//	    double ukupanPdvDouble = Double.parseDouble(ukupanPdv);
//	    double ukupanIznosDouble = Double.parseDouble(ukupanIznos);
//	    
//	    int godinaInt = Integer.parseInt(poslovnaGodina);
//	    int jedinicnaCena = Integer.parseInt(stavkaFakture);
//	    
//	    StavkaFakture stavkaFakture2 = stavkaFaktureServiceInterface.findByJedinicnaCena(jedinicnaCena);
//	    
//	    PoslovnaGodina poslovnaGodina2 = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
//	    
//	    PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
//	    
//	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
//		
//		Faktura faktura = new Faktura();
//		faktura.setBrojFakture(brojFaktureInt);
//		faktura.setDatumFakture(sqlDate);
//		faktura.setDatumValute(sqlDate2);
//		faktura.setUkupnaOsnovica(ukupnaOsnovicaDouble);
//		faktura.setUkupanPDV(ukupanPdvDouble);
//		faktura.setUkupanIznos(ukupanIznosDouble);
//		faktura.setStatusFakture(statusFakture);
////		faktura.setStavkaFakture(stavkaFakture2);
//		faktura.setPoslovnaGodina(poslovnaGodina2);
//		faktura.setPoslovniPartner(partner);
//		faktura.setPreduzece(preduzece);
//		fakturaServiceInterface.save(faktura);
//		
//		System.out.println("Dodata ja faktura");
//		
//		return new ResponseEntity<Void>(HttpStatus.OK);
//		
//	}
//	
//	@PostMapping(path = "/izmeniFakturu")
//	public ResponseEntity<Void> izmeniFakturu(@RequestParam("broj_fakture") String brojFakture, @RequestParam("novi_broj") String noviBroj,
//			@RequestParam("datum_fakture") String datumFakture, @RequestParam("datum_valute") String datumValute,
//			@RequestParam("ukupna_osnovica") String ukupnaOsnovica, @RequestParam("ukupan_pdv") String ukupanPdv, 
//			@RequestParam("ukupan_iznos") String ukupanIznos, @RequestParam("status_fakture") String statusFakture, 
//			@RequestParam("stavka_fakture") String stavkaFakture, @RequestParam("poslovna_godina") String poslovnaGodina,
//			@RequestParam("poslovni_partner") String nazivPoslovnogPartnera, @RequestParam("preduzece") String nazivPreduzeca) throws ParseException{
//		
//		int brojFaktureInt = Integer.parseInt(brojFakture);
//		
//		Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
//		
//		int noviBrojInt = Integer.parseInt(noviBroj);
//		
//		String datum = datumFakture;
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = formatter.parse(datum);
//	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//	    
//	    String datum2 = datumValute;
//		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date2 = formatter2.parse(datum2);
//	    java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
//	    
//	    double ukupnaOsnovicaDouble = Double.parseDouble(ukupnaOsnovica);
//	    double ukupanPdvDouble = Double.parseDouble(ukupanPdv);
//	    double ukupanIznosDouble = Double.parseDouble(ukupanIznos);
//	    
//	    int godinaInt = Integer.parseInt(poslovnaGodina);
//	    
//	    int stavkaFaktureInt = Integer.parseInt(stavkaFakture);
//	    
//	    StavkaFakture stavkaFakture2 = stavkaFaktureServiceInterface.findByJedinicnaCena(stavkaFaktureInt);
//	    
//	    PoslovnaGodina poslovnaGodina2 = poslovnaGodinaServiceInterface.findByGodina(godinaInt);
//	    
//	    PoslovniPartner partner = poslovniPartnerServiceInterface.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
//	    
//	    Preduzece preduzece = preduzeceServiceInterface.findByNazivPreduzeca(nazivPreduzeca);
//		
//		if(faktura != null) {
//			faktura.setBrojFakture(noviBrojInt);
//			faktura.setDatumFakture(sqlDate);
//			faktura.setDatumValute(sqlDate2);
//			faktura.setUkupnaOsnovica(ukupnaOsnovicaDouble);
//			faktura.setUkupanPDV(ukupanPdvDouble);
//			faktura.setUkupanIznos(ukupanIznosDouble);
//			faktura.setStatusFakture(statusFakture);
//		//	faktura.setStavkaFakture(stavkaFakture2);
//			faktura.setPoslovnaGodina(poslovnaGodina2);
//			faktura.setPoslovniPartner(partner);
//			faktura.setPreduzece(preduzece);
//			
//			fakturaServiceInterface.save(faktura);
//			
//			System.out.println("Izmenjena je faktura.");
//			
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//		
//		
//	}
	
	
	@DeleteMapping(path = "/obrisiFakturu/{id}")
	public ResponseEntity<Void> obrisiFakturu(@PathVariable("id") long id) {
		
		Faktura faktura = fakturaServiceInterface.findOne(id);
		
		if(faktura == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		fakturaServiceInterface.remove(faktura.getIdFakture());
		
		System.out.println("Obrisana je faktura.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/stornirajFakturu")
	public ResponseEntity<Void> stornirajFakturu(@RequestParam("broj_fakture") String brojFakture) {
		
		int brojFaktureInt = Integer.parseInt(brojFakture);
		
		Faktura faktura1 = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		Faktura faktura = fakturaServiceInterface.findOne(faktura1.getIdFakture());
		
		if(faktura != null) {
			faktura.setBrojFakture(faktura.getBrojFakture());
			faktura.setDatumFakture(faktura.getDatumFakture());
			faktura.setDatumValute(faktura.getDatumValute());
			faktura.setUkupnaOsnovica(faktura.getUkupnaOsnovica());
			faktura.setUkupanPDV(faktura.getUkupanPDV());
			faktura.setUkupanIznos(faktura.getUkupanIznos());
			faktura.setStatusFakture("S");
			faktura.setPoslovnaGodina(faktura.getPoslovnaGodina());
			faktura.setPoslovniPartner(faktura.getPoslovniPartner());
			faktura.setPreduzece(faktura.getPreduzece());
			fakturaServiceInterface.save(faktura);
			
			System.out.println("Faktura stornirana");

			return new ResponseEntity<Void>(HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PostMapping(path = "/exportFakture")
	public ResponseEntity<Void> generateFakturaBrojFakture(@RequestParam("broj_fakture") String brojFaktureString){
		
//		int brojFaktureInt = Integer.parseInt(brojFaktureString);
//		
//		Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			String query = "SELECT * FROM faktura f, stavka_fakture s, poslovna_godina, poslovni_partner, preduzece, roba_usluga, naseljeno_mesto WHERE f.broj_fakture = ?"
					+ "AND f.id_godine = poslovna_godina.id_godine "
					+ "AND f.id_poslovnog_partnera = poslovni_partner.id_poslovnog_partnera "
					+ "AND f.id_preduzeca = preduzece.id_preduzeca "
					+ "AND f.id_fakture = s.id_fakture "
					+ "AND s.id_robe = roba_usluga.id_robe_usluge "
					+ "AND preduzece.id_mesta = naseljeno_mesto.id_mesta";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, brojFaktureString);
			ResultSet rset = pstmt.executeQuery();
			
			String path = "C:\\Users\\Ljubica\\Downloads\\xml_export_fakture";
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document doc = documentBuilder.newDocument();
			
			Element el = doc.createElement("fakturaExport");
			doc.appendChild(el);
			
			int iRows = 0;
			int stavkaRow = 0;
			int GodinaRow = 0;
			int PartnerRow = 0;
			int PreduzeceRow = 0;
			while((rset != null) && (rset.next())) {
				
				++iRows;
				Element sRows = doc.createElement("Faktura");
				
				Attr id = doc.createAttribute("id");
				id.setValue(String.valueOf(iRows));
				sRows.setAttributeNode(id);
				
				Element idFakture = doc.createElement("idFakture");
				idFakture.appendChild(doc.createTextNode(rset.getString("id_fakture")));
				sRows.appendChild(idFakture);
				
				Element brojFakture = doc.createElement("brojFakture");
				brojFakture.appendChild(doc.createTextNode(rset.getString("broj_fakture")));
				sRows.appendChild(brojFakture);
				
				Element datumFakture = doc.createElement("datumFakture");
				datumFakture.appendChild(doc.createTextNode(rset.getString("datum_fakture")));
				sRows.appendChild(datumFakture);
				
				Element datumValute = doc.createElement("datumValute");
				datumValute.appendChild(doc.createTextNode(rset.getString("datum_valute")));
				sRows.appendChild(datumValute);
				
				Element ukupnaOsnovica = doc.createElement("ukupnaOsnovica");
				ukupnaOsnovica.appendChild(doc.createTextNode(rset.getString("ukupna_osnovica")));
				sRows.appendChild(ukupnaOsnovica);
				
				Element ukupanPDV = doc.createElement("ukupanPDV");
				ukupanPDV.appendChild(doc.createTextNode(rset.getString("ukupan_pdv")));
				sRows.appendChild(ukupanPDV);
				
				Element ukupanIznos = doc.createElement("ukupan_iznos");
				ukupanIznos.appendChild(doc.createTextNode(rset.getString("ukupan_iznos")));
				sRows.appendChild(ukupanIznos);
				
				Element statusFakture = doc.createElement("statusFakture");
				statusFakture.appendChild(doc.createTextNode(rset.getString("status_fakture")));
				sRows.appendChild(statusFakture);
				
				++stavkaRow;
				Element stavkaElement = doc.createElement("stavkaFakture");
				
				Attr idStavke = doc.createAttribute("idStavke");
				idStavke.setValue(String.valueOf(stavkaRow));
				stavkaElement.setAttributeNode(idStavke);	
			
				Element idStavkeFakture = doc.createElement("idStavkeFakture");
				idStavkeFakture.appendChild(doc.createTextNode(rset.getString("id_stavke")));
				stavkaElement.appendChild(idStavkeFakture);
				
				Element kolicina = doc.createElement("kolicina");
				kolicina.appendChild(doc.createTextNode(rset.getString("kolicina")));
				stavkaElement.appendChild(kolicina);
				
				Element rabat = doc.createElement("rabat");
				rabat.appendChild(doc.createTextNode(rset.getString("rabat")));
				stavkaElement.appendChild(rabat);

				Element jedinicnaCena = doc.createElement("jedinicnaCena");
				jedinicnaCena.appendChild(doc.createTextNode(rset.getString("jedinicna_cena")));
				stavkaElement.appendChild(jedinicnaCena);
				
				Element pdvStopa = doc.createElement("pdvStopa");
				pdvStopa.appendChild(doc.createTextNode(rset.getString("pdv_stopa")));
				stavkaElement.appendChild(pdvStopa);
			
				Element osnovicaPDV = doc.createElement("osnovicaPDV");
				osnovicaPDV.appendChild(doc.createTextNode(rset.getString("osnovica_za_pdv")));
				stavkaElement.appendChild(osnovicaPDV);

				Element iznosPDV = doc.createElement("iznosPDV");
				iznosPDV.appendChild(doc.createTextNode(rset.getString("iznos_pdv")));
				stavkaElement.appendChild(iznosPDV);
				
				Element ukupanIznosStavke = doc.createElement("ukupanIznos");
				ukupanIznosStavke.appendChild(doc.createTextNode(rset.getString("ukupan_iznos")));
				stavkaElement.appendChild(ukupanIznosStavke);
				
				Element idRobeUsluge = doc.createElement("idRobeUsluge");
				idRobeUsluge.appendChild(doc.createTextNode(rset.getString("id_robe")));
				stavkaElement.appendChild(idRobeUsluge);
				
				Element nazivRobeUsluge = doc.createElement("nazivRobeUsluge");
				nazivRobeUsluge.appendChild(doc.createTextNode(rset.getString("naziv_robe_usluge")));
				stavkaElement.appendChild(nazivRobeUsluge);
				
				sRows.appendChild(stavkaElement);
				
				
				++GodinaRow;
				Element godinaElement = doc.createElement("godinaFakture");
				
				Attr idGodine = doc.createAttribute("idGodine");
				idGodine.setValue(String.valueOf(GodinaRow));
				godinaElement.setAttributeNode(idGodine);
				
				Element idPoslovnaGodina = doc.createElement("IdPoslovnaGodina");
				idPoslovnaGodina.appendChild(doc.createTextNode(rset.getString("id_godine")));
				godinaElement.appendChild(idPoslovnaGodina);
				
				Element godina = doc.createElement("godina");
				godina.appendChild(doc.createTextNode(rset.getString("godina")));
				godinaElement.appendChild(godina);
				
				Element zakljucena = doc.createElement("zakljucena");
				zakljucena.appendChild(doc.createTextNode(rset.getString("zakljucena")));
				godinaElement.appendChild(zakljucena);
				
				sRows.appendChild(godinaElement);
				
				++PartnerRow;
				Element partnerElement = doc.createElement("partner");
				
				Attr idPartnera = doc.createAttribute("idPartnera");
				idPartnera.setValue(String.valueOf(PartnerRow));
				partnerElement.setAttributeNode(idPartnera);
				
				Element poslovniPartner = doc.createElement("poslovniPartner");
				poslovniPartner.appendChild(doc.createTextNode(rset.getString("id_poslovnog_partnera")));
				partnerElement.appendChild(poslovniPartner);
				
				Element nazivPoslovnogPartnera = doc.createElement("nazivPoslovnogPartnera");
				nazivPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("naziv_poslovnog_partnera")));
				partnerElement.appendChild(nazivPoslovnogPartnera);
				
				Element adresaPoslovnogPartnera = doc.createElement("adresaPoslovnogPartnera");
				adresaPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("adresa")));
				partnerElement.appendChild(adresaPoslovnogPartnera);
				
				Element telefonPoslovnogPartnera = doc.createElement("telefonPoslovnogPartnera");
				telefonPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("telefon")));
				partnerElement.appendChild(telefonPoslovnogPartnera);
				
				Element faxPoslovnogPartnera = doc.createElement("faxPoslovnogPartnera");
				faxPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("fax")));
				partnerElement.appendChild(faxPoslovnogPartnera);
				
				Element emailPoslovnogPartnera = doc.createElement("emailPoslovnogPartnera");
				emailPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("email")));
				partnerElement.appendChild(emailPoslovnogPartnera);
				
				Element vrstaPoslovnogPartnera = doc.createElement("vrstaPoslovnogPartnera");
				vrstaPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("vrsta_partnera")));
				partnerElement.appendChild(vrstaPoslovnogPartnera);
				
				Element idMestaPoslovnogPartnera = doc.createElement("idMestaPoslovnogPartnera");
				idMestaPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("id_mesta")));
				partnerElement.appendChild(idMestaPoslovnogPartnera);
				
				Element nazivMestaPoslovnogPartnera = doc.createElement("nazivMestaPoslovnogPartnera");
				nazivMestaPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("naziv_mesta")));
				partnerElement.appendChild(nazivMestaPoslovnogPartnera);
				
				Element pttBrojMestaPoslovnogPartnera = doc.createElement("pttBrojMestaPoslovnogPartnera");
				pttBrojMestaPoslovnogPartnera.appendChild(doc.createTextNode(rset.getString("ptt_broj")));
				partnerElement.appendChild(pttBrojMestaPoslovnogPartnera);
				
				sRows.appendChild(partnerElement);
				
				++PreduzeceRow;
				Element preduzeceElement = doc.createElement("preduzece");
				
				Attr idPreduzeca = doc.createAttribute("idPreduzeca");
				idPreduzeca.setValue(String.valueOf(PreduzeceRow));
				preduzeceElement.setAttributeNode(idPreduzeca);
				
				Element preduzece = doc.createElement("preduzece");
				preduzece.appendChild(doc.createTextNode(rset.getString("id_preduzeca")));
				preduzeceElement.appendChild(preduzece);
				
				Element nazivPreduzeca = doc.createElement("nazivPreduzeca");
				nazivPreduzeca.appendChild(doc.createTextNode(rset.getString("naziv_preduzeca")));
				preduzeceElement.appendChild(nazivPreduzeca);
				
				Element adresaPreduzeca = doc.createElement("adresaPreduzeca");
				adresaPreduzeca.appendChild(doc.createTextNode(rset.getString("adresa_preduzeca")));
				preduzeceElement.appendChild(adresaPreduzeca);
				
				Element brojTelefonaPreduzeca = doc.createElement("brojTelefonaPreduzeca");
				brojTelefonaPreduzeca.appendChild(doc.createTextNode(rset.getString("broj_telefona")));
				preduzeceElement.appendChild(brojTelefonaPreduzeca);
				
				Element faxPreduzeca = doc.createElement("faxPreduzeca");
				faxPreduzeca.appendChild(doc.createTextNode(rset.getString("fax_preduzeca")));
				preduzeceElement.appendChild(faxPreduzeca);
				
				Element idMestaPreduzeca = doc.createElement("idMestaPreduzeca");
				idMestaPreduzeca.appendChild(doc.createTextNode(rset.getString("id_mesta")));
				preduzeceElement.appendChild(idMestaPreduzeca);
				
				Element nazivMestaPreduzeca = doc.createElement("nazivMestaPreduzeca");
				nazivMestaPreduzeca.appendChild(doc.createTextNode(rset.getString("naziv_mesta")));
				preduzeceElement.appendChild(nazivMestaPreduzeca);
				
				Element pttBrojMestaPreduzeca = doc.createElement("pttBrojMestaPreduzeca");
				pttBrojMestaPreduzeca.appendChild(doc.createTextNode(rset.getString("ptt_broj")));
				preduzeceElement.appendChild(pttBrojMestaPreduzeca);
				
				sRows.appendChild(preduzeceElement);
				
				
				el.appendChild(sRows);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(path, "fakturaExport.xml").getPath());
			
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					 
			transformer.transform(domSource, streamResult);
					 
			System.out.println("XML file created!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
