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
	public PoslovnaGodina convert(PoslovnaGodinaDTO source) {
		
		PoslovnaGodina godina = new PoslovnaGodina();
		
		godina.setIdGodine(source.getIdGodine());
		godina.setGodina(source.getGodina());
		godina.setZakljucena(source.isZakljucena());
		
		Preduzece preduzece = preduzeceServiceInterface.findOne(source.getIdPreduzeca());
		if(preduzece != null) {
			godina.setPreduzece(preduzece);
		}
		
		return godina;
	}

}
