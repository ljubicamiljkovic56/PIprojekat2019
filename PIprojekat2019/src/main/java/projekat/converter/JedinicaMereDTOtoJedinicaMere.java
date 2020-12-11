package projekat.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.dto.JedinicaMereDTO;
import projekat.model.JedinicaMere;

@Component
public class JedinicaMereDTOtoJedinicaMere implements Converter<JedinicaMereDTO, JedinicaMere> {
	
	@Override
	public JedinicaMere convert(JedinicaMereDTO source) {
		
		JedinicaMere jedinicaMere = new JedinicaMere();
		
		jedinicaMere.setIdJediniceMere(source.getIdJediniceMere());
		jedinicaMere.setNazivJediniceMere(source.getNazivJediniceMere());
		jedinicaMere.setSkraceniNaziv(source.getSkraceniNaziv());
		
		return jedinicaMere;
	}

}
