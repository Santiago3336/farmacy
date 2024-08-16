package com.farmacy.modeadministration.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.modeadministration.domain.entity.ModeAdministration;

public interface ModeAdministrationService {
    void createModeAdministration(ModeAdministration modeAdministration);
    Optional<ModeAdministration> readModeAdministration(int id);
    List<ModeAdministration> getAllModeAdministrations();
    void updateModeAdministration(ModeAdministration modeAdministration);
    void deleteModeAdministration(int id);
}
