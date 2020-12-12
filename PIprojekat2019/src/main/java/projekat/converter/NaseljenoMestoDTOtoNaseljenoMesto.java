package projekat.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.NaseljenoMestoDTO;
import projekat.model.NaseljenoMesto;

@Component
public class NaseljenoMestoDTOtoNaseljenoMesto implements Converter<NaseljenoMestoDTO, NaseljenoMesto> {

	@Override
	public NaseljenoMesto convert(NaseljenoMestoDTO source) {
		
		NaseljenoMesto mesto = new NaseljenoMesto();
		
		mesto.setIdMesta(source.getIdMesta());
		mesto.setNazivMesta(source.getNazivMesta());
		mesto.setPttBroj(source.getPttBroj());
	
		return mesto;
	}
}
