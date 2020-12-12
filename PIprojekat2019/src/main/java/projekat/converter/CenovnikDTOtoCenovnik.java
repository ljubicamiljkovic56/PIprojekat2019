package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.CenovnikDTO;
import projekat.model.Cenovnik;
import projekat.model.Preduzece;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Component
public class CenovnikDTOtoCenovnik implements Converter<CenovnikDTO, Cenovnik> {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;

	@Override
	public Cenovnik convert(CenovnikDTO cenovnikDTO) {
		
		Cenovnik cenovnik = new Cenovnik();
		
		cenovnik.setIdCenovnika(cenovnikDTO.getIdCenovnika());
		cenovnik.setDatumPocetkaVazenja(cenovnikDTO.getDatumPocetkaVazenja());
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(cenovnikDTO.getIdPreduzeca());
		if(preduzece != null) {
			cenovnik.setPreduzece(preduzece);
		}
		
		return cenovnik;
	}
}
