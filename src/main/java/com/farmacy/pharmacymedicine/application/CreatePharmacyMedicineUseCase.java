package com.farmacy.pharmacymedicine.application;

import com.farmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.farmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class CreatePharmacyMedicineUseCase {
    private final PharmacyMedicineService pharmacyMedicineService;

    public CreatePharmacyMedicineUseCase(PharmacyMedicineService pharmacyMedicineService) {
        this.pharmacyMedicineService = pharmacyMedicineService;
    }

    public void execute(PharmacyMedicine pharmacyMedicine) {
        pharmacyMedicineService.addPharmacyMedicine(pharmacyMedicine);
    }
}
