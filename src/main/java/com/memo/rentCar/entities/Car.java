package com.memo.rentCar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "available")
    private boolean available;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rental> rentalList ;

    public Car(Long carId, String brand, String model, String licensePlate, boolean available, List<Rental> rentalList) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.available = available;
        this.rentalList = rentalList;
    }

    public Car() {
    }

    public Long getId() {
        return carId;
    }

    public void setId(Long id) {
        this.carId = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
