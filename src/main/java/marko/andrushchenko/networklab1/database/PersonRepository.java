package marko.andrushchenko.networklab1.database;

import marko.andrushchenko.networklab1.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
	Person findByIdEquals(Long id);
	Person deletePersonByIdEquals(Long id);
}
