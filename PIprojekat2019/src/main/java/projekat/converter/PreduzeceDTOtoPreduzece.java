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
	public Preduzece convert(PreduzeceDTO source) {
		
		Preduzece preduzece = new Preduzece();
		
		preduzece.setIdPreduzeca(source.getIdPreduzeca());
		preduzece.setNazivPreduzeca(source.getNazivPreduzeca());
		preduzece.setAdresa(source.getAdresa());
		preduzece.setBrojTelefona(source.getBrojTelefona());
		preduzece.setFax(source.getFax());
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findOne(source.getIdMesta());
		if(mesto != null) {
			preduzece.setNaseljenoMesto(mesto);
		}
		
		return preduzece;
	}

}
