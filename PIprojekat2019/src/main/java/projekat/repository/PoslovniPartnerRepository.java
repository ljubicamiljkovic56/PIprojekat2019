package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekat.model.PoslovniPartner;

public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long> {
	
	PoslovniPartner findByNazivPoslovnogPartnera (String nazivPoslovnogPartnera);
	
	List<PoslovniPartner> findAll();

}
