package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.NarudzbenicaDTO;
import projekat.model.Narudzbenica;

@Component
public class NarudzbenicaToNarudzbenicaDTO implements Converter<Narudzbenica, NarudzbenicaDTO> {
	
	@Override
	public NarudzbenicaDTO convert(Narudzbenica narudzbenica) {
		
		NarudzbenicaDTO narudzbenicaDTO = new NarudzbenicaDTO();
		
	
		narudzbenicaDTO.setId(narudzbenica.getId());
		narudzbenicaDTO.setBrojNarudzbenice(narudzbenica.getBrojNarudzbenice());
		
		if(narudzbenica.getPreduzece() != null) {
			narudzbenicaDTO.setIdPreduzeca(narudzbenica.getPreduzece().getIdPreduzeca());
		}
		
		if(narudzbenica.getPoslovniPartner() != null) {
			narudzbenicaDTO.setIdPoslovnogPartnera(narudzbenica.getPoslovniPartner().getIdPoslovnogPartnera());
		}
		
		if(narudzbenica.getPoslovnaGodina() != null) {
			narudzbenicaDTO.setIdGodine(narudzbenica.getPoslovnaGodina().getIdGodine());
		}
		
		return narudzbenicaDTO;
	}
	
	public List<NarudzbenicaDTO> convert(List<Narudzbenica> narudzbenice){
		
		List<NarudzbenicaDTO> retVal = new ArrayList<NarudzbenicaDTO>();
		
		for (Narudzbenica narudzbenica : narudzbenice) {
			retVal.add(convert(narudzbenica));
		}
		
		return retVal;	
	}

}
