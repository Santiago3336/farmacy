package com.farmacy.unitmeasurement.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.farmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class UnitMeasurementRepository implements UnitMeasurementService {
    private final Connection connection;

    public UnitMeasurementRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUnitMeasurement(UnitMeasurement unitMeasurement) {
        String sql = "INSERT INTO unitmeasurement (idum, nameum) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, unitMeasurement.getId());
            statement.setString(2, unitMeasurement.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UnitMeasurement> readUnitMeasurement(int id) {
        String sql = "SELECT * FROM unitmeasurement WHERE idum = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UnitMeasurement unitMeasurement = new UnitMeasurement(
                        resultSet.getInt("idum"),
                        resultSet.getString("nameum")
                    );
                    return Optional.of(unitMeasurement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<UnitMeasurement> getAllUnitMeasurements() {
        List<UnitMeasurement> unitMeasurements = new ArrayList<>();
        String sql = "SELECT * FROM unitmeasurement";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                UnitMeasurement unitMeasurement = new UnitMeasurement(
                    resultSet.getInt("idum"),
                    resultSet.getString("nameum")
                );
                unitMeasurements.add(unitMeasurement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unitMeasurements;
    }

    @Override
    public void updateUnitMeasurement(UnitMeasurement unitMeasurement) {
        String sql = "UPDATE unitmeasurement SET nameum = ? WHERE idum = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, unitMeasurement.getName());
            statement.setInt(2, unitMeasurement.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUnitMeasurement(int id) {
        String sql = "DELETE FROM unitmeasurement WHERE idum = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
