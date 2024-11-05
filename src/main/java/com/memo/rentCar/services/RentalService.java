package com.memo.rentCar.services;

import com.memo.rentCar.dto.RentalDTO;
import com.memo.rentCar.entities.Car;
import com.memo.rentCar.entities.Customer;
import com.memo.rentCar.entities.Rental;
import com.memo.rentCar.repositories.CarRepo;
import com.memo.rentCar.repositories.CustomerRepo;
import com.memo.rentCar.repositories.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    @Autowired
    private RentalRepo rentalRepository;
    @Autowired
    private CarService carService;

    @Autowired
    private CarRepo carRepository;

    @Autowired
    private CustomerRepo customerRepository;



    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental saveRental(RentalDTO rentalDTO) {
        Rental rental = new Rental();
        rental.setStartDate(rentalDTO.getStartDate());
        rental.setEndDate(rentalDTO.getEndDate());

        Optional<Car> car = carRepository.findById(rentalDTO.getCarId());
        Optional<Customer> customer = customerRepository.findById(rentalDTO.getCustomerId());

        if (car.isPresent() && customer.isPresent()) {
            rental.setCar(car.get());
            rental.setCustomer(customer.get());
            rental.getCar().setAvailable(false);
            return rentalRepository.save(rental);
        } else {
            throw new RuntimeException("Car or Customer not found");
        }
    }

    public void deleteRental(Long id) {
        Rental rental = rentalRepository.findById(id).orElse(null);
        if (rental != null) {
            Car car = rental.getCar();
            car.setAvailable(true);
            carService.saveCar(car);
            rentalRepository.deleteById(id);
        }
    }
}
