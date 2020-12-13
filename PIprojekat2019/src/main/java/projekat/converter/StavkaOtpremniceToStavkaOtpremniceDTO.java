package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaOtpremniceDTO;
import projekat.model.StavkaOtpremnice;

@Component
public class StavkaOtpremniceToStavkaOtpremniceDTO implements Converter<StavkaOtpremnice, StavkaOtpremniceDTO> {
	
	@Override
	public StavkaOtpremniceDTO convert(StavkaOtpremnice stavka) {
		
		StavkaOtpremniceDTO stavkaOtpremniceDTO = new StavkaOtpremniceDTO();
		
		stavkaOtpremniceDTO.setIdStavkeOtpremnice(stavka.getIdStavkeOtpremnice());
		stavkaOtpremniceDTO.setRedniBrojProizvoda(stavka.getRedniBrojProizvoda());
		stavkaOtpremniceDTO.setJedinicaMere(stavka.getJedinicaMere());
		stavkaOtpremniceDTO.setCena(stavka.getCena());
		stavkaOtpremniceDTO.setKolicina(stavka.getKolicina());
		stavkaOtpremniceDTO.setNapomena(stavka.getNapomena());
		
		if(stavka.getOtpremnica() != null) {
			stavkaOtpremniceDTO.setIdOtpremnice(stavka.getOtpremnica().getIdOtpremnice());
		}
		
		if(stavka.getRobaUsluga() != null) {
			stavkaOtpremniceDTO.setIdRobeUsluge(stavka.getRobaUsluga().getIdRobeUsluge());
		}
		
		return stavkaOtpremniceDTO;
	}
	
	public List<StavkaOtpremniceDTO> convert(List<StavkaOtpremnice> stavkeO){
		
		List<StavkaOtpremniceDTO> retVal = new ArrayList<StavkaOtpremniceDTO>();
		
		for (StavkaOtpremnice stavka : stavkeO) {
			retVal.add(convert(stavka));
		}
		
		return retVal;	
	}

}
