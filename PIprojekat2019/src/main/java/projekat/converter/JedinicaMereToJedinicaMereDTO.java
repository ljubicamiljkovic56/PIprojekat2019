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
	public JedinicaMereDTO convert(JedinicaMere source) {
		
		JedinicaMereDTO jedinicaMereDto = new JedinicaMereDTO();
		
		jedinicaMereDto.setIdJediniceMere(source.getIdJediniceMere());
		jedinicaMereDto.setNazivJediniceMere(source.getNazivJediniceMere());
		jedinicaMereDto.setSkraceniNaziv(source.getSkraceniNaziv());
		
		return jedinicaMereDto;
	}
	
	public List<JedinicaMereDTO> convert(List<JedinicaMere> jediniceMere){
		
		List<JedinicaMereDTO> retVal = new ArrayList<JedinicaMereDTO>();
		
		for (JedinicaMere jedinica : jediniceMere) {
			retVal.add(convert(jedinica));
		}
		
		return retVal;	
	}

}
