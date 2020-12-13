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
	public NaseljenoMestoDTO convert(NaseljenoMesto mesto) {
		
		NaseljenoMestoDTO mestoDto = new NaseljenoMestoDTO();
		
		mestoDto.setIdMesta(mesto.getIdMesta());
		mestoDto.setNazivMesta(mesto.getNazivMesta());
		mestoDto.setPttBroj(mesto.getPttBroj());
		
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
