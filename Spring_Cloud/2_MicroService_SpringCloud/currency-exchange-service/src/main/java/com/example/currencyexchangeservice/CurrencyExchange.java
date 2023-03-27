package com.example.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
