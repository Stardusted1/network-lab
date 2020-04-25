package marko.andrushchenko.networklab1.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import marko.andrushchenko.networklab1.entities.Car;
import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;
import marko.andrushchenko.networklab1.service.interfaces.CarRepository;
import marko.andrushchenko.networklab1.service.interfaces.PersonRepository;
import marko.andrushchenko.networklab1.service.interfaces.PersonToCarOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/")
public class OwnershipController {
    @Autowired
    PersonToCarOwnershipRepository ownershipRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("{id}/ownerships")
    public PersonToCarOwnership getOwnerships(@PathVariable Long id) {
        return ownershipRepository.getOwnership(id);
    }

    @GetMapping("/ownerships")
    public Iterable<PersonToCarOwnership> getOwnerships() {
        return ownershipRepository.getOwnerships();
    }

    @GetMapping("/ownerships/person/{id}")
    public Iterable<PersonToCarOwnership> getOwnershipsByPerson(@PathVariable Long id) {
        Person person = personRepository.getPerson(id);
        return ownershipRepository.getAllWherePersonEquals(person);
    }

    @GetMapping("/ownerships/car/{id}")
    public Iterable<PersonToCarOwnership> getOwnershipsByCar(@PathVariable Long id) {
        Car car = carRepository.getCar(id);
        return ownershipRepository.getAllWhereCarEquals(car);
    }

    @DeleteMapping("{id}/ownerships")
    public boolean deleteOwnership(@PathVariable Long id) {
        return ownershipRepository.deleteOwnership(id);
    }

    @PatchMapping("{id}/ownerships")
    public PersonToCarOwnership updateOwnerships(@PathVariable Long id, @RequestBody String body) throws JsonProcessingException {
        PersonToCarOwnership person = new ObjectMapper().readValue(body, PersonToCarOwnership.class);
        return ownershipRepository.updateOwnership(person);
    }

    @PutMapping("/ownerships")
    public boolean createPerson(@RequestBody String body) throws JsonProcessingException {
        PersonToCarOwnership ownership = new ObjectMapper().readValue(body, PersonToCarOwnership.class);
        return ownershipRepository.createOwnership(ownership);
    }

    @PostMapping("/ownerships/fromuser/{id}")
    public boolean getOwnershipsFromUser(@RequestBody String body, @PathVariable(name = "id") Long id) {
        body = body.replaceAll(" ", "");
        if (body.equals("")){
            Person person1 = personRepository.getPerson(id);
            for (var own : person1.getOwnership()) {
                person1.removeOwnership(own);
                ownershipRepository.deleteOwnership(own.getId());
            }
            return true;
        }
        String[] carIds = body.split(",");
        Person person = personRepository.getPerson(id);
        ArrayList<Long> ownerships = new ArrayList<>();

        if (person.getOwnership() != null) {
            PersonToCarOwnership[] ownershipsPTC = new PersonToCarOwnership[person.getOwnership().size()];
            person.getOwnership().toArray(ownershipsPTC);
            for (var onwersh : ownershipsPTC) {
                ownerships.add(onwersh.getProperty().getId());
            }
        } else {
            for (var carIdS : carIds) {
                Long carId = Long.parseLong(carIdS);
                if (!ownerships.contains(carId)) {
                    PersonToCarOwnership ownership = new PersonToCarOwnership();
                    Car car = carRepository.getCar(carId);

                    ownership.setOwner(person);
                    ownership.setProperty(car);

                    person.addOwnership(ownership);
                    car.addOwnership(ownership);
                    ownershipRepository.createOwnership(ownership);
                    carRepository.updateCar(car);
                    personRepository.updatePerson(person);
                    ownerships.remove(carId);
                }
            }
        }
        for (var carIdS : carIds) {
            Long carId = Long.parseLong(carIdS);
            if (!ownerships.contains(carId)) {
                PersonToCarOwnership ownership = new PersonToCarOwnership();
                Car car = carRepository.getCar(carId);

                ownership.setOwner(person);
                ownership.setProperty(car);

                person.addOwnership(ownership);
                car.addOwnership(ownership);
                ownershipRepository.createOwnership(ownership);
                carRepository.updateCar(car);
                personRepository.updatePerson(person);
                ownerships.remove(carId);
            }

        }
        if (ownerships.size() > 0) {
            for (var carId : ownerships) {
                Car car = carRepository.getCar(carId);
                ArrayList<PersonToCarOwnership> ptco = (ArrayList<PersonToCarOwnership>) ownershipRepository.getAllWherePersonEquals(person);
                for (var own : ptco) {
                    if (own.getProperty().getId().equals(carId)) {
                        ownershipRepository.deleteOwnership(own.getId());
                    }
                }
            }
        }
        return true;
    }

    @PostMapping("/ownerships/fromcar/{id}")
    public boolean getOwnershipsFromCar(@RequestBody String body, @PathVariable(name = "id") Long id) {
        body = body.replaceAll(" ", "");
        if (body.equals("")){
            Car car1 = carRepository.getCar(id);
            for (var own : car1.getOwnersship()) {
                car1.removeOwnership(own);
                ownershipRepository.deleteOwnership(own.getId());

            }
            return true;
        }
        String[] carIds = body.split(",");
        Car car1 = carRepository.getCar(id);
        ArrayList<Long> ownerships = new ArrayList<>();

        if (car1.getOwnersship() != null) {
            PersonToCarOwnership[] ownershipsPTC = new PersonToCarOwnership[car1.getOwnersship().size()];
            car1.getOwnersship().toArray(ownershipsPTC);
            for (var onwersh : ownershipsPTC) {
                ownerships.add(onwersh.getProperty().getId());
            }
        } else {
            for (var carIdS : carIds) {
                Long carId = Long.parseLong(carIdS);
                if (!ownerships.contains(carId)) {
                    PersonToCarOwnership ownership = new PersonToCarOwnership();
                    Person person = personRepository.getPerson(carId);

                    ownership.setProperty(car1);
                    ownership.setOwner(person);

                    car1.addOwnership(ownership);
                    person.addOwnership(ownership);
                    ownershipRepository.createOwnership(ownership);
                    carRepository.updateCar(car1);
                    personRepository.updatePerson(person);
                    ownerships.remove(carId);
                }
            }
        }
        for (var carIdS : carIds) {
            Long carId = Long.parseLong(carIdS);
            if (!ownerships.contains(carId)) {
                PersonToCarOwnership ownership = new PersonToCarOwnership();
                Person person = personRepository.getPerson(carId);

                ownership.setOwner(person);
                ownership.setProperty(car1);

                car1.addOwnership(ownership);
                person.addOwnership(ownership);
                ownershipRepository.createOwnership(ownership);
                carRepository.updateCar(car1);
                personRepository.updatePerson(person);
                ownerships.remove(carId);
            }

        }
        if (ownerships.size() > 0) {
            for (var carId : ownerships) {
                Person person = personRepository.getPerson(id);
                ArrayList<PersonToCarOwnership> ptco = (ArrayList<PersonToCarOwnership>)
                        ownershipRepository.getAllWhereCarEquals(car1);
                for (var own : ptco) {
                    if (own.getProperty().getId().equals(carId)) {
                        ownershipRepository.deleteOwnership(own.getId());
                        car1.removeOwnership(own);
                    }
                }
            }
        }
        return true;
    }
}
