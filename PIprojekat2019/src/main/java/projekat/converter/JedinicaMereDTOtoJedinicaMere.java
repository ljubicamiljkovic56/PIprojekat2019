package projekat.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.JedinicaMereDTO;
import projekat.model.JedinicaMere;

@Component
public class JedinicaMereDTOtoJedinicaMere implements Converter<JedinicaMereDTO, JedinicaMere> {
	
	@Override
	public JedinicaMere convert(JedinicaMereDTO jedinicaDTO) {
		
		JedinicaMere jedinicaMere = new JedinicaMere();
		
		jedinicaMere.setIdJediniceMere(jedinicaDTO.getIdJediniceMere());
		jedinicaMere.setNazivJediniceMere(jedinicaDTO.getNazivJediniceMere());
		jedinicaMere.setSkraceniNaziv(jedinicaDTO.getSkraceniNaziv());
		
		return jedinicaMere;
	}

}
