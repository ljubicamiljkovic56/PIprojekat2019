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
	public RobaUslugaDTO convert(RobaUsluga roba) {
		RobaUslugaDTO robaUslugaDTO = new RobaUslugaDTO();
		
		robaUslugaDTO.setIdRobeUsluge(roba.getIdRobeUsluge());
		robaUslugaDTO.setNazivRobeUsluge(roba.getNazivRobeUsluge());
		robaUslugaDTO.setOpis(roba.getOpis());
		robaUslugaDTO.setRoba(roba.isRoba());
		
		if(roba.getJedinicaMere() != null) {
			robaUslugaDTO.setIdJedinicaMere(roba.getJedinicaMere().getIdJediniceMere());
		}
		
		if(roba.getGrupaRobeUsluga() != null) {
			robaUslugaDTO.setIdGrupeRobeUsluga(roba.getGrupaRobeUsluga().getIdGrupe());
		}

		
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
