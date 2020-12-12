package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PreduzeceDTO;
import projekat.model.Preduzece;

@Component
public class PreduzeceToPreduzeceDTO implements Converter<Preduzece, PreduzeceDTO> {
	
	@Override
	public PreduzeceDTO convert(Preduzece preduzece) {
		
		PreduzeceDTO preduzeceDTO = new PreduzeceDTO();
		
		preduzeceDTO.setIdPreduzeca(preduzece.getIdPreduzeca());
		preduzeceDTO.setNazivPreduzeca(preduzece.getNazivPreduzeca());
		preduzeceDTO.setAdresa(preduzece.getAdresa());
		preduzeceDTO.setBrojTelefona(preduzece.getBrojTelefona());
		preduzeceDTO.setFax(preduzece.getFax());
		preduzeceDTO.setIdMesta(preduzece.getNaseljenoMesto().getIdMesta());
		
		return preduzeceDTO;
	}
	
	public List<PreduzeceDTO> convert(List<Preduzece> preduzeca){
		
		List<PreduzeceDTO> retVal = new ArrayList<PreduzeceDTO>();
		
		for (Preduzece preduzece : preduzeca) {
			retVal.add(convert(preduzece));
		}
		
		return retVal;	
	}	

}