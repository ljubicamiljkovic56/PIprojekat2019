package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PoslovniPartnerDTO;
import projekat.model.NaseljenoMesto;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.service.intrfc.NaseljenoMestoServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Component
public class PoslovniPartnerDTOtoPoslovniPartner implements Converter<PoslovniPartnerDTO, PoslovniPartner> {
	
	@Autowired
	private NaseljenoMestoServiceInterface naseljenoMestoServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Override
	public PoslovniPartner convert(PoslovniPartnerDTO partnerDTO) {
		
		PoslovniPartner partner = new PoslovniPartner();
		
		partner.setIdPoslovnogPartnera(partnerDTO.getIdPoslovnogPartnera());
		partner.setNazivPoslovnogPartnera(partnerDTO.getNazivPoslovnogPartnera());
		partner.setAdresa(partnerDTO.getAdresa());
		partner.setTelefon(partnerDTO.getTelefon());
		partner.setFax(partnerDTO.getFax());
		partner.setEmail(partnerDTO.getEmail());
		partner.setVrstaPartnera(partnerDTO.getVrstaPartnera());
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findOne(partnerDTO.getIdMesta());
		if(mesto != null) {
			partner.setNaseljenoMesto(mesto);
		}
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(partnerDTO.getIdPreduzeca());
		if(preduzece != null) {
			partner.setPreduzece(preduzece);
		}
		
		
		return partner;
	}

}
