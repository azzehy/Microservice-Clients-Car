package com.yazzzeh.ms.cars_service.service;

import com.yazzzeh.ms.cars_service.model.Car;
import com.yazzzeh.ms.cars_service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car createCar(Car car){
        return carRepository.save(car);
    }

    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carRepository.findAll());
    }

    public Car getCarById(Long id) throws Exception{
        return carRepository.findById(id).orElseThrow(() -> new Exception("Car Not Found"));
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

}
