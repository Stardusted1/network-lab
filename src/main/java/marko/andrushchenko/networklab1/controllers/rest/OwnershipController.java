package marko.andrushchenko.networklab1.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;
import marko.andrushchenko.networklab1.service.interfaces.PersonToCarOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/demo")
public class OwnershipController {
	@Autowired
	PersonToCarOwnershipRepository ownershipRepository;

	@GetMapping("{id}/ownerships")
	public PersonToCarOwnership getOwnerships(@PathVariable Long id) {
		return ownershipRepository.getOwnership(id);
	}

	@GetMapping("/ownerships")
	public Iterable<PersonToCarOwnership> getOwnerships() {
		return ownershipRepository.getOwnerships();
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
}
