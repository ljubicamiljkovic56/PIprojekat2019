package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.OtpremnicaDTO;
import projekat.model.Otpremnica;

@Component
public class OtpremnicaToOtpremnicaDTO implements Converter<Otpremnica, OtpremnicaDTO> {
	
	@Override
	public OtpremnicaDTO convert(Otpremnica otp) {
		
		OtpremnicaDTO otpremnicaDTO = new OtpremnicaDTO();
		
		otpremnicaDTO.setIdOtpremnice(otp.getIdOtpremnice());
		otpremnicaDTO.setBrojOtpremnice(otp.getBrojOtpremnice());
		otpremnicaDTO.setKupac(otp.getKupac());
		otpremnicaDTO.setAdresaIsporuke(otp.getAdresaIsporuke());
		otpremnicaDTO.setDatumIsporuke(otp.getDatumIsporuke());
		otpremnicaDTO.setPrevoznik(otp.getPrevoznik());
		otpremnicaDTO.setPotpisVozaca(otp.isPotpisVozaca());
		otpremnicaDTO.setPrimioRobu(otp.isPrimioRobu());
		
		if(otp.getFaktura() != null) {
			otpremnicaDTO.setIdFakture(otp.getFaktura().getIdFakture());
		}
		
		if(otp.getNarudzbenica() != null) {
			otpremnicaDTO.setIdNarudzbenice(otp.getNarudzbenica().getId());
		}
		
		return otpremnicaDTO;
	}
	
	public List<OtpremnicaDTO> convert(List<Otpremnica> otpremnice){
		
		List<OtpremnicaDTO> retVal = new ArrayList<OtpremnicaDTO>();
		
		for (Otpremnica otpremnica : otpremnice) {
			retVal.add(convert(otpremnica));
		}
		
		return retVal;	
	}

}
