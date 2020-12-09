package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.StavkaNarudzbenice;
import projekat.repository.StavkaNarudzbeniceRepository;
import projekat.service.intrfc.StavkaNarudzbeniceServiceInterface;

@Service
public class StavkaNarudzbeniceService implements StavkaNarudzbeniceServiceInterface{

	@Autowired
	private StavkaNarudzbeniceRepository stavkaNarudzbeniceRepository;
	
	@Override
	public List<StavkaNarudzbenice> findAll() {
		return stavkaNarudzbeniceRepository.findAll();
	}
	
	

}
