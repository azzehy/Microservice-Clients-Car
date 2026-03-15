package com.yazzzeh.ms.cars_service.model;

import com.yazzzeh.ms.cars_service.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String plateNumber;
    private String model;
    private Long clientId;
//    @Transient @ManyToOne
//    private Client client;

}
