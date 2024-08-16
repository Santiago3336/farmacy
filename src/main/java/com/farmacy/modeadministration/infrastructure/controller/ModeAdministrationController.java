package com.farmacy.modeadministration.infrastructure.controller;

import com.farmacy.modeadministration.application.CreateModeAdministrationUseCase;
import com.farmacy.modeadministration.domain.entity.ModeAdministration;

public class ModeAdministrationController {
    private final CreateModeAdministrationUseCase createModeAdministrationUseCase;

    public ModeAdministrationController(CreateModeAdministrationUseCase createModeAdministrationUseCase) {
        this.createModeAdministrationUseCase = createModeAdministrationUseCase;
    }

    public void createModeAdministration(String descriptionMode) {
        ModeAdministration modeAdministration = new ModeAdministration(0, descriptionMode);
        createModeAdministrationUseCase.execute(modeAdministration);
    }
}
