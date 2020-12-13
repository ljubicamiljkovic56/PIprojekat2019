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
	public StavkaCenovnikaDTO convert(StavkaCenovnika stavkaC) {
		
		StavkaCenovnikaDTO stavkaCenovnikaDTO = new StavkaCenovnikaDTO();

		stavkaCenovnikaDTO.setIdCenovnika(stavkaC.getIdStavke());
		stavkaCenovnikaDTO.setCena(stavkaC.getCena());
		
		if(stavkaC.getCenovnik() != null) {
			stavkaCenovnikaDTO.setIdCenovnika(stavkaC.getCenovnik().getIdCenovnika());
		}
		
		if(stavkaC.getRobaUsluga() != null) {
			stavkaCenovnikaDTO.setIdRobeUsluge(stavkaC.getRobaUsluga().getIdRobeUsluge());
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
