package projekat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.model.PoslovniPartner;
@Repository
public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long> {
	
	PoslovniPartner findByNazivPoslovnogPartnera (String nazivPoslovnogPartnera);
	
	List<PoslovniPartner> findAll();
	
	Page<PoslovniPartner> findAllByNazivPoslovnogPartnera (String nazivPoslovnogPartnera, Pageable pageable);
	
	Page<PoslovniPartner> findAllByAdresa (String adresa, Pageable pageable);
	
	Page<PoslovniPartner> findAllByEmail (String email, Pageable pageable);
	
	Page<PoslovniPartner> findAllByVrstaPartnera (String vrstaPartnera, Pageable pageable);

}
