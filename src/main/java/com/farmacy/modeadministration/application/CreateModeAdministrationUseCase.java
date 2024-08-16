package com.farmacy.modeadministration.application;

import com.farmacy.modeadministration.domain.entity.ModeAdministration;
import com.farmacy.modeadministration.domain.service.ModeAdministrationService;

public class CreateModeAdministrationUseCase {
    private final ModeAdministrationService modeAdministrationService;

    public CreateModeAdministrationUseCase(ModeAdministrationService modeAdministrationService) {
        this.modeAdministrationService = modeAdministrationService;
    }

    public void execute(ModeAdministration modeAdministration) {
        modeAdministrationService.createModeAdministration(modeAdministration);
    }
}
