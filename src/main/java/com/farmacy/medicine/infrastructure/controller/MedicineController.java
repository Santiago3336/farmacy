package com.farmacy.medicine.infrastructure.controller;

import com.farmacy.medicine.application.CreateMedicineUseCase;
import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;

import java.util.List;
import java.util.Optional;

public class MedicineController {
    private final MedicineService medicineService;
    private final CreateMedicineUseCase createMedicineUseCase;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
        this.createMedicineUseCase = new CreateMedicineUseCase(medicineService);
    }

    public MedicineController(CreateMedicineUseCase createMedicineUseCase2) {
        this.medicineService = null;
        this.createMedicineUseCase = null;
    }

    public void createMedicine(Medicine medicine) {
        createMedicineUseCase.execute(medicine);
    }

    public Optional<Medicine> readMedicine(int id) {
        return medicineService.readMedicine(id);
    }

    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    public void updateMedicine(Medicine medicine) {
        medicineService.updateMedicine(medicine);
    }

    public void deleteMedicine(int id) {
        medicineService.deleteMedicine(id);
    }

    public void addMedicine(int i, String string, String string2, String string3, String string4, int j, int k, int l,
            String string5) {
        throw new UnsupportedOperationException("Unimplemented method 'addMedicine'");
    }
}
