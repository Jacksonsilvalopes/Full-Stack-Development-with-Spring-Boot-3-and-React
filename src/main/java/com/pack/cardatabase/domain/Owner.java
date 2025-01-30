package com.pack.cardatabase.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerid;
    private String firstname, lastname;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> carList;

    public Owner() {

    }

    public Owner(String firstname, String lastname) {

        this.firstname = firstname;
        this.lastname = lastname;
    }


    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Long getOwnerid() {
        return ownerid;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
