package com.farmacy.pharmacymedicine.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.pharmacymedicine.domain.entity.PharmacyMedicine;
import com.farmacy.pharmacymedicine.domain.service.PharmacyMedicineService;

public class PharmacyMedicineRepository implements PharmacyMedicineService {
    private final Connection connection;

    public PharmacyMedicineRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addPharmacyMedicine(PharmacyMedicine pharmacyMedicine) {
        String sql = "INSERT INTO pharmacymedicine (idfarmacy, idmedicinefarm, price) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pharmacyMedicine.getIdPharmacy());
            statement.setInt(2, pharmacyMedicine.getIdMedicine());
            statement.setDouble(3, pharmacyMedicine.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<PharmacyMedicine> readPharmacyMedicine(int idPharmacy, int idMedicine) {
        String sql = "SELECT * FROM pharmacymedicine WHERE idfarmacy = ? AND idmedicinefarm = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPharmacy);
            statement.setInt(2, idMedicine);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    PharmacyMedicine pharmacyMedicine = new PharmacyMedicine(
                        resultSet.getInt("idfarmacy"),
                        resultSet.getInt("idmedicinefarm"),
                        resultSet.getDouble("price")
                    );
                    return Optional.of(pharmacyMedicine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<PharmacyMedicine> getAllPharmacyMedicines() {
        List<PharmacyMedicine> pharmacyMedicines = new ArrayList<>();
        String sql = "SELECT * FROM pharmacymedicine";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PharmacyMedicine pharmacyMedicine = new PharmacyMedicine(
                    resultSet.getInt("idfarmacy"),
                    resultSet.getInt("idmedicinefarm"),
                    resultSet.getDouble("price")
                );
                pharmacyMedicines.add(pharmacyMedicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pharmacyMedicines;
    }

    @Override
    public void updatePharmacyMedicine(PharmacyMedicine pharmacyMedicine) {
        String sql = "UPDATE pharmacymedicine SET price = ? WHERE idfarmacy = ? AND idmedicinefarm = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, pharmacyMedicine.getPrice());
            statement.setInt(2, pharmacyMedicine.getIdPharmacy());
            statement.setInt(3, pharmacyMedicine.getIdMedicine());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePharmacyMedicine(int idPharmacy, int idMedicine) {
        String sql = "DELETE FROM pharmacymedicine WHERE idfarmacy = ? AND idmedicinefarm = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPharmacy);
            statement.setInt(2, idMedicine);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
