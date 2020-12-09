package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.StavkaOtpremnice;
@Repository
public interface StavkaOtpremniceRepository extends JpaRepository<StavkaOtpremnice, Long> {

	StavkaOtpremnice findByRedniBrojProizvoda (int redniBrojProizvoda);
	
	List<StavkaOtpremnice> findAll();
}
