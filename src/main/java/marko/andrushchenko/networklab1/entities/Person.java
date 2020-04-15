package marko.andrushchenko.networklab1.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private double height;
	private double weight;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<PersonToCarOwnership> ownership;

	public Set<PersonToCarOwnership> getOwnership() {
		return ownership;
	}

	public void setOwnership(Set<PersonToCarOwnership> ownership) {
		this.ownership = ownership;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
