package com.memo.rentCar.repositories;

import com.memo.rentCar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Long> {
}
