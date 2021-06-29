package co.com.mercadolibre.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.com.mercadolibre.entities.Satelite;

public interface ISateliteDAO extends CrudRepository<Satelite, String> {

	@Query("SELECT u FROM Satelite u WHERE u.name = ?1")
	List<Satelite> findOneByName(String name);
}