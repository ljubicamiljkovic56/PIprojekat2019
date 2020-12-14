package projekat.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.JedinicaMereDTO;
import projekat.model.JedinicaMere;

@Component
public class JedinicaMereDTOtoJedinicaMere implements Converter<JedinicaMereDTO, JedinicaMere> {
	
	@Override
	public JedinicaMere convert(JedinicaMereDTO jedinicaMereDTO) {
		
		JedinicaMere jedinicaMere = new JedinicaMere();
		
		jedinicaMere.setIdJediniceMere(jedinicaMereDTO.getIdJediniceMere());
		jedinicaMere.setNazivJediniceMere(jedinicaMereDTO.getNazivJediniceMere());
		jedinicaMere.setSkraceniNaziv(jedinicaMereDTO.getSkraceniNaziv());
		
		return jedinicaMere;
	}

}
