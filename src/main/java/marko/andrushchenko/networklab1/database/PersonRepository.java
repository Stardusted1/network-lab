package marko.andrushchenko.networklab1.database;

import marko.andrushchenko.networklab1.entities.Person;
import org.aspectj.weaver.patterns.PerSingleton;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
	Person findByIdEquals(Long id);
	void  deleteByIdEquals(Long id);
}
