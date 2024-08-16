package com.farmacy.laboratory.domain.service;

import com.farmacy.laboratory.domain.entity.Laboratory;

import java.util.List;
import java.util.Optional;

public interface LaboratoryService {
    void createLaboratory(Laboratory laboratory);
    Optional<Laboratory> readLaboratory(int idLab);
    List<Laboratory> getAllLaboratories();
    void updateLaboratory(Laboratory laboratory);
    void deleteLaboratory(int idLab);
}
