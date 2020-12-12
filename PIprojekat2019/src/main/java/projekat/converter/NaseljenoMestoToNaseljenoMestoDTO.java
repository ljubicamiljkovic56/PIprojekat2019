package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.NaseljenoMestoDTO;
import projekat.model.NaseljenoMesto;

@Component
public class NaseljenoMestoToNaseljenoMestoDTO implements Converter<NaseljenoMesto, NaseljenoMestoDTO> {

	@Override
	public NaseljenoMestoDTO convert(NaseljenoMesto source) {
		
		NaseljenoMestoDTO mestoDto = new NaseljenoMestoDTO();
		
		mestoDto.setIdMesta(source.getIdMesta());
		mestoDto.setNazivMesta(source.getNazivMesta());
		mestoDto.setPttBroj(source.getPttBroj());
		
		return mestoDto;
	}
	
	public List<NaseljenoMestoDTO> convert(List<NaseljenoMesto> mesta){
		
		List<NaseljenoMestoDTO> retVal = new ArrayList<NaseljenoMestoDTO>();
		
		for (NaseljenoMesto mesto : mesta) {
			retVal.add(convert(mesto));
		}
		
		return retVal;	
	}
}
