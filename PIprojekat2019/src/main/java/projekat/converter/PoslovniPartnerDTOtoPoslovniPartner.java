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
	public PoslovniPartner convert(PoslovniPartnerDTO source) {
		
		PoslovniPartner partner = new PoslovniPartner();
		
		partner.setIdPoslovnogPartnera(source.getIdPoslovnogPartnera());
		partner.setNazivPoslovnogPartnera(source.getNazivPoslovnogPartnera());
		partner.setAdresa(source.getAdresa());
		partner.setTelefon(source.getTelefon());
		partner.setFax(source.getFax());
		partner.setEmail(source.getEmail());
		partner.setVrstaPartnera(source.getVrstaPartnera());
		
		NaseljenoMesto mesto = naseljenoMestoServiceInterface.findOne(source.getIdMesta());
		if(mesto != null) {
			partner.setNaseljenoMesto(mesto);
		}
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(source.getIdPreduzeca());
		if(preduzece != null) {
			partner.setPreduzece(preduzece);
		}
		
		
		return partner;
	}

}
