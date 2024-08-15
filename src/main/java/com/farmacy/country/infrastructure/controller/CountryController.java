package com.farmacy.country.infrastructure.controller;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class CountryController {
    private final CountryService countryService;

    // Constructor donde se inicializa countryService
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // Método que usa countryService
    public void createCountry(Country country) {
        countryService.createCountry(country);
    }

    // Otros métodos que pueden usar countryService
    public Country getCountry(String code) {
        return countryService.readCountry(code).orElse(null);
    }
}
