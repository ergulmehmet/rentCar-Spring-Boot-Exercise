package com.memo.rentCar.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;



    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rental> rentalListCustomer;

    public Customer(Long customerId, String name, String email, String phone, List<Rental> rentalListCustomer) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rentalListCustomer = rentalListCustomer;
    }

    public Customer(){

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Rental> getRentalListCustomer() {
        return rentalListCustomer;
    }

    public void setRentalListCustomer(List<Rental> rentalListCustomer) {
        this.rentalListCustomer = rentalListCustomer;
    }
}
