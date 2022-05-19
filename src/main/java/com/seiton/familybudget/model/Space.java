package com.seiton.familybudget.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Entity
public class Space {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;


    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;


    @ManyToMany
    private List<User> guests;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getGuests() {
        return guests;
    }

    public void setGuests(List<User> guests) {
        this.guests = guests;
    }
}
