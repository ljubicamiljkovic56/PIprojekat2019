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
	public RobaUsluga convert(RobaUslugaDTO robaDTO) {
		
		RobaUsluga robaUsluga = new RobaUsluga();
		
		robaUsluga.setIdRobeUsluge(robaDTO.getIdRobeUsluge());
		robaUsluga.setNazivRobeUsluge(robaDTO.getNazivRobeUsluge());
		robaUsluga.setOpis(robaDTO.getOpis());
		robaUsluga.setRoba(robaDTO.isRoba());
		
		JedinicaMere jedinicaMere = jedinicaMereServiceInterface.findOne(robaDTO.getIdJedinicaMere());
		if(jedinicaMere != null) {
			robaUsluga.setJedinicaMere(jedinicaMere);
		}
		
		GrupaRobeUsluga grupaRobe = grupaRobeUslugaServiceInterface.findOne(robaDTO.getIdGrupeRobeUsluga());
		if(grupaRobe != null) {
			robaUsluga.setGrupaRobeUsluga(grupaRobe);
		}
		
		return robaUsluga;
		

		
	}
		
	

}
