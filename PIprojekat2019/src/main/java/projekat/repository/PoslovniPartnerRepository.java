package projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.PoslovniPartner;
@Repository
public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long> {
	
	PoslovniPartner findByNazivPoslovnogPartnera (String nazivPoslovnogPartnera);
	
	List<PoslovniPartner> findAll();

}
