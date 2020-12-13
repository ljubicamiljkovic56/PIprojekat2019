package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.GrupaRobeUslugaDTO;
import projekat.model.GrupaRobeUsluga;
import projekat.model.PDVKategorija;
import projekat.service.intrfc.PDVKategorijaServiceInterface;

@Component
public class GrupaRobeUslugaDTOtoGrupaRobeUsluga implements Converter<GrupaRobeUslugaDTO, GrupaRobeUsluga> {
	
	@Autowired
	private PDVKategorijaServiceInterface pdvKategorijaServiceInterface;

	@Override
	public GrupaRobeUsluga convert(GrupaRobeUslugaDTO grupaDTO) {
		
        GrupaRobeUsluga grupaRobe = new GrupaRobeUsluga();
        
        grupaRobe.setIdGrupe(grupaDTO.getIdGrupe());
        grupaRobe.setNazivGrupe(grupaDTO.getNazivGrupe());
        PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findOne(grupaDTO.getIdPDVKategorija());
        if(pdvKategorija != null){
            grupaRobe.setPdvKategorija(pdvKategorija);
        }
        return grupaRobe;
	}
	
}
