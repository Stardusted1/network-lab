package marko.andrushchenko.networklab1.database;

import marko.andrushchenko.networklab1.entities.Car;
import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;
import org.springframework.data.repository.CrudRepository;

public interface PersonToCarRepository  extends CrudRepository<PersonToCarOwnership, Long> {
	PersonToCarOwnership findByIdEquals(Long id);
	void  deleteByIdEquals(Long Id);
	Iterable<PersonToCarOwnership> findAllByOwnerEquals(Person Owner);
	Iterable<PersonToCarOwnership> findAllByPropertyEquals(Car property);
}
