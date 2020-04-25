package marko.andrushchenko.networklab1.service;

import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.service.interfaces.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    @Transactional
    @Override
    public boolean deletePerson(Long Id) {

        personRepository.deleteByIdEquals(Id);
        return true;
    }

    @Override
    public boolean createPerson(Person person) {
        personRepository.save(person);
        return true;
    }
}
