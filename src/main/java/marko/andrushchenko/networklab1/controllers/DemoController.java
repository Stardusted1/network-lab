package marko.andrushchenko.networklab1.controllers;

import marko.andrushchenko.networklab1.entities.Car;
import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;
import marko.andrushchenko.networklab1.service.interfaces.CarRepository;
import marko.andrushchenko.networklab1.service.interfaces.PersonRepository;
import marko.andrushchenko.networklab1.service.interfaces.PersonToCarOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	PersonToCarOwnershipRepository ownershipRepository;
	@Autowired
	CarRepository carRepository;
	@Autowired
	PersonRepository personRepository;

	@GetMapping("/test")
	public Iterable<Person> runDemo() {
		for (int i = 0; i < 5; i++) {
			Person person = new Person();
			person.setFirstName("Aloha");
			person.setLastName("Hallo");
			person.setAge(20);
			person.setHeight(20.0);
			person.setWeight(11.0);

			Car car = new Car();
			car.setModel("Jiguli");
			car.setEngineVolume("5000cm^3");

			PersonToCarOwnership ownership = new PersonToCarOwnership();
			ownership.setOwner(person);
			ownership.setProperty(car);

			HashSet<PersonToCarOwnership> ownerships = new HashSet<>();
			ownerships.add(ownership);


			personRepository.createPerson(person);
			carRepository.createCar(car);
			person.setOwnership(ownerships);
			car.setOwners(ownerships);
			ownershipRepository.createOwnership(ownership);
			personRepository.updatePerson(person);
			carRepository.updateCar(car);
		}
		return personRepository.getPersons();
	}
}
