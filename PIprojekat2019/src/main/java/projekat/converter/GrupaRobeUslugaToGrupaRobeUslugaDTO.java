package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.GrupaRobeUslugaDTO;
import projekat.model.GrupaRobeUsluga;
@Component
public class GrupaRobeUslugaToGrupaRobeUslugaDTO implements Converter<GrupaRobeUsluga, GrupaRobeUslugaDTO> {
	
	@Override
	public GrupaRobeUslugaDTO convert(GrupaRobeUsluga source) {
		GrupaRobeUslugaDTO grupaRobeUslugaDto = new GrupaRobeUslugaDTO();

		grupaRobeUslugaDto.setIdGrupe(source.getIdGrupe());
		grupaRobeUslugaDto.setNazivGrupe(source.getNazivGrupe());
		
		if(source.getPdvKategorija() != null) {
			grupaRobeUslugaDto.setIdPDVKategorija(source.getPdvKategorija().getIdKategorije());
		}

		return grupaRobeUslugaDto;
	}

	public List<GrupaRobeUslugaDTO> convert(List<GrupaRobeUsluga> grupeRobe) {
		List<GrupaRobeUslugaDTO> grupeRobedto = new ArrayList<GrupaRobeUslugaDTO>();
		for (GrupaRobeUsluga g : grupeRobe) {
			grupeRobedto.add(convert(g));
		}
		return grupeRobedto;
	}

}
