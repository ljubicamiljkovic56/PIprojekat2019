package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.Otpremnica;

@Repository
public interface OtpremnicaRepository extends JpaRepository<Otpremnica, Long> {
	
	Otpremnica findByKupac (String kupac);
	
	Otpremnica findByBrojOtpremnice (int brojOtpremnice);
	
	List<Otpremnica> findAll();

}
