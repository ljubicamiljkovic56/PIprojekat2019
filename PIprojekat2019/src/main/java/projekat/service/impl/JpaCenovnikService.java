package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Cenovnik;
import projekat.repository.CenovnikRepository;
import projekat.service.m.CenovnikService;

@Transactional
@Service
public class JpaCenovnikService implements CenovnikService {

	@Autowired
	private CenovnikRepository cenovnikRepository;
	
	@Override
	public Cenovnik findOne(int id) {
		return cenovnikRepository.findOne(id);
	}

	@Override
	public List<Cenovnik> findAll() {
		return cenovnikRepository.findAll();
	}
	

	@Override
	public Cenovnik save(Cenovnik cenovnik) {
		return cenovnikRepository.save(cenovnik);
	}

	@Override
	public List<Cenovnik> save(List<Cenovnik> cenovnici) {
		return cenovnikRepository.save(cenovnici);
	}

	@Override
	public Cenovnik delete(int id) {
		Cenovnik cenovnik = cenovnikRepository.findOne(id);
		if(cenovnik == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojeceg cenovnika");
		}
		cenovnikRepository.delete(cenovnik);
		return cenovnik;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}
	}

}
