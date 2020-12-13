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
	public Otpremnica convert(OtpremnicaDTO otpDTO) {
		
		Otpremnica otpremnica = new Otpremnica();
		
		otpremnica.setIdOtpremnice(otpDTO.getIdOtpremnice());
		otpremnica.setBrojOtpremnice(otpDTO.getBrojOtpremnice());
		otpremnica.setKupac(otpDTO.getKupac());
		otpremnica.setAdresaIsporuke(otpDTO.getAdresaIsporuke());
		otpremnica.setDatumIsporuke(otpDTO.getDatumIsporuke());
		otpremnica.setPrevoznik(otpDTO.getPrevoznik());
		otpremnica.setPotpisVozaca(otpDTO.isPotpisVozaca());
		otpremnica.setPrimioRobu(otpDTO.isPrimioRobu());
		
		Faktura faktura = fakturaServiceInterface.findOne(otpDTO.getIdFakture());
		if(faktura != null) {
			otpremnica.setFaktura(faktura);
		}
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(otpDTO.getIdNarudzbenice());
		if(narudzbenica != null) {
			otpremnica.setNarudzbenica(narudzbenica);
		}
		
		return otpremnica;
	}

}
