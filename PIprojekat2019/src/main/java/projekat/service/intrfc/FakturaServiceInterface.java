package projekat.service.intrfc;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import projekat.model.Faktura;

@Service
public interface FakturaServiceInterface {
	
	Faktura findByBrojFakture (int brojFakture);
	
	Faktura save(Faktura faktura);

	Faktura findOne(Long id);

	List<Faktura> findAll();
	
	void remove(Long id);

	Page<Faktura> findAll(int pageNo, int pageSize);
	
	Page<Faktura> findAllByBrojFakture (int brojFakture, int pageNo, int pageSize);
	
	Page<Faktura> findAllByStatusFakture (String statusFakture, int pageNo, int pageSize);
}
