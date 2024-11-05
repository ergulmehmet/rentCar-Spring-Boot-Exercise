package com.memo.rentCar.contollers;

import com.memo.rentCar.dto.RentalDTO;
import com.memo.rentCar.entities.Rental;
import com.memo.rentCar.services.CarService;
import com.memo.rentCar.services.CustomerService;
import com.memo.rentCar.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;




    @GetMapping("/getlAllRentals")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @PostMapping("/addRental")
    public ResponseEntity<Rental> addRental(@RequestBody RentalDTO rentalDTO) {
        try {
            Rental rental = rentalService.saveRental(rentalDTO);
            return ResponseEntity.ok(rental);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }
}
