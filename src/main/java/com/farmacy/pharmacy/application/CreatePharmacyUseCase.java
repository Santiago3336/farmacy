package com.farmacy.pharmacy.application;

import com.farmacy.pharmacy.domain.entity.Pharmacy;
import com.farmacy.pharmacy.domain.service.PharmacyService;

public class CreatePharmacyUseCase {
    private final PharmacyService pharmacyService;

    public CreatePharmacyUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public void execute(Pharmacy pharmacy) {
        pharmacyService.createPharmacy(pharmacy);
    }
}
