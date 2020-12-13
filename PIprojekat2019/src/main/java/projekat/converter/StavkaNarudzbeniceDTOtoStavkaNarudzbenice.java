package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaNarudzbeniceDTO;
import projekat.model.Narudzbenica;
import projekat.model.RobaUsluga;
import projekat.model.StavkaNarudzbenice;
import projekat.service.intrfc.NarudzbenicaServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@Component
public class StavkaNarudzbeniceDTOtoStavkaNarudzbenice implements Converter<StavkaNarudzbeniceDTO, StavkaNarudzbenice> {
	
	@Autowired
	private NarudzbenicaServiceInterface narudzbenicaServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Override
	public StavkaNarudzbenice convert(StavkaNarudzbeniceDTO stavkaNDTO) {
		
		StavkaNarudzbenice stavkaNarudzbenice = new StavkaNarudzbenice();
		
		stavkaNarudzbenice.setId(stavkaNDTO.getId());
		stavkaNarudzbenice.setJedinicaMere(stavkaNDTO.getJedinicaMere());
		stavkaNarudzbenice.setKolicina(stavkaNDTO.getKolicina());
		stavkaNarudzbenice.setCena(stavkaNDTO.getCena());
		stavkaNarudzbenice.setIznos(stavkaNDTO.getIznos());
		
		Narudzbenica narudzbenica = narudzbenicaServiceInterface.findOne(stavkaNDTO.getIdNarudzbenice());
		if(narudzbenica != null) {
			stavkaNarudzbenice.setNarudzbenica(narudzbenica);
		}
		
		RobaUsluga roba = robaUslugaServiceInterface.findOne(stavkaNDTO.getIdRobeUsluge());
		if(roba != null) {
			stavkaNarudzbenice.setRobaUsluga(roba);
		}
		
		return stavkaNarudzbenice;
	}

}
