package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaCenovnikaDTO;
import projekat.model.Cenovnik;
import projekat.model.RobaUsluga;
import projekat.model.StavkaCenovnika;
import projekat.service.intrfc.CenovnikServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@Component
public class StavkaCenovnikaDTOtoStavkaCenovnika implements Converter<StavkaCenovnikaDTO, StavkaCenovnika> {

	@Autowired
	private CenovnikServiceInterface cenovnikServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Override
	public StavkaCenovnika convert(StavkaCenovnikaDTO source) {
		
		StavkaCenovnika stavkaCenovnika = new StavkaCenovnika();
		
		stavkaCenovnika.setIdStavke(source.getIdStavke());
		stavkaCenovnika.setCena(source.getCena());
		
		Cenovnik cenovnik = cenovnikServiceInterface.findOne(source.getIdCenovnika());
		if(cenovnik != null) {
			stavkaCenovnika.setCenovnik(cenovnik);
		}
		
		RobaUsluga roba = robaUslugaServiceInterface.findOne(source.getIdRobeUsluge());
		if(roba != null) {
			stavkaCenovnika.setRobaUsluga(roba);
		}
		
		return stavkaCenovnika;
	}
}
