package com.example.microservice_commande.health;

import com.example.microservice_commandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Health health() {
        long count = commandeRepository.count();

        if (count > 0) {
            // Statut UP si des commande existent
            return Health.up()
                    .withDetail("status", "Il y a des commande dans la base")
                    .withDetail("nombre_commande", count)
                    .build();
        } else {
            // Statut DOWN si la table est vide
            return Health.down()
                    .withDetail("status", "Aucune commande dans la base")
                    .build();
        }
    }
}
