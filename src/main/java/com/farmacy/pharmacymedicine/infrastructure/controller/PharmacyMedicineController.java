package com.farmacy.pharmacymedicine.infrastructure.controller;

import com.farmacy.pharmacymedicine.application.CreatePharmacyMedicineUseCase;
import com.farmacy.pharmacymedicine.domain.entity.PharmacyMedicine;

public class PharmacyMedicineController {
    private final CreatePharmacyMedicineUseCase createPharmacyMedicineUseCase;

    public PharmacyMedicineController(CreatePharmacyMedicineUseCase createPharmacyMedicineUseCase) {
        this.createPharmacyMedicineUseCase = createPharmacyMedicineUseCase;
    }

    public void addPharmacyMedicine(int idPharmacy, int idMedicine, double price) {
        PharmacyMedicine pharmacyMedicine = new PharmacyMedicine(idPharmacy, idMedicine, price);
        createPharmacyMedicineUseCase.execute(pharmacyMedicine);
    }
}
