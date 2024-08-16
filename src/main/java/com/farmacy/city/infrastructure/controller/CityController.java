package com.farmacy.city.infrastructure.controller;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    public void createCity(City city) {
        cityService.createCity(city);
    }

    public City getCity(String codeCity) {
        return cityService.readCity(codeCity).orElse(null);
    }

    public void updateCity(City city) {
        cityService.updateCity(city);
    }

    public void deleteCity(String codeCity) {
        cityService.deleteCity(codeCity);
    }
}
