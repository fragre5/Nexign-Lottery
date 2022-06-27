package com.example.nexign.model;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    public User() {

    }

     @JsonCreator
    public User(Long id, String first_name, int age, String city){
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
