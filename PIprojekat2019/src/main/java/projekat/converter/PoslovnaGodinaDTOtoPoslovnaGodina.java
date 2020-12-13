package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.PoslovnaGodinaDTO;
import projekat.model.PoslovnaGodina;
import projekat.model.Preduzece;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Component
public class PoslovnaGodinaDTOtoPoslovnaGodina implements Converter<PoslovnaGodinaDTO, PoslovnaGodina> {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Override
	public PoslovnaGodina convert(PoslovnaGodinaDTO godinaDTO) {
		
		PoslovnaGodina godina = new PoslovnaGodina();
		
		godina.setIdGodine(godinaDTO.getIdGodine());
		godina.setGodina(godinaDTO.getGodina());
		godina.setZakljucena(godinaDTO.isZakljucena());
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(godinaDTO.getIdPreduzeca());
		if(preduzece != null) {
			godina.setPreduzece(preduzece);
		}
		
		return godina;
	}

}
