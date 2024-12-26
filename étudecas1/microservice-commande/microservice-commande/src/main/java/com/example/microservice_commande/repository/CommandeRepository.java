package com.example.microservice_commande.repository;

import com.example.microservice_commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
