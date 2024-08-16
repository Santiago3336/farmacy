package com.farmacy.pharmacy.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.pharmacy.domain.entity.Pharmacy;

public interface PharmacyService {
    void createPharmacy(Pharmacy pharmacy);
    Optional<Pharmacy> readPharmacy(int idPharmacy);
    List<Pharmacy> getAllPharmacies();
    void updatePharmacy(Pharmacy pharmacy);
    void deletePharmacy(int idPharmacy);
}
