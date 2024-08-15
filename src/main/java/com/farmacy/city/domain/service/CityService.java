package com.farmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.city.domain.entity.City;

public interface CityService {
    void createCity(City city);
    Optional<City> readCity(String codeCity);
    List<City> getAllCities();
    void updateCity(City city);
    void deleteCity(String codeCity);
}
