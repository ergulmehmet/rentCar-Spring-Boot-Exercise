package com.memo.rentCar.repositories;

import com.memo.rentCar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findByAvailable(boolean available);
}
