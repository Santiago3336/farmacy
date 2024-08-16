package com.farmacy.medicine.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;

public class MedicineRepository implements MedicineService {
    private final Connection connection;

    public MedicineRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createMedicine(Medicine medicine) {
        String sql = "INSERT INTO medicine (proceedings, namemedic, healthregister, description, codecomposition, idap, idlab, codeum, namerol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, medicine.getProceedings());
            statement.setString(2, medicine.getNameMedic());
            statement.setString(3, medicine.getHealthRegister());
            statement.setString(4, medicine.getDescription());
            statement.setString(5, medicine.getCodeComposition());
            statement.setInt(6, medicine.getIdAP());
            statement.setInt(7, medicine.getIdLab());
            statement.setInt(8, medicine.getCodeUM());
            statement.setString(9, medicine.getNameRole());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    medicine.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Medicine> readMedicine(int id) {
        String sql = "SELECT * FROM medicine WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Medicine medicine = new Medicine(
                        resultSet.getString("proceedings"),
                        resultSet.getString("namemedic"),
                        resultSet.getString("healthregister"),
                        resultSet.getString("description"),
                        resultSet.getString("codecomposition"),
                        resultSet.getInt("idap"),
                        resultSet.getInt("idlab"),
                        resultSet.getInt("codeum"),
                        resultSet.getString("namerol")
                    );
                    medicine.setId(resultSet.getInt("id"));
                    return Optional.of(medicine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        String sql = "SELECT * FROM medicine";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Medicine medicine = new Medicine(
                    resultSet.getString("proceedings"),
                    resultSet.getString("namemedic"),
                    resultSet.getString("healthregister"),
                    resultSet.getString("description"),
                    resultSet.getString("codecomposition"),
                    resultSet.getInt("idap"),
                    resultSet.getInt("idlab"),
                    resultSet.getInt("codeum"),
                    resultSet.getString("namerol")
                );
                medicine.setId(resultSet.getInt("id"));
                medicines.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        String sql = "UPDATE medicine SET proceedings = ?, namemedic = ?, healthregister = ?, description = ?, codecomposition = ?, idap = ?, idlab = ?, codeum = ?, namerol = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medicine.getProceedings());
            statement.setString(2, medicine.getNameMedic());
            statement.setString(3, medicine.getHealthRegister());
            statement.setString(4, medicine.getDescription());
            statement.setString(5, medicine.getCodeComposition());
            statement.setInt(6, medicine.getIdAP());
            statement.setInt(7, medicine.getIdLab());
            statement.setInt(8, medicine.getCodeUM());
            statement.setString(9, medicine.getNameRole());
            statement.setInt(10, medicine.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        String sql = "DELETE FROM medicine WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
