package pl.madison.dao;

import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.Wynagrodzenie;

public interface WynagrodzenieDao extends CrudRepository<Wynagrodzenie, Long> {
}
