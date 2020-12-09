package projekat.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import projekat.dto.OtpremnicaDTO;
import projekat.model.Faktura;
import projekat.model.Otpremnica;
import projekat.model.StavkaOtpremnice;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.OtpremnicaServiceInterface;
import projekat.service.intrfc.StavkaOtpremniceServiceInterface;



@CrossOrigin
@RestController
@RequestMapping(value = "api/otpremnice")
public class OtpremnicaController {
	
	@Autowired
	private OtpremnicaServiceInterface otpremnicaServiceInterface;
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
	@Autowired
	private StavkaOtpremniceServiceInterface stavkaOtpremniceServiceInterface;
	
	@GetMapping(path = "/all")
	public List<Otpremnica> getAll() {
		return otpremnicaServiceInterface.findAll();
	}
	
//	@PostMapping(path = "/pojedinacnaOtpremnica")
//	public ResponseEntity<OtpremnicaDTO> pojedinacnaOtpremnica(@RequestParam("broj_otpremnice") String brojOtpremnice) {
//		
//		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
//		
//		Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
//		
//		if(otpremnica == null) {
//			return new ResponseEntity<OtpremnicaDTO>(HttpStatus.BAD_REQUEST);
//		}else {
//			return new ResponseEntity<OtpremnicaDTO>(new OtpremnicaDTO(otpremnica), HttpStatus.OK);
//		}
//	}
	
	@PostMapping(path = "/dodajOtpremnicu")
	public ResponseEntity<Void> dodajOtpremnicu(@RequestParam("broj_otpremnice") String brojOtpremnice, 
			@RequestParam("kupac") String kupac, @RequestParam("adresa_isporuke") String adresaIsporuke, 
			@RequestParam("datum_isporuke") String datumIsporuke, @RequestParam("prevoznik") String prevoznik,
			@RequestParam("faktura") String brojFakture, @RequestParam("redni_broj_proizvoda") String stavkaOtpremnice) throws ParseException {
		
		System.out.println("Broj otpremnice: " + brojOtpremnice);
		System.out.println("Kupac: " + kupac);
		System.out.println("Adresa isporuke: " + adresaIsporuke);
		System.out.println("Datum isporuke: " + datumIsporuke);
		System.out.println("Prevoznik: " + prevoznik);
		System.out.println("Faktura: " +  brojFakture);
		System.out.println("Stavka otpremnice: " + stavkaOtpremnice);
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		String datum = datumIsporuke;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    int brojFaktureInt = Integer.parseInt(brojFakture);
	    
	    
	    Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
	    
	    int stavkaOtpremniceInt = Integer.parseInt(stavkaOtpremnice);
	    
	    StavkaOtpremnice stavkaOtpremnice2 = stavkaOtpremniceServiceInterface.findByRedniBrojProizvoda(stavkaOtpremniceInt);
	    
	    Otpremnica otpremnica = new Otpremnica();
	    otpremnica.setBrojOtpremnice(brojOtpremniceInt);
	    otpremnica.setKupac(kupac);
	    otpremnica.setAdresaIsporuke(adresaIsporuke);
	    otpremnica.setDatumIsporuke(sqlDate);
	    otpremnica.setPrevoznik(prevoznik);
	    otpremnica.setPotpisVozaca(false);
	    otpremnica.setPrimioRobu(false);
	    otpremnica.setFaktura(faktura);
	//    otpremnica.setStavkaOtpremnice(stavkaOtpremnice2);
	    otpremnicaServiceInterface.save(otpremnica);
	    
	    System.out.println("Dodata je nova otpremnica");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/izmeniOtpremnicu")
	public ResponseEntity<Void> izmeniOtpremnicu(@RequestParam("broj_otpremnice") String brojOtpremnice, 
			@RequestParam("novi_broj") String noviBroj,
			@RequestParam("kupac") String kupac, @RequestParam("adresa_isporuke") String adresaIsporuke, 
			@RequestParam("datum_isporuke") String datumIsporuke, @RequestParam("prevoznik") String prevoznik,
			@RequestParam("faktura") String brojFakture, @RequestParam("redni_broj_proizvoda") String stavkaOtpremnice) throws ParseException {
		
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		int noviBrojInt = Integer.parseInt(noviBroj);
		String datum = datumIsporuke;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    
	    int brojFaktureInt = Integer.parseInt(brojFakture);
	    
	    Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
	    
	    int stavkaOtpremniceInt = Integer.parseInt(stavkaOtpremnice);
		
	    StavkaOtpremnice stavkaOtpremnice2 = stavkaOtpremniceServiceInterface.findByRedniBrojProizvoda(stavkaOtpremniceInt);
	    
		if(otpremnica != null) {
			otpremnica.setBrojOtpremnice(noviBrojInt);
			otpremnica.setKupac(kupac);
			otpremnica.setAdresaIsporuke(adresaIsporuke);
			otpremnica.setDatumIsporuke(sqlDate);
			otpremnica.setPrevoznik(prevoznik);
			otpremnica.setPotpisVozaca(true);
			otpremnica.setPrimioRobu(true);
			otpremnica.setFaktura(faktura);
		//	otpremnica.setStavkaOtpremnice(stavkaOtpremnice2);
			otpremnicaServiceInterface.save(otpremnica);
			
			System.out.println("Izmenjena je otpremnica.");
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}

	
	@PostMapping(path = "/obrisiOtpremnicu")
	public ResponseEntity<Void> obrisiOtpremnicu(@RequestParam("broj_otpremnice") String brojOtpremnice){
		
		int brojOtpremniceInt = Integer.parseInt(brojOtpremnice);
		
		Otpremnica otpremnica = otpremnicaServiceInterface.findByBrojOtpremnice(brojOtpremniceInt);
		
		if(otpremnica == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		otpremnicaServiceInterface.remove(otpremnica.getIdOtpremnice());
		
		System.out.println("Obrisana je otpremnica.");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/otpremnicaSaFakturom")
	public List<Otpremnica> otpremnicaSaFakturom() {
		
		List<Otpremnica> otpremnice = new ArrayList<Otpremnica>();
		
		try {
			Connection conn = null;
			Statement stmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			stmt = conn.createStatement();
			
			String query = "SELECT * from otpremnica o, stavka_otpremnice s, faktura f WHERE o.id_fakture = f.id_fakture AND o.id_stavke_otpremnice = s.id_stavke_otpremnice";
			
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Long idOtpremnice = rset.getLong("id_otpremnice");
				int brojOtpremnice = rset.getInt("broj_otpremnice");
				String kupac = rset.getString("kupac");
				String adresaIsporuke = rset.getString("adresa_isporuke");
				Date datumIsporuke = rset.getDate("datum_isporuke");
				String prevoznik = rset.getString("prevoznik");
				boolean potpisVozaca = rset.getBoolean("potpis_vozaca");
				boolean primioRobu = rset.getBoolean("primio_robu");
				
				
				Long idStavkeOtpremnice = rset.getLong("id_stavke_otpremnice");
				int redniBrojProizvoda = rset.getInt("redni_broj_proizvoda");
				
				Long idFakture = rset.getLong("id_fakture");
				int brojFakture = rset.getInt("broj_fakture");
				Date datumFakture = rset.getDate("datum_fakture");
				Date datumValute = rset.getDate("datum_valute");
				double ukupnaOsnovica = rset.getDouble("ukupna_osnovica");
				double ukupanPDV = rset.getDouble("ukupan_pdv");
				double ukupanIznos = rset.getDouble("ukupan_iznos");
				String statusFakture = rset.getString("status_fakture");
				
				
				Otpremnica otpremnica = new Otpremnica();
				otpremnica.setIdOtpremnice(idOtpremnice);
				otpremnica.setBrojOtpremnice(brojOtpremnice);
				otpremnica.setKupac(kupac);
				otpremnica.setAdresaIsporuke(adresaIsporuke);
				otpremnica.setDatumIsporuke(datumIsporuke);
				otpremnica.setPrevoznik(prevoznik);
				otpremnica.setPotpisVozaca(potpisVozaca);
				otpremnica.setPrimioRobu(primioRobu);
				
				StavkaOtpremnice stavkaOtpremnice = new StavkaOtpremnice();
				stavkaOtpremnice.setIdStavkeOtpremnice(idStavkeOtpremnice);
				stavkaOtpremnice.setRedniBrojProizvoda(redniBrojProizvoda);
				
				Faktura faktura = new Faktura();
				faktura.setIdFakture(idFakture);
				faktura.setBrojFakture(brojFakture);
				faktura.setDatumFakture(datumFakture);
				faktura.setDatumValute(datumValute);
				faktura.setUkupnaOsnovica(ukupnaOsnovica);
				faktura.setUkupanPDV(ukupanPDV);
				faktura.setUkupanIznos(ukupanIznos);
				faktura.setStatusFakture(statusFakture);
				
			//	otpremnica.setStavkaOtpremnice(stavkaOtpremnice);
				otpremnica.setFaktura(faktura);
				
				otpremnice.add(otpremnica);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return otpremnice;
	}
	
	@GetMapping(path = "/generateOtpremniceSaFakturom")
	public static void generateOtpremniceSaFakturom() {
		try {
			Connection conn = null;
			Statement stmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "root");
			
			stmt = conn.createStatement();
			
			String query = "SELECT * from otpremnica o, stavka_otpremnice s, faktura f WHERE o.id_fakture = f.id_fakture AND o.id_stavke_otpremnice = s.id_stavke_otpremnice";
			
			ResultSet rset = stmt.executeQuery(query);
			
			String path = "C:\\Users\\Ljubica\\Downloads\\xml_otpremnice_sa_fakturom";
			

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document doc = documentBuilder.newDocument();
			
			Element el = doc.createElement("otpremnicaSaFakturom");
			doc.appendChild(el);
			
			int iRows = 0;
			int stavkaRow = 0;
			int fakturaRow = 0;
			while((rset != null) && (rset.next())) { 
				
				++iRows;
				Element sRows = doc.createElement("Otpremnica");
				
				Attr id = doc.createAttribute("id");
				id.setValue(String.valueOf(iRows));
				sRows.setAttributeNode(id);
				
				Element idOtpremnice = doc.createElement("idOtpremnice");
				idOtpremnice.appendChild(doc.createTextNode(rset.getString("id_otpremnice")));
				sRows.appendChild(idOtpremnice);
				
				Element brojOtpremnice = doc.createElement("brojOtpremnice");
				brojOtpremnice.appendChild(doc.createTextNode(rset.getString("broj_otpremnice")));
				sRows.appendChild(brojOtpremnice);
				
				Element kupac = doc.createElement("kupac");
				kupac.appendChild(doc.createTextNode(rset.getString("kupac")));
				sRows.appendChild(kupac);
				
				Element adresaIsporuke = doc.createElement("adresaIsporuke");
				adresaIsporuke.appendChild(doc.createTextNode(rset.getString("adresa_isporuke")));
				sRows.appendChild(adresaIsporuke);
				
				Element datumIsporuke = doc.createElement("datumIsporuke");
				datumIsporuke.appendChild(doc.createTextNode(rset.getString("datum_isporuke")));
				sRows.appendChild(datumIsporuke);
				
				Element prevoznik = doc.createElement("prevoznik");
				prevoznik.appendChild(doc.createTextNode(rset.getString("prevoznik")));
				sRows.appendChild(prevoznik);
				
				Element potpisVozaca = doc.createElement("potpisVozaca");
				potpisVozaca.appendChild(doc.createTextNode(rset.getString("potpis_vozaca")));
				sRows.appendChild(potpisVozaca);
				
				Element primioRobu = doc.createElement("primioRobu");
				primioRobu.appendChild(doc.createTextNode(rset.getString("primio_robu")));
				sRows.appendChild(primioRobu);
				
				++stavkaRow;
				Element stavkaOtpremniceElement = doc.createElement("stavkaOtpremnice");
				
				Attr idStavkeOtpremnice = doc.createAttribute("idStavkeOtpremnice");
				idStavkeOtpremnice.setValue(String.valueOf(stavkaRow));
				stavkaOtpremniceElement.setAttributeNode(idStavkeOtpremnice);
				
				Element idStavke = doc.createElement("idStavke");
				idStavke.appendChild(doc.createTextNode(rset.getString("id_stavke_otpremnice")));
				stavkaOtpremniceElement.appendChild(idStavke);
				
				Element redniBrojProizvoda = doc.createElement("redniBrojProizvoda");
				redniBrojProizvoda.appendChild(doc.createTextNode(rset.getString("redni_broj_proizvoda")));
				stavkaOtpremniceElement.appendChild(redniBrojProizvoda);
				
				sRows.appendChild(stavkaOtpremniceElement);
				
				++fakturaRow;
				Element fakturaElement = doc.createElement("faktura");
				
				Attr idfakture = doc.createAttribute("id");
				idfakture.setValue(String.valueOf(fakturaRow));
				fakturaElement.setAttributeNode(idfakture);
				
				Element idFakture = doc.createElement("idFakture");
				idFakture.appendChild(doc.createTextNode(rset.getString("id_fakture")));
				fakturaElement.appendChild(idFakture);
				
				Element brojFakture = doc.createElement("brojFakture");
				brojFakture.appendChild(doc.createTextNode(rset.getString("broj_fakture")));
				fakturaElement.appendChild(brojFakture);
				
				Element datumFakture = doc.createElement("datumFakture");
				datumFakture.appendChild(doc.createTextNode(rset.getString("datum_fakture")));
				fakturaElement.appendChild(datumFakture);
				
				Element datumValute = doc.createElement("datumValute");
				datumValute.appendChild(doc.createTextNode(rset.getString("datum_valute")));
				fakturaElement.appendChild(datumValute);
				
				Element ukupnaOsnovica = doc.createElement("ukupnaOsnovica");
				ukupnaOsnovica.appendChild(doc.createTextNode(rset.getString("ukupna_osnovica")));
				fakturaElement.appendChild(ukupnaOsnovica);
				
				Element ukupanPDV = doc.createElement("ukupanPDV");
				ukupanPDV.appendChild(doc.createTextNode(rset.getString("ukupan_pdv")));
				fakturaElement.appendChild(ukupanPDV);
				
				Element ukupanIznos = doc.createElement("ukupan_iznos");
				ukupanIznos.appendChild(doc.createTextNode(rset.getString("ukupan_iznos")));
				fakturaElement.appendChild(ukupanIznos);
				
				Element statusFakture = doc.createElement("statusFakture");
				statusFakture.appendChild(doc.createTextNode(rset.getString("status_fakture")));
				fakturaElement.appendChild(statusFakture);
				
				sRows.appendChild(fakturaElement);
				
				el.appendChild(sRows);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(path, "otpremnicaSaFakturom.xml").getPath());
			
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					 
			transformer.transform(domSource, streamResult);
					 
			System.out.println("XML file created!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PostMapping(path = "/dodajOtpremnicuSaFakturom")
	public ResponseEntity<Void> dodajOtpremnicuSaFakturom( 
			@RequestParam("faktura") String brojFakture, @RequestParam("redni_broj_proizvoda") String stavkaOtpremnice,
			@RequestParam("kupac") String kupac, @RequestParam("adresa_isporuke") String adresaIsporuke,
			@RequestParam("datum_isporuke") String datumIsporuke, @RequestParam("prevoznik") String prevoznik) throws ParseException {
		
		int brojFaktureInt = Integer.parseInt(brojFakture);
		
		Faktura faktura = fakturaServiceInterface.findByBrojFakture(brojFaktureInt);
		
		int stavkaOtpremniceInt = Integer.parseInt(stavkaOtpremnice);
		
		StavkaOtpremnice stavkaOtpremnice2 = stavkaOtpremniceServiceInterface.findByRedniBrojProizvoda(stavkaOtpremniceInt);
		
		String datum = datumIsporuke;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = formatter.parse(datum);
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Otpremnica otpremnica = new Otpremnica();
		otpremnica.setBrojOtpremnice(brojFaktureInt);
		otpremnica.setKupac(kupac);
		otpremnica.setAdresaIsporuke(adresaIsporuke);
		otpremnica.setDatumIsporuke(sqlDate);
		otpremnica.setPrevoznik(prevoznik);
		otpremnica.setPotpisVozaca(true);
		otpremnica.setPrimioRobu(true);
		otpremnica.setFaktura(faktura);
	//	otpremnica.setStavkaOtpremnice(stavkaOtpremnice2);
		otpremnicaServiceInterface.save(otpremnica);
	    
	    System.out.println("Dodata je nova otpremnica sa fakturom");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
