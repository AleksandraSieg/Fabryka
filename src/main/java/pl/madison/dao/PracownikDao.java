package pl.madison.dao;

import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.Pracownik;

public interface PracownikDao extends CrudRepository<Pracownik, Long> {
}
