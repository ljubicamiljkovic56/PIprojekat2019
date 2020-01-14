package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.StavkaOtpremnice;
import projekat.repository.StavkaOtpremniceRepository;
import projekat.service.m.StavkaOtpremniceService;

@Transactional
@Service
public class JpaStavkaOtpremniceService implements StavkaOtpremniceService {

	@Autowired
	private StavkaOtpremniceRepository stavkaOtpremniceRepository;
	
	@Override
	public StavkaOtpremnice findOne(int id) {
		return stavkaOtpremniceRepository.findOne(id);
	}

	@Override
	public List<StavkaOtpremnice> findAll() {
		return stavkaOtpremniceRepository.findAll();
	}

	@Override
	public StavkaOtpremnice save(StavkaOtpremnice stavkaO) {
		return stavkaOtpremniceRepository.save(stavkaO);
	}

	@Override
	public List<StavkaOtpremnice> save(List<StavkaOtpremnice> stavkeO) {
		return stavkaOtpremniceRepository.save(stavkeO);
	}

	@Override
	public StavkaOtpremnice delete(int id) {
		StavkaOtpremnice stavkaOtpremnice = stavkaOtpremniceRepository.findOne(id);
		if(stavkaOtpremnice == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojece stavke otpremnice");
		}
		stavkaOtpremniceRepository.delete(stavkaOtpremnice);
		return stavkaOtpremnice;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}
	}

}
