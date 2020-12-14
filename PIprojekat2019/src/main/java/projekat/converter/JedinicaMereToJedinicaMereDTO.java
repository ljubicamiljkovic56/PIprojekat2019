package projekat.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.JedinicaMereDTO;
import projekat.model.JedinicaMere;

@Component
public class JedinicaMereToJedinicaMereDTO implements Converter<JedinicaMere, JedinicaMereDTO> {
	
	@Override
	public JedinicaMereDTO convert(JedinicaMere jedinicaMere) {
		
		JedinicaMereDTO jedinicaMereDto = new JedinicaMereDTO();
		
		jedinicaMereDto.setIdJediniceMere(jedinicaMere.getIdJediniceMere());
		jedinicaMereDto.setNazivJediniceMere(jedinicaMere.getNazivJediniceMere());
		jedinicaMereDto.setSkraceniNaziv(jedinicaMere.getSkraceniNaziv());
		
		return jedinicaMereDto;
	}
	
	public List<JedinicaMereDTO> convert(List<JedinicaMere> jediniceMere){
		
		List<JedinicaMereDTO> retVal = new ArrayList<JedinicaMereDTO>();
		
		for (JedinicaMere jedinicaMere : jediniceMere) {
			retVal.add(convert(jedinicaMere));
		}
		
		return retVal;	
	}

}
