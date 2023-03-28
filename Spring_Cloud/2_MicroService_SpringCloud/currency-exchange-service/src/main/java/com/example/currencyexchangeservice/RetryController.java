package com.example.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    @GetMapping("/retry")
    public String retry() {
        return "Retry method!";
    }
}
