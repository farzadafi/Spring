package com.example.currencyconversionservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {

    private Integer id;
    private String from;
    private String to;
}
