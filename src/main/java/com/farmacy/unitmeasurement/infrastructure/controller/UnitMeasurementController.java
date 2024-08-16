package com.farmacy.unitmeasurement.infrastructure.controller;

import com.farmacy.unitmeasurement.application.CreateUnitMeasurementUseCase;
import com.farmacy.unitmeasurement.domain.entity.UnitMeasurement;

public class UnitMeasurementController {
    private final CreateUnitMeasurementUseCase createUnitMeasurementUseCase;

    public UnitMeasurementController(CreateUnitMeasurementUseCase createUnitMeasurementUseCase) {
        this.createUnitMeasurementUseCase = createUnitMeasurementUseCase;
    }

    public void addUnitMeasurement(int id, String name) {
        UnitMeasurement unitMeasurement = new UnitMeasurement(id, name);
        createUnitMeasurementUseCase.execute(unitMeasurement);
    }
}
