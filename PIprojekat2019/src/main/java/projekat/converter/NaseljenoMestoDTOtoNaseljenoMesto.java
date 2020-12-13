package projekat.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.NaseljenoMestoDTO;
import projekat.model.NaseljenoMesto;

@Component
public class NaseljenoMestoDTOtoNaseljenoMesto implements Converter<NaseljenoMestoDTO, NaseljenoMesto> {

	@Override
	public NaseljenoMesto convert(NaseljenoMestoDTO mestoDTO) {
		
		NaseljenoMesto mesto = new NaseljenoMesto();
		
		mesto.setIdMesta(mestoDTO.getIdMesta());
		mesto.setNazivMesta(mestoDTO.getNazivMesta());
		mesto.setPttBroj(mestoDTO.getPttBroj());
	
		return mesto;
	}
}
