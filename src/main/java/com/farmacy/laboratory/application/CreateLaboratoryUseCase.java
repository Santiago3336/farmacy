package com.farmacy.laboratory.application;

import com.farmacy.laboratory.domain.entity.Laboratory;
import com.farmacy.laboratory.domain.service.LaboratoryService;

public class CreateLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public CreateLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory) {
        laboratoryService.createLaboratory(laboratory);
    }
}
