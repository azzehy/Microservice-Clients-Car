package com.yazzzeh.ms.cars_service.client;

import com.yazzzeh.ms.cars_service.Client;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("http://localhost:8081")
public interface ClientService{

    @GetExchange("/api/clients/{id}")
    public Client getClientById(@PathVariable Long id);
}