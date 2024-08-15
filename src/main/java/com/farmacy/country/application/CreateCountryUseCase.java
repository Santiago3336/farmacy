package com.farmacy.country.application;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class CreateCountryUseCase {
    private final CountryService countryService;

    // Constructor donde se inicializa el campo final
    public CreateCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    // Método que ejecuta el caso de uso
    public void execute(Country country) {
        countryService.createCountry(country);
    }
}
