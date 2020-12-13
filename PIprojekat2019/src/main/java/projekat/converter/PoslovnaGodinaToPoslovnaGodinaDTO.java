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
	public PoslovnaGodinaDTO convert(PoslovnaGodina pGodina) {
		
		PoslovnaGodinaDTO poslovnaGodinaDTO = new PoslovnaGodinaDTO();
		
		poslovnaGodinaDTO.setIdGodine(pGodina.getIdGodine());
		poslovnaGodinaDTO.setGodina(pGodina.getGodina());
		poslovnaGodinaDTO.setZakljucena(pGodina.isZakljucena());
		
		if(pGodina.getPreduzece() != null) {
			poslovnaGodinaDTO.setIdPreduzeca(pGodina.getPreduzece().getIdPreduzeca());
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
