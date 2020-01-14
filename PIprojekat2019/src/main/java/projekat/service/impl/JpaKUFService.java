package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.KUF;
import projekat.repository.KUFRepository;
import projekat.service.m.KUFService;
@Transactional
@Service
public class JpaKUFService implements KUFService {

	@Autowired
	private KUFRepository kufRepository;
	
	@Override
	public KUF findOne(int id) {
		return kufRepository.findOne(id);
	}

	@Override
	public List<KUF> findAll() {
		return kufRepository.findAll();
	}

	@Override
	public KUF save(KUF kuf) {
		return kufRepository.save(kuf);
	}

	@Override
	public List<KUF> save(List<KUF> kufovi) {
		return kufRepository.save(kufovi);
	}

	@Override
	public KUF delete(int id) {
		KUF kuf = kufRepository.findOne(id);
		if(kuf == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojeceg kuf-a");
		}
		kufRepository.delete(kuf);
		return kuf;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}
	}

}
