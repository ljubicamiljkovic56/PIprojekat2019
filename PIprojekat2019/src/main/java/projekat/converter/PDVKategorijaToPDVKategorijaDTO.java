package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PDVKategorijaDTO;
import projekat.model.PDVKategorija;

@Component
public class PDVKategorijaToPDVKategorijaDTO implements Converter<PDVKategorija, PDVKategorijaDTO> {
	
	@Override
	public PDVKategorijaDTO convert(PDVKategorija pdvKategorija) {
		PDVKategorijaDTO pdvKatDto = new PDVKategorijaDTO();
		
		pdvKatDto.setIdKategorije(pdvKategorija.getIdKategorije());
		pdvKatDto.setNazivKategorije(pdvKategorija.getNazivKategorije());
		
		return pdvKatDto;
	}

    public List<PDVKategorijaDTO> convert(List<PDVKategorija> kategorije){
        List<PDVKategorijaDTO> pdvKatdtos = new ArrayList<PDVKategorijaDTO>();
        for (PDVKategorija k: kategorije) {
            pdvKatdtos.add(convert(k));
        }
        return pdvKatdtos;
    }

}
