package projekat.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekat.model.PDVStopa;
import projekat.repository.PDVStopaRepository;
import projekat.service.intrfc.PDVStopaServiceInterface;

@Transactional
@Service
public class PDVStopaService implements PDVStopaServiceInterface {
	
	@Autowired
	private PDVStopaRepository pdvStopaRepository;

	@Override
	public PDVStopa findByProcenat(double procenat) {
		return pdvStopaRepository.findByProcenat(procenat);
	}

	@Override
	public PDVStopa save(PDVStopa pdvStopa) {
		return pdvStopaRepository.save(pdvStopa);
	}

	@Override
	public PDVStopa findOne(Long id) {
		return pdvStopaRepository.findOne(id);
	}

	@Override
	public List<PDVStopa> findAll() {
		return pdvStopaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		pdvStopaRepository.delete(id);

	}

}
