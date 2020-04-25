package marko.andrushchenko.networklab1.entities;

import javax.persistence.*;

@Entity
public class PersonToCarOwnership {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ownership_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private Person owner;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "car_id")
	private Car property;

	public Long getId() {
		return id;
	}
	public Person getOwner() {
		return owner;
	}
	public Car getProperty() {
		return property;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public void setProperty(Car property) {
		this.property = property;
	}
}
