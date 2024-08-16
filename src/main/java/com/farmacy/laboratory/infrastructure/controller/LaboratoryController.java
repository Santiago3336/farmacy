package com.farmacy.laboratory.infrastructure.controller;

import com.farmacy.laboratory.application.CreateLaboratoryUseCase;
import com.farmacy.laboratory.domain.entity.Laboratory;
import com.farmacy.laboratory.domain.service.LaboratoryService;

import java.util.List;
import java.util.Optional;

public class LaboratoryController {
    private final LaboratoryService laboratoryService;
    private final CreateLaboratoryUseCase createLaboratoryUseCase;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
        this.createLaboratoryUseCase = new CreateLaboratoryUseCase(laboratoryService);
    }

    public void createLaboratory(Laboratory laboratory) {
        createLaboratoryUseCase.execute(laboratory);
    }

    public Optional<Laboratory> readLaboratory(int idLab) {
        return laboratoryService.readLaboratory(idLab);
    }

    public List<Laboratory> getAllLaboratories() {
        return laboratoryService.getAllLaboratories();
    }

    public void updateLaboratory(Laboratory laboratory) {
        laboratoryService.updateLaboratory(laboratory);
    }

    public void deleteLaboratory(int idLab) {
        laboratoryService.deleteLaboratory(idLab);
    }
}
