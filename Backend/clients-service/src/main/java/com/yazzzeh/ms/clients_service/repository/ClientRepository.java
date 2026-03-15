package com.yazzzeh.ms.clients_service.repository;

import com.yazzzeh.ms.clients_service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
