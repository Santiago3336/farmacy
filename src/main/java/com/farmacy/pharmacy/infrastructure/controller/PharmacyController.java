package com.farmacy.pharmacy.infrastructure.controller;

import com.farmacy.pharmacy.application.CreatePharmacyUseCase;
import com.farmacy.pharmacy.domain.entity.Pharmacy;

public class PharmacyController {
    private final CreatePharmacyUseCase createPharmacyUseCase;

    public PharmacyController(CreatePharmacyUseCase createPharmacyUseCase) {
        this.createPharmacyUseCase = createPharmacyUseCase;
    }

    public void createPharmacy(String namePharmacy, String addressPharmacy, double latPharmacy, double longPharmacy, String codeCityPharmacy, String logoPharmacy) {
        Pharmacy pharmacy = new Pharmacy(0, namePharmacy, addressPharmacy, latPharmacy, longPharmacy, codeCityPharmacy, logoPharmacy);
        createPharmacyUseCase.execute(pharmacy);
    }

    public void addPharmacy(int i, String string, String string2, double d, double e, String string3, String string4) {
        throw new UnsupportedOperationException("Unimplemented method 'addPharmacy'");
    }
}
