package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.FakturaDTO;
import projekat.model.Faktura;
import projekat.model.Narudzbenica;
import projekat.model.PoslovnaGodina;
import projekat.model.PoslovniPartner;
import projekat.model.Preduzece;
import projekat.service.intrfc.NarudzbenicaServiceInterface;
import projekat.service.intrfc.PoslovnaGodinaServiceInterface;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Component
public class FakturaDTOtoFaktura implements Converter<FakturaDTO, Faktura> {
	
	@Autowired
	private PoslovnaGodinaServiceInterface poslovnaGodinaServiceInterface;
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private PoslovniPartnerServiceInterface poslovniPartnerServiceInterface;
	
	@Autowired
	private NarudzbenicaServiceInterface narudzbenicaServiceInterface;
	
	@Override
	public Faktura convert(FakturaDTO fakturaDTO) {
		
		Faktura faktura = new Faktura();
		
		faktura.setIdFakture(fakturaDTO.getIdFakture());
		faktura.setBrojFakture(fakturaDTO.getBrojFakture());
		faktura.setDatumFakture(fakturaDTO.getDatumFakture());
		faktura.setDatumValute(fakturaDTO.getDatumValute());
		faktura.setUkupnaOsnovica(fakturaDTO.getUkupnaOsnovica());
		faktura.setUkupanPDV(fakturaDTO.getUkupanPDV());
		faktura.setUkupanIznos(fakturaDTO.getUkupanIznos());
		faktura.setStatusFakture(fakturaDTO.getStatusFakture());
		
		PoslovnaGodina godina = poslovnaGodinaServiceInterface.findOne(fakturaDTO.getIdGodine());
		if(godina != null) {
			faktura.setPoslovnaGodina(godina);
		}
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(fakturaDTO.getIdPreduzeca());
		if(preduzece != null) {
			faktura.setPreduzece(preduzece);
		}
		
		PoslovniPartner partner = poslovniPartnerServiceInterface.findOne(fakturaDTO.getIdPoslovnogPartnera());
		if(partner != null) {
			faktura.setPoslovniPartner(partner);
		}
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(fakturaDTO.getIdNarudzbenice());
		if(narudzbenica != null) {
			faktura.setNarudzbenica(narudzbenica);
		}
		return faktura;
	}

}
