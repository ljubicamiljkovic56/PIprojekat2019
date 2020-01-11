package projekat.service.m;

import java.util.List;

import projekat.model.Otpremnica;

public interface OtpremnicaService {

	Otpremnica findOne(int id);
	
	List<Otpremnica> findAll();
	
	Otpremnica save(Otpremnica otpremnica);
	
	List<Otpremnica> save(List<Otpremnica> otpremnice);

	Otpremnica delete(int id);
	
	void delete(List<Integer> ids);
	
}
