package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;

import projekat.model.PoslovniPartner;

public interface PoslovniPartnerServiceInterface {
	
	PoslovniPartner findByNazivPoslovnogPartnera (String nazivPoslovnogPartnera);
	
	PoslovniPartner save(PoslovniPartner poslovniPartner);

	PoslovniPartner findOne(Long id);

	List<PoslovniPartner> findAll();
	
	void remove(Long id);
	
	Page<PoslovniPartner> findAll(int pageNo, int pageSize);
	
	Page<PoslovniPartner> findAllByNazivPoslovnogPartnera (String nazivPoslovnogPartnera, int pageNo, int pageSize);
	
	Page<PoslovniPartner> findAllByAdresa (String adresa, int pageNo, int pageSize);
	
	Page<PoslovniPartner> findAllByEmail (String email, int pageNo, int pageSize);
	
	Page<PoslovniPartner> findAllByVrstaPartnera (String vrstaPartnera, int pageNo, int pageSize);

}
