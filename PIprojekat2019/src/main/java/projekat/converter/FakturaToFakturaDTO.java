package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.FakturaDTO;
import projekat.model.Faktura;

@Component
public class FakturaToFakturaDTO implements Converter<Faktura, FakturaDTO> {

	@Override
	public FakturaDTO convert(Faktura faktura) {
		
		FakturaDTO fakturaDTO = new FakturaDTO();
		
		fakturaDTO.setIdFakture(faktura.getIdFakture());
		fakturaDTO.setBrojFakture(faktura.getBrojFakture());
		fakturaDTO.setDatumFakture(faktura.getDatumFakture());
		fakturaDTO.setDatumValute(faktura.getDatumValute());
		fakturaDTO.setUkupnaOsnovica(faktura.getUkupnaOsnovica());
		fakturaDTO.setUkupanPDV(faktura.getUkupanPDV());
		fakturaDTO.setUkupanIznos(faktura.getUkupanIznos());
		
		if(faktura.getPoslovnaGodina() != null) {
			fakturaDTO.setIdGodine(faktura.getPoslovnaGodina().getIdGodine());
		}
		
		if(faktura.getPreduzece() != null) {
			fakturaDTO.setIdPreduzeca(faktura.getPreduzece().getIdPreduzeca());
		}
		
		if(faktura.getPoslovniPartner() != null) {
			fakturaDTO.setIdPoslovnogPartnera(faktura.getPoslovniPartner().getIdPoslovnogPartnera());
		}
		
		if(faktura.getNarudzbenica() != null) {
			fakturaDTO.setIdNarudzbenice(faktura.getNarudzbenica().getId());
		}
		
		return fakturaDTO;
	}
	
	public List<FakturaDTO> convert(List<Faktura> fakture){
		
		List<FakturaDTO> retVal = new ArrayList<FakturaDTO>();
		
		for (Faktura faktura : fakture) {
			retVal.add(convert(faktura));
		}
		
		return retVal;	
	}
}
