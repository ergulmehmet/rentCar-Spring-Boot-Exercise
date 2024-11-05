package com.memo.rentCar.repositories;

import com.memo.rentCar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
