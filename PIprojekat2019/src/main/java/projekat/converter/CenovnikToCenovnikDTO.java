package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.CenovnikDTO;
import projekat.model.Cenovnik;

@Component
public class CenovnikToCenovnikDTO implements Converter<Cenovnik, CenovnikDTO> {
	
	@Override
	public CenovnikDTO convert(Cenovnik cenovnik) {
		
		CenovnikDTO cenovnikDTO = new CenovnikDTO();
		
		cenovnikDTO.setIdCenovnika(cenovnik.getIdCenovnika());
		cenovnikDTO.setDatumPocetkaVazenja(cenovnik.getDatumPocetkaVazenja());
		
		if(cenovnik.getPreduzece() != null) {
			cenovnikDTO.setIdPreduzeca(cenovnik.getPreduzece().getIdPreduzeca());
		}
		
		return cenovnikDTO;
	}
	
	public List<CenovnikDTO> convert(List<Cenovnik> cenovnici){
		
		List<CenovnikDTO> retVal = new ArrayList<CenovnikDTO>();
		
		for (Cenovnik cenovnik : cenovnici) {
			retVal.add(convert(cenovnik));
		}
		
		return retVal;	
	}

}
