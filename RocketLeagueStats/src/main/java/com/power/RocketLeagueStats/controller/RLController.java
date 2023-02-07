package com.power.RocketLeagueStats.controller;

import com.power.RocketLeagueStats.service.RLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RLController {

    @Autowired // Injeção de dependência
    private RLService rlService;

    @GetMapping("/status")
    public String getStatus() {
        return "Service Status: " + "Ok, está aqui.";
    }
}
