package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Preduzece;
import projekat.repository.PreduzeceRepository;
import projekat.service.intrfc.PreduzeceServiceInterface;

@Transactional
@Service
public class PreduzeceService implements PreduzeceServiceInterface {
	
	@Autowired
	private PreduzeceRepository preduzeceRepository;

	@Override
	public Preduzece findByNazivPreduzeca(String nazivPreduzeca) {
		return preduzeceRepository.findByNazivPreduzeca(nazivPreduzeca);
	}

	@Override
	public Preduzece save(Preduzece preduzece) {
		return preduzeceRepository.save(preduzece);
	}

	@Override
	public Preduzece findOne(Long id) {
		return preduzeceRepository.findOne(id);
	}

	@Override
	public List<Preduzece> findAll() {
		return preduzeceRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		preduzeceRepository.delete(id);
	}

	@Override
	public Page<Preduzece> findAll(int pageNo, int pageSize) {
		return preduzeceRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Preduzece> findAllByNazivPreduzeca(String nazivPreduzeca, int pageNo, int pageSize) {
		return preduzeceRepository.findAllByNazivPreduzeca(nazivPreduzeca, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Preduzece> findAllByAdresa(String adresa, int pageNo, int pageSize) {
		return preduzeceRepository.findAllByAdresa(adresa, new PageRequest(pageNo, pageSize));
	}

}