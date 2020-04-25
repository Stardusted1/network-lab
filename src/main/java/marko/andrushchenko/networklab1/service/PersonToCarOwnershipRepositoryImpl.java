package marko.andrushchenko.networklab1.service;

import marko.andrushchenko.networklab1.database.PersonToCarRepository;
import marko.andrushchenko.networklab1.entities.Car;
import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;
import marko.andrushchenko.networklab1.service.interfaces.PersonToCarOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonToCarOwnershipRepositoryImpl implements PersonToCarOwnershipRepository {
    @Autowired
    PersonToCarRepository personToCarRepository;

    @Override
    public PersonToCarOwnership getOwnership(Long Id) {
        return personToCarRepository.findByIdEquals(Id);
    }

    @Override
    public Iterable<PersonToCarOwnership> getOwnerships() {
        return personToCarRepository.findAll();
    }

    @Override
    public PersonToCarOwnership updateOwnership(PersonToCarOwnership ownership) {
        return personToCarRepository.save(ownership);
    }
    @Transactional
    @Override
    public boolean deleteOwnership(Long Id) {

        personToCarRepository.deleteByIdEquals(Id);
        return true;

    }

    @Override
    public boolean createOwnership(PersonToCarOwnership ownership) {
        personToCarRepository.save(ownership);
        return true;
    }

    @Override
    public Iterable<PersonToCarOwnership> getAllWherePersonEquals(Person person) {
        return personToCarRepository.findAllByOwnerEquals(person);
    }

    @Override
    public Iterable<PersonToCarOwnership> getAllWhereCarEquals(Car car) {
        return personToCarRepository.findAllByPropertyEquals(car);
    }
}
