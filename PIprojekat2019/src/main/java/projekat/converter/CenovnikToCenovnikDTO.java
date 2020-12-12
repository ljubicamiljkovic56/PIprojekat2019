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
	public CenovnikDTO convert(Cenovnik source) {
		
		CenovnikDTO cenovnikDTO = new CenovnikDTO();
		
		cenovnikDTO.setIdCenovnika(source.getIdCenovnika());
		cenovnikDTO.setDatumPocetkaVazenja(source.getDatumPocetkaVazenja());
		
		if(source.getPreduzece() != null) {
			cenovnikDTO.setIdPreduzeca(source.getPreduzece().getIdPreduzeca());
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
