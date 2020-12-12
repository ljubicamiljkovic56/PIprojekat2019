package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaCenovnikaDTO;
import projekat.model.StavkaCenovnika;

@Component
public class StavkaCenovnikaToStavkaCenovnikaDTO implements Converter<StavkaCenovnika, StavkaCenovnikaDTO> {

	@Override
	public StavkaCenovnikaDTO convert(StavkaCenovnika source) {
		
		StavkaCenovnikaDTO stavkaCenovnikaDTO = new StavkaCenovnikaDTO();

		stavkaCenovnikaDTO.setIdCenovnika(source.getIdStavke());
		stavkaCenovnikaDTO.setCena(source.getCena());
		
		if(source.getCenovnik() != null) {
			stavkaCenovnikaDTO.setIdCenovnika(source.getCenovnik().getIdCenovnika());
		}
		
		if(source.getRobaUsluga() != null) {
			stavkaCenovnikaDTO.setIdRobeUsluge(source.getRobaUsluga().getIdRobeUsluge());
		}
		return stavkaCenovnikaDTO;
	}
	
	public List<StavkaCenovnikaDTO> convert(List<StavkaCenovnika> stavke){
		
		List<StavkaCenovnikaDTO> retVal = new ArrayList<StavkaCenovnikaDTO>();
		
		for (StavkaCenovnika stavka : stavke) {
			retVal.add(convert(stavka));
		}
		
		return retVal;	
	}
}
