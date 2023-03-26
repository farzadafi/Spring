package com.example.B2_microservice_springcloud.controller;

import com.example.B2_microservice_springcloud.configuration.Config;
import com.example.B2_microservice_springcloud.model.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Config config;

    public LimitsController(Config config) {
        this.config = config;
    }

    @GetMapping("/limits")
    public Limits returnLimits() {
        return new Limits(config.getMinimum(), config.getMaximum());
    }
}
