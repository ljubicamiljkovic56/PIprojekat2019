package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PoslovniPartnerDTO;
import projekat.model.PoslovniPartner;

@Component
public class PoslovniPartnerToPoslovniPartnerDTO implements Converter<PoslovniPartner, PoslovniPartnerDTO> {
	
	@Override
	public PoslovniPartnerDTO convert(PoslovniPartner source) {
		
		PoslovniPartnerDTO poslovniPartnerDto = new PoslovniPartnerDTO();
		
		poslovniPartnerDto.setIdPoslovnogPartnera(source.getIdPoslovnogPartnera());
		poslovniPartnerDto.setNazivPoslovnogPartnera(source.getNazivPoslovnogPartnera());
		poslovniPartnerDto.setAdresa(source.getAdresa());
		poslovniPartnerDto.setTelefon(source.getTelefon());
		poslovniPartnerDto.setFax(source.getFax());
		poslovniPartnerDto.setEmail(source.getEmail());
		poslovniPartnerDto.setVrstaPartnera(source.getVrstaPartnera());
		
		if(source.getNaseljenoMesto() != null) {
			poslovniPartnerDto.setIdMesta(source.getNaseljenoMesto().getIdMesta());
		}
		
		if(source.getPreduzece() != null) {
			poslovniPartnerDto.setIdPreduzeca(source.getPreduzece().getIdPreduzeca());
		}
		return poslovniPartnerDto;
	}
	
	public List<PoslovniPartnerDTO> convert(List<PoslovniPartner> partneri){
		
		List<PoslovniPartnerDTO> retVal = new ArrayList<PoslovniPartnerDTO>();
		
		for (PoslovniPartner p : partneri) {
			retVal.add(convert(p));
		}
		
		return retVal;	
	}

}
