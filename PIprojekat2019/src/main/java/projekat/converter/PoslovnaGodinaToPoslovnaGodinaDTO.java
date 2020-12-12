package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PoslovnaGodinaDTO;
import projekat.model.PoslovnaGodina;

@Component
public class PoslovnaGodinaToPoslovnaGodinaDTO implements Converter<PoslovnaGodina, PoslovnaGodinaDTO> {
	
	@Override
	public PoslovnaGodinaDTO convert(PoslovnaGodina source) {
		
		PoslovnaGodinaDTO poslovnaGodinaDTO = new PoslovnaGodinaDTO();
		
		poslovnaGodinaDTO.setIdGodine(source.getIdGodine());
		poslovnaGodinaDTO.setGodina(source.getGodina());
		poslovnaGodinaDTO.setZakljucena(source.isZakljucena());
		
		if(source.getPreduzece() != null) {
			poslovnaGodinaDTO.setIdPreduzeca(source.getPreduzece().getIdPreduzeca());
		}
		
		
		return poslovnaGodinaDTO;
	}
	
	public List<PoslovnaGodinaDTO> convert(List<PoslovnaGodina> godine){
		
		List<PoslovnaGodinaDTO> retVal = new ArrayList<PoslovnaGodinaDTO>();
		
		for (PoslovnaGodina godina : godine) {
			retVal.add(convert(godina));
		}
		
		return retVal;	
	}

}
