package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaOtpremniceDTO;
import projekat.model.Otpremnica;
import projekat.model.RobaUsluga;
import projekat.model.StavkaOtpremnice;
import projekat.service.intrfc.OtpremnicaServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@Component
public class StavkaOtpremniceDTOtoStavkaOtpremnice implements Converter<StavkaOtpremniceDTO, StavkaOtpremnice> {

	@Autowired
	private OtpremnicaServiceInterface otpremnicaServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Override
	public StavkaOtpremnice convert(StavkaOtpremniceDTO stavkaDTO) {
		
		StavkaOtpremnice stavkaOtpremnice = new StavkaOtpremnice();
		
		stavkaOtpremnice.setIdStavkeOtpremnice(stavkaDTO.getIdStavkeOtpremnice());
		stavkaOtpremnice.setRedniBrojProizvoda(stavkaDTO.getRedniBrojProizvoda());
		stavkaOtpremnice.setJedinicaMere(stavkaDTO.getJedinicaMere());
		stavkaOtpremnice.setCena(stavkaDTO.getCena());
		stavkaOtpremnice.setKolicina(stavkaDTO.getKolicina());
		stavkaOtpremnice.setNapomena(stavkaDTO.getNapomena());

		
		Otpremnica otpremnica = otpremnicaServiceInterface.findOne(stavkaDTO.getIdOtpremnice());
		if(otpremnica != null) {
			stavkaOtpremnice.setOtpremnica(otpremnica);
		}
		
		RobaUsluga roba = robaUslugaServiceInterface.findOne(stavkaDTO.getIdRobeUsluge());
		if(roba != null) {
			stavkaOtpremnice.setRobaUsluga(roba);
		}
		
		return stavkaOtpremnice;
	}
}
