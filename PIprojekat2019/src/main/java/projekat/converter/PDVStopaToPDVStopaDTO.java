package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PDVStopaDTO;
import projekat.model.PDVStopa;

@Component
public class PDVStopaToPDVStopaDTO implements Converter<PDVStopa, PDVStopaDTO> {

	@Override
	public PDVStopaDTO convert(PDVStopa pdvStopa) {
		
		PDVStopaDTO pdvSdto = new PDVStopaDTO();
		
		pdvSdto.setIdStope(pdvStopa.getIdStope());
		pdvSdto.setDatumVazenja(pdvStopa.getDatumVazenja());
		pdvSdto.setProcenat(pdvStopa.getProcenat());
		
		if(pdvStopa.getPdvKategorija() != null) {
			pdvSdto.setIdPDVKategorije(pdvStopa.getPdvKategorija().getIdKategorije());
		}
		
		return pdvSdto;
	}
	
	public List<PDVStopaDTO> convert(List<PDVStopa> pdvStope){
		
		List<PDVStopaDTO> retVal = new ArrayList<PDVStopaDTO>();
		
		for (PDVStopa stopa : pdvStope) {
			retVal.add(convert(stopa));
		}
		
		return retVal;	
	}
}
