package projekat.service.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.model.Cenovnik;
import projekat.repository.CenovnikRepository;
import projekat.service.intrfc.CenovnikServiceInterface;

@Service
public class CenovnikService implements CenovnikServiceInterface {
	
	@Autowired
	private CenovnikRepository cenovnikRepository;

	@Override
	public Cenovnik save(Cenovnik cenovnik) {
		return cenovnikRepository.save(cenovnik);
	}

	@Override
	public Cenovnik findOne(Long id) {
		return cenovnikRepository.findOne(id);
	}

	@Override
	public List<Cenovnik> findAll() {
		return cenovnikRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		cenovnikRepository.delete(id);
	}

	@Override
	public Cenovnik findByDatumPocetkaVazenja(Date datumVazenja) {
		return cenovnikRepository.findByDatumPocetkaVazenja(datumVazenja);
	}

}