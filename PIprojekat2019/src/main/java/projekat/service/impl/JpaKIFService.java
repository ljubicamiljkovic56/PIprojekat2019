package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.KIF;
import projekat.repository.KIFRepository;
import projekat.service.m.KIFService;
@Transactional
@Service
public class JpaKIFService implements KIFService {

	@Autowired
	private KIFRepository kifRepository;
	
	@Override
	public KIF findOne(int id) {
		return kifRepository.findOne(id);
	}

	@Override
	public List<KIF> findAll() {
		return kifRepository.findAll();
	}

	@Override
	public KIF save(KIF kif) {
		return kifRepository.save(kif);
	}

	@Override
	public List<KIF> save(List<KIF> kifovi) {
		return kifRepository.save(kifovi);
	}

	@Override
	public KIF delete(int id) {
		KIF kif = kifRepository.findOne(id);
		if(kif == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojeceg kif-a");
		}
		kifRepository.delete(kif);
		return kif;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}

	}

}
