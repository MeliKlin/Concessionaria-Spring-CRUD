package com.mercadolivre.concessionaria.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private BigDecimal price;
    private String currency;
    private List<Object> services;
    private String countOfOwners;

}
