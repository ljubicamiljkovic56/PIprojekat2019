package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.OtpremnicaDTO;
import projekat.model.Faktura;
import projekat.model.Narudzbenica;
import projekat.model.Otpremnica;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.NarudzbenicaServiceInterface;

@Component
public class OtpremnicaDTOtoOtpremnica implements Converter<OtpremnicaDTO, Otpremnica> {
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
	@Autowired
	private NarudzbenicaServiceInterface narudzbenicaServiceInterface;
	
	@Override
	public Otpremnica convert(OtpremnicaDTO source) {
		
		Otpremnica otpremnica = new Otpremnica();
		
		otpremnica.setIdOtpremnice(source.getIdOtpremnice());
		otpremnica.setBrojOtpremnice(source.getBrojOtpremnice());
		otpremnica.setKupac(source.getKupac());
		otpremnica.setAdresaIsporuke(source.getAdresaIsporuke());
		otpremnica.setDatumIsporuke(source.getDatumIsporuke());
		otpremnica.setPrevoznik(source.getPrevoznik());
		otpremnica.setPotpisVozaca(source.isPotpisVozaca());
		otpremnica.setPrimioRobu(source.isPrimioRobu());
		
		Faktura faktura = fakturaServiceInterface.findOne(source.getIdFakture());
		if(faktura != null) {
			otpremnica.setFaktura(faktura);
		}
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(source.getIdNarudzbenice());
		if(narudzbenica != null) {
			otpremnica.setNarudzbenica(narudzbenica);
		}
		
		return otpremnica;
	}

}
