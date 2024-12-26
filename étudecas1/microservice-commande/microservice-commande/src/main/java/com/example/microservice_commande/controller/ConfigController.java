package com.example.microservice_commande.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope

public class ConfigController {
    @Value("${mes-config-ms.commande-last}")
    private String commandeLast;

    @GetMapping
    public String getCommandeLast() {
        return "Commande des " + commandeLast + " derniers jours.";
    }
}
