package com.farmacy.unitmeasurement.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.unitmeasurement.domain.entity.UnitMeasurement;

public interface UnitMeasurementService {
    void addUnitMeasurement(UnitMeasurement unitMeasurement);
    Optional<UnitMeasurement> readUnitMeasurement(int id);
    List<UnitMeasurement> getAllUnitMeasurements();
    void updateUnitMeasurement(UnitMeasurement unitMeasurement);
    void deleteUnitMeasurement(int id);
}
