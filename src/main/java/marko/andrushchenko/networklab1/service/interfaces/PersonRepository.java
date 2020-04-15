package marko.andrushchenko.networklab1.service.interfaces;

import marko.andrushchenko.networklab1.entities.Person;


public interface PersonRepository {
	public Person getPerson(Long Id);
	public Iterable<Person> getPersons();
	public Person updatePerson(Person person);
	public boolean deletePerson(Long Id);
	public boolean createPerson(Person person);
}
