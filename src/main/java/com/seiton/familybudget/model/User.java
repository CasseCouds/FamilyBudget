package com.seiton.familybudget.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank
    private String telegrammID;
    @NotBlank
    private String name;


    public User() {

    }

    public User (String telegrammID, String name){
        this.telegrammID = telegrammID;
        this.name = name;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelegrammID() {
        return telegrammID;
    }

    public void setTelegrammID(String telegrammID) {
        this.telegrammID = telegrammID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
