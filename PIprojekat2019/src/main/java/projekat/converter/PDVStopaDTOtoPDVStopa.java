package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PDVStopaDTO;
import projekat.model.PDVKategorija;
import projekat.model.PDVStopa;
import projekat.service.intrfc.PDVKategorijaServiceInterface;
@Component
public class PDVStopaDTOtoPDVStopa implements Converter<PDVStopaDTO, PDVStopa> {

	@Autowired
	private PDVKategorijaServiceInterface pdvKategorijaServiceInterface;
	
	@Override
	public PDVStopa convert(PDVStopaDTO pdvSdto) {
		
		PDVStopa pdvStopa = new PDVStopa();
		
		pdvStopa.setIdStope(pdvSdto.getIdStope());
		pdvStopa.setDatumVazenja(pdvSdto.getDatumVazenja());
		pdvStopa.setProcenat(pdvSdto.getProcenat());
		
		PDVKategorija pdvKategorija = pdvKategorijaServiceInterface.findOne(pdvSdto.getIdPDVKategorije());
		if(pdvKategorija !=null) {
			pdvStopa.setPdvKategorija(pdvKategorija);
		}
		
		return pdvStopa;
	}
}
