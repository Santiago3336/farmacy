package com.farmacy.medicine.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.medicine.domain.entity.Medicine;

public interface MedicineService {
    void createMedicine(Medicine medicine);
    Optional<Medicine> readMedicine(int id);
    List<Medicine> getAllMedicines();
    void updateMedicine(Medicine medicine);
    void deleteMedicine(int id);
}
