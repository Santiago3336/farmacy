package com.farmacy.medicine.application;

import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;

public class CreateMedicineUseCase {
    private final MedicineService medicineService;

    public CreateMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Medicine medicine) {
        medicineService.createMedicine(medicine);
    }
}
