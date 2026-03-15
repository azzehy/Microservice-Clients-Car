package com.yazzzeh.ms.cars_service.repository;

import com.yazzzeh.ms.cars_service.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
