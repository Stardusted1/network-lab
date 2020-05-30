package marko.andrushchenko.networklab1.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import marko.andrushchenko.networklab1.entities.Person;
import marko.andrushchenko.networklab1.service.interfaces.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
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
	public Person updatePerson(@PathVariable Long id, @RequestBody String body)
			throws JsonProcessingException {
		Person person = new ObjectMapper().readValue(body, Person.class);
		try {
			Person person_from_db =  personRepository.getPerson(id);
			person_from_db.setFirstName(person.getFirstName());
			person_from_db.setLastName(person.getLastName());
			person_from_db.setAge(person.getAge());
			person_from_db.setHeight(person.getHeight());
			person_from_db.setWeight(person.getWeight());
			return personRepository.updatePerson(person_from_db);
		} catch (Exception e){
			return null;
		}
	}

	@PutMapping()
	public boolean createPerson(@RequestBody String body) throws JsonProcessingException {
		Person person = new ObjectMapper().readValue(body, Person.class);
		return personRepository.createPerson(person);
	}
}
