package com.farmacy.unitmeasurement.application;

import com.farmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.farmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class CreateUnitMeasurementUseCase {
    private final UnitMeasurementService unitMeasurementService;

    public CreateUnitMeasurementUseCase(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void execute(UnitMeasurement unitMeasurement) {
        unitMeasurementService.addUnitMeasurement(unitMeasurement);
    }
}
