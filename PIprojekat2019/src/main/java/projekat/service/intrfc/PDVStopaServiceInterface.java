package projekat.service.intrfc;

import java.util.List;

import projekat.model.PDVStopa;

public interface PDVStopaServiceInterface {
	
	PDVStopa findByProcenat(double procenat);

	PDVStopa save(PDVStopa pdvStopa);

	PDVStopa findOne(Long id);

	List<PDVStopa> findAll();
	
	void remove(Long id);

}
