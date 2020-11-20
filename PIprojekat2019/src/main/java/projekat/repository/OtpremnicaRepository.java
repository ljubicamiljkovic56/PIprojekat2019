package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.Otpremnica;

public interface OtpremnicaRepository extends JpaRepository<Otpremnica, Long> {
	
	Otpremnica findByKupac (String kupac);
	
	Otpremnica findByBrojOtpremnice (int brojOtpremnice);
	
	List<Otpremnica> findAll();

}
