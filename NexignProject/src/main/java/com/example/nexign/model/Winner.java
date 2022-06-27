package com.example.nexign.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Table(name = "winners")
public class Winner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    public Winner(){}

    @JsonCreator
    public Winner(Long id, String first_name, int age, String city){
        this.id = id;
        this.firstName = first_name;
        this.age = age;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString(){
        return "Name:" + firstName + "; Age:" + age + "; City:" + city;
    }
}
