package com.yazzzeh.ms.clients_service;

import com.yazzzeh.ms.clients_service.model.Client;
import com.yazzzeh.ms.clients_service.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ClientsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserMYSQL(ClientRepository clientRepository){
        return args -> {
            clientRepository.save(new Client(null, "Younes Azzehizi", Float.parseFloat("21")));
            clientRepository.save(new Client(null, "Saif Mohamed Bensat", Float.parseFloat("21")));
            clientRepository.save(new Client(null, "Aymane Echatibi", Float.parseFloat("24")));
        };
    }
}