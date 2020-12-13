package projekat.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.StavkaFaktureDTO;
import projekat.model.Faktura;
import projekat.model.Preduzece;
import projekat.model.RobaUsluga;
import projekat.model.StavkaFakture;
import projekat.service.intrfc.FakturaServiceInterface;
import projekat.service.intrfc.PreduzeceServiceInterface;
import projekat.service.intrfc.RobaUslugaServiceInterface;

@Component
public class StavkaFaktureDTOtoStavkaFakture implements Converter<StavkaFaktureDTO, StavkaFakture> {
	
	@Autowired
	private PreduzeceServiceInterface preduzeceServiceInterface;
	
	@Autowired
	private FakturaServiceInterface fakturaServiceInterface;
	
	@Autowired
	private RobaUslugaServiceInterface robaUslugaServiceInterface;
	
	@Override
	public StavkaFakture convert(StavkaFaktureDTO stavkaFaktureDTO) {
		
		StavkaFakture stavkaFakture = new StavkaFakture();

		stavkaFakture.setIdStavke(stavkaFaktureDTO.getIdStavke());
		stavkaFakture.setKolicina(stavkaFaktureDTO.getKolicina());
		stavkaFakture.setRabat(stavkaFaktureDTO.getRabat());
		stavkaFakture.setJedinicnaCena(stavkaFaktureDTO.getJedinicnaCena());
		stavkaFakture.setPdvStopa(stavkaFaktureDTO.getPdvStopa());
		stavkaFakture.setOsnovicaZaPDV(stavkaFakture.getOsnovicaZaPDV());
		stavkaFakture.setIznosPDV(stavkaFakture.getIznosPDV());
		stavkaFakture.setUkupanIznos(stavkaFaktureDTO.getUkupanIznos());

		Preduzece preduzece = preduzeceServiceInterface.findOne(stavkaFaktureDTO.getIdPreduzeca());
		if(preduzece != null) {
			stavkaFakture.setPreduzece(preduzece);
		}
		
		Faktura faktura = fakturaServiceInterface.findOne(stavkaFaktureDTO.getIdFakture());
		if(faktura != null) {
			stavkaFakture.setFaktura(faktura);
		}
		
		RobaUsluga roba = robaUslugaServiceInterface.findOne(stavkaFaktureDTO.getIdRobeUsluge());
		if(roba != null) {
			stavkaFakture.setRobaUsluga(roba);
		}
		
		return stavkaFakture;
	}


}
