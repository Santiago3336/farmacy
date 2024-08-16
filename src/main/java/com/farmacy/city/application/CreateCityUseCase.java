package com.farmacy.city.application;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CreateCityUseCase {
    private final CityService cityService;

    public CreateCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(City city) {
        cityService.createCity(city);
    }
}
