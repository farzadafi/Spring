package com.example.customer.service;

import com.example.customer.dto.CustomerRegistrationRequest;
import com.example.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
    }
}
