package projekat.service.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.Otpremnica;
import projekat.repository.OtpremnicaRepository;
import projekat.service.intrfc.OtpremnicaServiceInterface;

@Transactional
@Service
public class OtpremnicaService implements OtpremnicaServiceInterface {
	
	@Autowired
	private OtpremnicaRepository otpremnicaRepository;

	@Override
	public Otpremnica findByKupac(String kupac) {
		return otpremnicaRepository.findByKupac(kupac);
	}

	@Override
	public Otpremnica findByBrojOtpremnice(int brojOtpremnice) {
		return otpremnicaRepository.findByBrojOtpremnice(brojOtpremnice);
	}

	@Override
	public Otpremnica save(Otpremnica otpremnica) {
		return otpremnicaRepository.save(otpremnica);
	}

	@Override
	public Otpremnica findOne(Long id) {
		return otpremnicaRepository.findOne(id);
	}

	@Override
	public List<Otpremnica> findAll() {
		return otpremnicaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		otpremnicaRepository.delete(id);

	}

	@Override
	public Page<Otpremnica> findAll(int pageNo, int pageSize) {
		return otpremnicaRepository.findAll(new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Otpremnica> findAllByBrojOtpremnice(int brojOtpremnice, int pageNo, int pageSize) {
		return otpremnicaRepository.findAllByBrojOtpremnice(brojOtpremnice, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Otpremnica> findAllByKupac(String kupac, int pageNo, int pageSize) {
		return otpremnicaRepository.findAllByKupac(kupac, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Otpremnica> findAllByAdresaIsporuke(String adresaIsporuke, int pageNo, int pageSize) {
		return otpremnicaRepository.findAllByAdresaIsporuke(adresaIsporuke, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Otpremnica> findAllByDatumIsporuke(Date datumIsporuke, int pageNo, int pageSize) {
		return otpremnicaRepository.findAllByDatumIsporuke(datumIsporuke, new PageRequest(pageNo, pageSize));
	}

	@Override
	public Page<Otpremnica> findAllByPrevoznik(String prevoznik, int pageNo, int pageSize) {
		return otpremnicaRepository.findAllByPrevoznik(prevoznik, new PageRequest(pageNo, pageSize));
	}

}
