package com.yazzzeh.ms.cars_service.controller;


import com.yazzzeh.ms.cars_service.model.Car;
import com.yazzzeh.ms.cars_service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        try {
            Car car = carService.getCarById(id);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        try {
            Car existingCar = carService.getCarById(id);

            existingCar.setType(car.getType());
            existingCar.setModel(car.getModel());
            existingCar.setPlateNumber(car.getPlateNumber());
            //existingCar.setPrice(car.getPrice());
            existingCar.setClientId(car.getClientId());

            Car updatedCar = carService.createCar(existingCar);
            return ResponseEntity.ok(updatedCar);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        try {
            carService.getCarById(id);
            carService.deleteCar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
