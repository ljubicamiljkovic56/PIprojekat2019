package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Faktura;
import projekat.repository.FakturaRepository;
import projekat.service.m.FakturaService;

@Transactional
@Service
public class JpaFakturaService implements FakturaService {

	@Autowired
	private FakturaRepository fakturaRepository;
	
	@Override
	public Faktura findOne(int id) {
		return fakturaRepository.findOne(id);
	}

	@Override
	public List<Faktura> findAll() {
		return fakturaRepository.findAll();
	}

	@Override
	public Faktura save(Faktura faktura) {
		return fakturaRepository.save(faktura);
	}

	@Override
	public List<Faktura> save(List<Faktura> fakture) {
		return fakturaRepository.save(fakture);
	}

	@Override
	public Faktura delete(int id) {
		Faktura faktura = fakturaRepository.findOne(id);
		if(faktura == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojece fakture");
		}
		fakturaRepository.delete(faktura);
		return faktura;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}

	}

}
