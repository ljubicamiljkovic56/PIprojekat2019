package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PreduzeceDTO;
import projekat.model.NaseljenoMesto;
import projekat.model.Preduzece;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;

@Component
public class PreduzeceDTOtoPreduzece implements Converter<PreduzeceDTO, Preduzece> {
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	@Override
	public Preduzece convert(PreduzeceDTO preduzeceDTO) {
		
		Preduzece preduzece = new Preduzece();
		
		preduzece.setIdPreduzeca(preduzeceDTO.getIdPreduzeca());
		preduzece.setNazivPreduzeca(preduzeceDTO.getNazivPreduzeca());
		preduzece.setAdresa(preduzeceDTO.getAdresa());
		preduzece.setBrojTelefona(preduzeceDTO.getBrojTelefona());
		preduzece.setFax(preduzeceDTO.getFax());
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findOne(preduzeceDTO.getIdMesta());
		if(mesto != null) {
			preduzece.setNaseljenoMesto(mesto);
		}
		
		return preduzece;
	}

}
