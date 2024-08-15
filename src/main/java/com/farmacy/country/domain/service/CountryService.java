package com.farmacy.country.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.country.domain.entity.Country;

public interface CountryService {
    void createCountry(Country country);
    Optional<Country> readCountry(String countryCode);
    List<Country> getAllCountries();
    void updateCountry(Country country);
    void deleteCountry(String countryCode);
}
