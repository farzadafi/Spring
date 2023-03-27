package com.example.currencyconversionservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class ConversionController {

    @GetMapping("/conversion")
    public CurrencyExchange getExchange() {
        HashMap<String, String> uriVariable = new HashMap<>();
        uriVariable.put("from", "Rial");
        uriVariable.put("to", "dolor");

        ResponseEntity<CurrencyExchange> responseEntity = new RestTemplate().
                getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyExchange.class, uriVariable);
        return responseEntity.getBody();
    }
}
