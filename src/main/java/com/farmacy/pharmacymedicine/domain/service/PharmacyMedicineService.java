package com.farmacy.pharmacymedicine.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.pharmacymedicine.domain.entity.PharmacyMedicine;

public interface PharmacyMedicineService {
    void addPharmacyMedicine(PharmacyMedicine pharmacyMedicine);
    Optional<PharmacyMedicine> readPharmacyMedicine(int idPharmacy, int idMedicine);
    List<PharmacyMedicine> getAllPharmacyMedicines();
    void updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine);
    void deletePharmacyMedicine(int idPharmacy, int idMedicine);
}
