package marko.andrushchenko.networklab1.database;

import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;
import org.springframework.data.repository.CrudRepository;

public interface PersonToCarRepository  extends CrudRepository<PersonToCarOwnership, Long> {
	PersonToCarOwnership findByIdEquals(Long id);
	PersonToCarOwnership deleteByIdEquals(Long Id);
}
