package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.RobaUslugaDTO;
import projekat.model.RobaUsluga;

@Component
public class RobaUslugaToRobaUslugaDTO implements Converter<RobaUsluga, RobaUslugaDTO> {
	
	
	@Override
	public RobaUslugaDTO convert(RobaUsluga source) {
		RobaUslugaDTO robaUslugaDTO = new RobaUslugaDTO();
		
		robaUslugaDTO.setIdRobeUsluge(source.getIdRobeUsluge());
		robaUslugaDTO.setNazivRobeUsluge(source.getNazivRobeUsluge());
		robaUslugaDTO.setOpis(source.getOpis());
		robaUslugaDTO.setRoba(source.isRoba());
		robaUslugaDTO.setIdJedinicaMere(source.getJedinicaMere().getIdJediniceMere());
		robaUslugaDTO.setIdGrupeRobeUsluga(source.getGrupaRobeUsluga().getIdGrupe());
		
		return robaUslugaDTO;
	}

	public List<RobaUslugaDTO> convert(List<RobaUsluga> robeUsluge){
		List<RobaUslugaDTO> retVal = new ArrayList<RobaUslugaDTO>();
		for (RobaUsluga robaUsluga : robeUsluge) {
			retVal.add(convert(robaUsluga));
		}
		return retVal;	
	}

}
