package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaNarudzbeniceDTO;
import projekat.model.StavkaNarudzbenice;

@Component
public class StavkaNarudzbeniceToStavkaNarudzbeniceDTO implements Converter<StavkaNarudzbenice, StavkaNarudzbeniceDTO> {
	
	@Override
	public StavkaNarudzbeniceDTO convert(StavkaNarudzbenice stavkaNarudzbenice) {
		
		StavkaNarudzbeniceDTO stavkaDTO = new StavkaNarudzbeniceDTO();
		
		stavkaDTO.setId(stavkaNarudzbenice.getId());
		stavkaDTO.setJedinicaMere(stavkaNarudzbenice.getJedinicaMere());
		stavkaDTO.setKolicina(stavkaNarudzbenice.getKolicina());
		stavkaDTO.setCena(stavkaNarudzbenice.getCena());
		stavkaDTO.setIznos(stavkaNarudzbenice.getIznos());
		
		if(stavkaNarudzbenice.getNarudzbenica() != null) {
			stavkaDTO.setIdNarudzbenice(stavkaNarudzbenice.getNarudzbenica().getId());
		}
		 
		 if(stavkaNarudzbenice.getRobaUsluga() != null) {
			 stavkaDTO.setIdRobeUsluge(stavkaNarudzbenice.getRobaUsluga().getIdRobeUsluge());
		 }
		
		return stavkaDTO;
	}
	
	public List<StavkaNarudzbeniceDTO> convert(List<StavkaNarudzbenice> stavkeN){
		
		List<StavkaNarudzbeniceDTO> retVal = new ArrayList<StavkaNarudzbeniceDTO>();
		
		for (StavkaNarudzbenice stavka : stavkeN) {
			retVal.add(convert(stavka));
		}
		
		return retVal;	
	}

}
