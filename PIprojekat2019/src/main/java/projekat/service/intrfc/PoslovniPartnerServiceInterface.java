package projekat.service.intrfc;

import java.util.List;

import projekat.model.PoslovniPartner;

public interface PoslovniPartnerServiceInterface {
	
	PoslovniPartner findByNazivPoslovnogPartnera (String nazivPoslovnogPartnera);
	
	PoslovniPartner save(PoslovniPartner poslovniPartner);

	PoslovniPartner findOne(Long id);

	List<PoslovniPartner> findAll();
	
	void remove(Long id);

}
