package projekat.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PDVKategorijaDTO;
import projekat.model.PDVKategorija;
@Component
public class PDVKategorijaDTOtoPDVKategorija implements Converter<PDVKategorijaDTO, PDVKategorija> {

	@Override
	public PDVKategorija convert(PDVKategorijaDTO pdvKatDTO) {
		PDVKategorija pdvKategorija = new PDVKategorija();
		
		pdvKategorija.setIdKategorije(pdvKatDTO.getIdKategorije());
		pdvKategorija.setNazivKategorije(pdvKatDTO.getNazivKategorije());
		
		return pdvKategorija;
	}
}
