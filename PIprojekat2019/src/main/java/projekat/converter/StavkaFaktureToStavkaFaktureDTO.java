package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaFaktureDTO;
import projekat.model.StavkaFakture;

@Component
public class StavkaFaktureToStavkaFaktureDTO implements Converter<StavkaFakture, StavkaFaktureDTO> {

	@Override
	public StavkaFaktureDTO convert(StavkaFakture stavkaFakture) {
		
		StavkaFaktureDTO stavkaFaktureDTO = new StavkaFaktureDTO();
		
		stavkaFaktureDTO.setIdFakture(stavkaFakture.getIdStavke());
		stavkaFaktureDTO.setKolicina(stavkaFakture.getKolicina());
		stavkaFaktureDTO.setRabat(stavkaFakture.getRabat());
		stavkaFaktureDTO.setJedinicnaCena(stavkaFakture.getJedinicnaCena());
		stavkaFaktureDTO.setPdvStopa(stavkaFakture.getPdvStopa());
		stavkaFaktureDTO.setOsnovicaZaPDV(stavkaFakture.getOsnovicaZaPDV());
		stavkaFaktureDTO.setIznosPDV(stavkaFakture.getIznosPDV());
		stavkaFaktureDTO.setUkupanIznos(stavkaFakture.getUkupanIznos());
		
		if(stavkaFakture.getPreduzece() != null) {
			stavkaFaktureDTO.setIdPreduzeca(stavkaFakture.getPreduzece().getIdPreduzeca());
		}
		
		if(stavkaFakture.getFaktura() != null) {
			stavkaFaktureDTO.setIdFakture(stavkaFakture.getFaktura().getIdFakture());
		}
		
		if(stavkaFakture.getRobaUsluga() != null) {
			stavkaFaktureDTO.setIdRobeUsluge(stavkaFakture.getRobaUsluga().getIdRobeUsluge());
		}
		
		return stavkaFaktureDTO;
	}
	
	public List<StavkaFaktureDTO> convert(List<StavkaFakture> stavkeF){
		
		List<StavkaFaktureDTO> retVal = new ArrayList<StavkaFaktureDTO>();
		
		for (StavkaFakture stavka: stavkeF) {
			retVal.add(convert(stavka));
		}
		
		return retVal;	
	}
}
