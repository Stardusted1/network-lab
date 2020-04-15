package marko.andrushchenko.networklab1.service;

import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.service.interfaces.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonRepositoryImpl implements PersonRepository {
	@Autowired
	marko.andrushchenko.networklab1.database.PersonRepository personRepository;

	@Override
	public Person getPerson(Long Id) {
		return personRepository.findByIdEquals(Id);
	}

	@Override
	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public boolean deletePerson(Long Id) {
		try {
			personRepository.deletePersonByIdEquals(Id);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean createPerson(Person person) {
		personRepository.save(person);
		return true;
	}
}
