package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.NarudzbenicaDTO;
import projekat.model.Narudzbenica;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Component
public class NarudzbenicaDTOtoNarudzbenica implements Converter<NarudzbenicaDTO, Narudzbenica> {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Override
	public Narudzbenica convert(NarudzbenicaDTO narudzbenicaDTO) {
		
		Narudzbenica narudzbenica = new Narudzbenica();
		
		narudzbenica.setId(narudzbenicaDTO.getId());
		narudzbenica.setBrojNarudzbenice(narudzbenicaDTO.getBrojNarudzbenice());
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(narudzbenicaDTO.getIdPreduzeca());
		if(preduzece != null) {
			narudzbenica.setPreduzece(preduzece);
		}
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findOne(narudzbenicaDTO.getIdPoslovnogPartnera());
		if(partner != null) {
			narudzbenica.setPoslovniPartner(partner);
		}
		
		PoslovnaGodina godina = poslovnaGodinaServiceInterface.findOne(narudzbenicaDTO.getIdGodine());
		if(godina != null) {
			narudzbenica.setPoslovnaGodina(godina);
		}
		
		return narudzbenica;
	}

}
