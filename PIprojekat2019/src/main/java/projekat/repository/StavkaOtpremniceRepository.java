package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.StavkaOtpremnice;

public interface StavkaOtpremniceRepository extends JpaRepository<StavkaOtpremnice, Long> {

	StavkaOtpremnice findByRedniBrojProizvoda (int redniBrojProizvoda);
	
	List<StavkaOtpremnice> findAll();
}
