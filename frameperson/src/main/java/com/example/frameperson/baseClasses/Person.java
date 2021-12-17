package com.example.frameperson.baseClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    protected String name;
    protected String birthdate;
    protected String phone;



    protected Person() {
    }

    public Person(String name, String birthdate, String phone) {
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId(){
        return id;
    }



}

