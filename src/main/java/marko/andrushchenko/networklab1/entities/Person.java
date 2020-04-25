package marko.andrushchenko.networklab1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addOwnership(PersonToCarOwnership ownership) {
        if (this.ownership == null) {
            this.ownership = new HashSet<>();
        }
        this.ownership.add(ownership);
    }

    public boolean removeOwnership(PersonToCarOwnership ownership) {
        if (this.ownership == null) {
            this.ownership = new HashSet<>();
        }
        PersonToCarOwnership[] list_ownersships = new PersonToCarOwnership[this.ownership.size()];
        this.ownership.toArray(list_ownersships);
        for (var own : list_ownersships) {
            if (own.getProperty().getId().equals(ownership.getProperty().getId())) {
                if (own.getOwner().getId().equals(ownership.getOwner().getId())) {
                    this.ownership.remove(own);
                }
            }
        }
        return true;
    }
}
