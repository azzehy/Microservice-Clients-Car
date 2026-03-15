package com.yazzzeh.ms.cars_service;

import com.yazzzeh.ms.cars_service.client.ClientService;
import com.yazzzeh.ms.cars_service.model.Car;
import com.yazzzeh.ms.cars_service.repository.CarRepository;
import feign.codec.Decoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarsServiceApplication {

    private CarRepository carRepository;
    private ClientService clientService;
    public static void main(String[] args) {
        SpringApplication.run(CarsServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner initialiserMYSQL(CarRepository carRepository
            , ClientService clientService
    ){

        return args -> {
            Client c1 = clientService.getClientById(2L);
            Client c2 = clientService.getClientById(1L);
            System.out.println("**************************");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getName());
            System.out.println("**************************");
            carRepository.save(new Car(null, "Toyota", "A 25 333", "Corolla", c2.getId()));
            carRepository.save(new Car(null, "Renault", "B 6 3456", "Megane", c2.getId()));
            carRepository.save(new Car(null, "Peugeot", "A 55 4444", "301", c1.getId()));
        };
    }

}
