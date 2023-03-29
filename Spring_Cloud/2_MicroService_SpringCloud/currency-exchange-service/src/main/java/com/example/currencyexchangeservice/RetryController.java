package com.example.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @GetMapping("/retry")
//    @Retry(name = "retry", fallbackMethod = "fallback")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
//    @RateLimiter(name = "default")
//    @Bulkhead(name = "default")
    public String retry() {
        ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost:1111/naser", String.class);
        return forEntity.getBody();
    }

    public String fallback(Exception ex) {
        return "fallback-response";
    }
}
