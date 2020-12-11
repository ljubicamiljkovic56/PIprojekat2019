package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.RobaUslugaDTO;
import projekat.model.GrupaRobeUsluga;
import projekat.model.JedinicaMere;
import projekat.model.RobaUsluga;
import projekat.service.intrfc.GrupaRobeUslugaServiceInterface;
import projekat.service.intrfc.JedinicaMereServiceInterface;
@Component
public class RobaUslugaDTOtoRobaUsluga implements Converter<RobaUslugaDTO, RobaUsluga> {
	
	@Autowired
	private JedinicaMereServiceInterface jedinicaMereServiceInterface;

	@Autowired
	private GrupaRobeUslugaServiceInterface grupaRobeUslugaServiceInterface;
	
	@Override
	public RobaUsluga convert(RobaUslugaDTO source) {
		
		RobaUsluga robaUsluga = new RobaUsluga();
		
		robaUsluga.setIdRobeUsluge(source.getIdRobeUsluge());
		robaUsluga.setNazivRobeUsluge(source.getNazivRobeUsluge());
		robaUsluga.setOpis(source.getOpis());
		robaUsluga.setRoba(source.isRoba());
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findOne(source.getIdJedinicaMere());
		if(jedinicaMere != null) {
			robaUsluga.setJedinicaMere(jedinicaMere);
		}
		
		GrupaRobeUsluga grupaRobe = grupaRobeUslugaServiceInterface.findOne(source.getIdGrupeRobeUsluga());
		if(grupaRobe != null) {
			robaUsluga.setGrupaRobeUsluga(grupaRobe);
		}
		
		return robaUsluga;
		

		
	}
		
	

}
