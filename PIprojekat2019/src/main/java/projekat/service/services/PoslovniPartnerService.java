package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.PoslovniPartner;
import projekat.repository.PoslovniPartnerRepository;
import projekat.service.intrfc.PoslovniPartnerServiceInterface;

@Transactional
@Service
public class PoslovniPartnerService implements PoslovniPartnerServiceInterface {
	
	@Autowired
	private PoslovniPartnerRepository poslovniPartnerRepository;

	@Override
	public PoslovniPartner findByNazivPoslovnogPartnera(String nazivPoslovnogPartnera) {
		return poslovniPartnerRepository.findByNazivPoslovnogPartnera(nazivPoslovnogPartnera);
	}

	@Override
	public PoslovniPartner save(PoslovniPartner poslovniPartner) {
		return poslovniPartnerRepository.save(poslovniPartner);
	}

	@Override
	public PoslovniPartner findOne(Long id) {
		return poslovniPartnerRepository.findOne(id);
	}

	@Override
	public List<PoslovniPartner> findAll() {
		return poslovniPartnerRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		poslovniPartnerRepository.delete(id);

	}

	@Override
	public Page<PoslovniPartner> findAll(int pageNo, int pageSize) {
		return poslovniPartnerRepository.findAll(new PageRequest(pageNo, pageSize));
	}

}
