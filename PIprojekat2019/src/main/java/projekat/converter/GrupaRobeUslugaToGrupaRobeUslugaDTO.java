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
	public GrupaRobeUslugaDTO convert(GrupaRobeUsluga grupa) {
		GrupaRobeUslugaDTO grupaRobeUslugaDto = new GrupaRobeUslugaDTO();

		grupaRobeUslugaDto.setIdGrupe(grupa.getIdGrupe());
		grupaRobeUslugaDto.setNazivGrupe(grupa.getNazivGrupe());
		
		if(grupa.getPdvKategorija() != null) {
			grupaRobeUslugaDto.setIdPDVKategorija(grupa.getPdvKategorija().getIdKategorije());
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
