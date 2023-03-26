package com.example.B2_microservice_springcloud.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("limits-service")
@Getter
@Setter
public class Config {
    private int minimum;
    private int maximum;
}
