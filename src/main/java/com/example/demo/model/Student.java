package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Student {
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String surname;
    private final Number age;
    private String age_group;

    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("surname") String surname,
                   @JsonProperty("age") Number age,
                   String age_group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.age_group = age_group;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Number getAge() {
        return age;
    }

    public String getAgeGroup() {
        return age_group;
    }

    public void putAgeGroup(String newAgeGroup) {
        age_group = newAgeGroup;
    }
}