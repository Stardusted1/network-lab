package marko.andrushchenko.networklab1.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.service.interfaces.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping("{id}")
	public Person getPerson(@PathVariable Long id) {
		return personRepository.getPerson(id);
	}

	@GetMapping()
	public Iterable<Person> getPersons() {
		return personRepository.getPersons();
	}

	@DeleteMapping("{id}")
	public boolean deletePerson(@PathVariable Long id) {
		return personRepository.deletePerson(id);
	}

	@PatchMapping("{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody String body) throws JsonProcessingException {
		Person person = new ObjectMapper().readValue(body, Person.class);
		return personRepository.updatePerson(person);
	}

	@PutMapping()
	public boolean createPerson(@RequestBody String body) throws JsonProcessingException {
		Person person = new ObjectMapper().readValue(body, Person.class);
		return personRepository.createPerson(person);
	}

}
