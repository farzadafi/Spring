package com.example.fraud.controller;

import com.example.fraud.dto.fraudCheckResponse;
import com.example.fraud.service.FraudCheckHistoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping(path = "{customerId}")
    public fraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        boolean fraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new fraudCheckResponse(fraudulentCustomer);
    }
}
