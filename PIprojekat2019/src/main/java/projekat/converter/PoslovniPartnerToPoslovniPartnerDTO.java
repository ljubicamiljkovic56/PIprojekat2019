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
	public PoslovniPartnerDTO convert(PoslovniPartner partner) {
		
		PoslovniPartnerDTO poslovniPartnerDto = new PoslovniPartnerDTO();
		
		poslovniPartnerDto.setIdPoslovnogPartnera(partner.getIdPoslovnogPartnera());
		poslovniPartnerDto.setNazivPoslovnogPartnera(partner.getNazivPoslovnogPartnera());
		poslovniPartnerDto.setAdresa(partner.getAdresa());
		poslovniPartnerDto.setTelefon(partner.getTelefon());
		poslovniPartnerDto.setFax(partner.getFax());
		poslovniPartnerDto.setEmail(partner.getEmail());
		poslovniPartnerDto.setVrstaPartnera(partner.getVrstaPartnera());
		
		if(partner.getNaseljenoMesto() != null) {
			poslovniPartnerDto.setIdMesta(partner.getNaseljenoMesto().getIdMesta());
		}
		
		if(partner.getPreduzece() != null) {
			poslovniPartnerDto.setIdPreduzeca(partner.getPreduzece().getIdPreduzeca());
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
