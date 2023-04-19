package com.example.customer.dto;

public record CustomerRegistrationRequest(String firstname,
                                          String lastname,
                                          String email) {
}
