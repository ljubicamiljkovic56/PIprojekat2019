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
	public OtpremnicaDTO convert(Otpremnica source) {
		
		OtpremnicaDTO otpremnicaDTO = new OtpremnicaDTO();
		
		otpremnicaDTO.setIdOtpremnice(source.getIdOtpremnice());
		otpremnicaDTO.setBrojOtpremnice(source.getBrojOtpremnice());
		otpremnicaDTO.setKupac(source.getKupac());
		otpremnicaDTO.setAdresaIsporuke(source.getAdresaIsporuke());
		otpremnicaDTO.setDatumIsporuke(source.getDatumIsporuke());
		otpremnicaDTO.setPrevoznik(source.getPrevoznik());
		otpremnicaDTO.setPotpisVozaca(source.isPotpisVozaca());
		otpremnicaDTO.setPrimioRobu(source.isPrimioRobu());
		
		if(source.getFaktura() != null) {
			otpremnicaDTO.setIdFakture(source.getFaktura().getIdFakture());
		}
		
		if(source.getNarudzbenica() != null) {
			otpremnicaDTO.setIdNarudzbenice(source.getNarudzbenica().getId());
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
