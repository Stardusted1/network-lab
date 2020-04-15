package marko.andrushchenko.networklab1.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String model;
	private String engineVolume;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<PersonToCarOwnership> ownersship;
	public Set<PersonToCarOwnership> getownersship() {
		return ownersship;
	}
	public void setOwners(Set<PersonToCarOwnership> ownersship) {
		this.ownersship = ownersship;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setEngineVolume(String engineVolume) {
		this.engineVolume = engineVolume;
	}
	public Long getId() {
		return id;
	}
	public String getModel() {
		return model;
	}
	public String getEngineVolume() {
		return engineVolume;
	}
}
