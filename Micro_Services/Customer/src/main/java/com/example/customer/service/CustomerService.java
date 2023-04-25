package com.example.customer.service;

import com.example.customer.dto.CustomerRegistrationRequest;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.farzadafi.clients.fraud.FraudCheckResponse;
import com.farzadafi.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient) {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

        checkFraud(customer);
    }

    private void checkFraud(Customer customer) {
        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());

        if (fraudster.isFraudster())
            throw new IllegalStateException("fraudster");
    }
}
