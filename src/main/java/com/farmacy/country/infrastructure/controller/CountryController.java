package com.farmacy.country.infrastructure.controller;

import com.farmacy.country.application.CreateCountryUseCase;
import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    public CountryController(CreateCountryUseCase createCountryUseCase) {
        this.countryService = null;
        
    }

    public void createCountry(Country country) {
        countryService.createCountry(country);
    }

    public Country getCountry(String code) {
        return countryService.readCountry(code).orElse(null);
    }

    public void addCountry(String string, String string2) {
        throw new UnsupportedOperationException("Unimplemented method 'addCountry'");
    }
}
