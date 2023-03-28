package com.example.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @GetMapping("/retry")
    @Retry(name = "retry", fallbackMethod = "fallback")
    public String retry() {
        ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost:1111/naser", String.class);
        return forEntity.getBody();
    }

    public String fallback(Exception ex) {
        return "fallback-response";
    }
}
