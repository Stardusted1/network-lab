package marko.andrushchenko.networklab1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;
    private String model;
    private String engineVolume;


    @JsonIgnore
    @OneToMany(mappedBy = "property", fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    private Set<PersonToCarOwnership> ownersship;


    public Set<PersonToCarOwnership> getOwnersship() {
        return Objects.requireNonNullElseGet(ownersship, HashSet::new);
    }


    public void setOwnersship(Set<PersonToCarOwnership> ownersship) {
        this.ownersship = ownersship;
    }


    public void addOwnership(PersonToCarOwnership ownership) {
        if (this.ownersship == null) {
            this.ownersship = new HashSet<>();
        }
        PersonToCarOwnership[] list_ownersships = new PersonToCarOwnership[this.ownersship.size()];
        ownersship.toArray(list_ownersships);
        for (var own : list_ownersships) {
            if (own.getProperty().getId().equals(ownership.getProperty().getId())) {
                if (own.getOwner().getId().equals(ownership.getOwner().getId())) {
                    return;
                }
            }
        }
        this.ownersship.add(ownership);
    }


    public void removeOwnership(PersonToCarOwnership ownership) {
        if (this.ownersship == null) {
            this.ownersship = new HashSet<>();
        }
        PersonToCarOwnership[] list_ownersships = new PersonToCarOwnership[ownersship.size()];
        ownersship.toArray(list_ownersships);
        for (var own : list_ownersships) {
            if (own.getProperty().getId().equals(ownership.getProperty().getId())) {
                if (own.getOwner().getId().equals(ownership.getOwner().getId())) {
                    this.ownersship.remove(own);
                }
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(String engineVolume) {
        this.engineVolume = engineVolume;
    }
}
