package com.pack.cardatabase.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerid;
    private String firstname, lastname;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> carList;

 /*

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_owner", joinColumns =  { @JoinColumn(name = "ownerid")}, inverseJoinColumns = {  @JoinColumn(name = "id")} )

    private Set<Car> cars = new HashSet<Car>();

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
*/
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
