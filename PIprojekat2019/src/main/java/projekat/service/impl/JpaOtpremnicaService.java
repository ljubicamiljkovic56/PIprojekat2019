package projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Otpremnica;
import projekat.repository.OtpremnicaRepository;
import projekat.service.m.OtpremnicaService;

@Transactional
@Service
public class JpaOtpremnicaService implements OtpremnicaService {

	@Autowired
	private OtpremnicaRepository otpremnicaRepository;
	
	@Override
	public Otpremnica findOne(int id) {
		return otpremnicaRepository.findOne(id);
	}

	@Override
	public List<Otpremnica> findAll() {
		return otpremnicaRepository.findAll();
	}

	@Override
	public Otpremnica save(Otpremnica otpremnica) {
		return otpremnicaRepository.save(otpremnica);
	}

	@Override
	public List<Otpremnica> save(List<Otpremnica> otpremnice) {
		return otpremnicaRepository.save(otpremnice);
	}

	@Override
	public Otpremnica delete(int id) {
		Otpremnica otpremnica = otpremnicaRepository.findOne(id);
		if(otpremnica == null){
			throw new IllegalArgumentException("Pokusaj brisanja nepostojece otpremnice");
		}
		otpremnicaRepository.delete(otpremnica);
		return otpremnica;
	}

	@Override
	public void delete(List<Integer> ids) {
		for(Integer id : ids){
			this.delete(id);
		}

	}

}
