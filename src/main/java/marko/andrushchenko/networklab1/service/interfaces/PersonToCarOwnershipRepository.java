package marko.andrushchenko.networklab1.service.interfaces;

import marko.andrushchenko.networklab1.entities.PersonToCarOwnership;

public interface PersonToCarOwnershipRepository {
	public PersonToCarOwnership getOwnership(Long Id);
	public Iterable<PersonToCarOwnership> getOwnerships();
	public PersonToCarOwnership updateOwnership(PersonToCarOwnership ownership);
	public boolean deleteOwnership(Long Id);
	public boolean createOwnership(PersonToCarOwnership ownership);
}
