package projekat.service.intrfc;

import java.util.List;
import projekat.model.Otpremnica;

public interface OtpremnicaServiceInterface {
	
	Otpremnica findByKupac (String kupac);
	
	Otpremnica findByBrojOtpremnice (int brojOtpremnice);
	
	Otpremnica save(Otpremnica otpremnica);

	Otpremnica findOne(Long id);

	List<Otpremnica> findAll();
	
	void remove(Long id);

}
