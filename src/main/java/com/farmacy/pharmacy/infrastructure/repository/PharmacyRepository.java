package com.farmacy.pharmacy.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.pharmacy.domain.entity.Pharmacy;
import com.farmacy.pharmacy.domain.service.PharmacyService;

public class PharmacyRepository implements PharmacyService {
    private final Connection connection;

    public PharmacyRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createPharmacy(Pharmacy pharmacy) {
        String sql = "INSERT INTO pharmacy (namefarmacy, addressfarmacy, latfarmacy, longfarmacy, codecityfarm, logo_farmacy) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pharmacy.getNamePharmacy());
            statement.setString(2, pharmacy.getAddressPharmacy());
            statement.setDouble(3, pharmacy.getLatPharmacy());
            statement.setDouble(4, pharmacy.getLongPharmacy());
            statement.setString(5, pharmacy.getCodeCityPharmacy());
            statement.setString(6, pharmacy.getLogoPharmacy());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pharmacy.setIdPharmacy(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pharmacy> readPharmacy(int idPharmacy) {
        String sql = "SELECT * FROM pharmacy WHERE idfarmacy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPharmacy);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Pharmacy pharmacy = new Pharmacy(
                        resultSet.getInt("idfarmacy"),
                        resultSet.getString("namefarmacy"),
                        resultSet.getString("addressfarmacy"),
                        resultSet.getDouble("latfarmacy"),
                        resultSet.getDouble("longfarmacy"),
                        resultSet.getString("codecityfarm"),
                        resultSet.getString("logo_farmacy")
                    );
                    return Optional.of(pharmacy);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Pharmacy> getAllPharmacies() {
        List<Pharmacy> pharmacies = new ArrayList<>();
        String sql = "SELECT * FROM pharmacy";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pharmacy pharmacy = new Pharmacy(
                    resultSet.getInt("idfarmacy"),
                    resultSet.getString("namefarmacy"),
                    resultSet.getString("addressfarmacy"),
                    resultSet.getDouble("latfarmacy"),
                    resultSet.getDouble("longfarmacy"),
                    resultSet.getString("codecityfarm"),
                    resultSet.getString("logo_farmacy")
                );
                pharmacies.add(pharmacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pharmacies;
    }

    @Override
    public void updatePharmacy(Pharmacy pharmacy) {
        String sql = "UPDATE pharmacy SET namefarmacy = ?, addressfarmacy = ?, latfarmacy = ?, longfarmacy = ?, codecityfarm = ?, logo_farmacy = ? WHERE idfarmacy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pharmacy.getNamePharmacy());
            statement.setString(2, pharmacy.getAddressPharmacy());
            statement.setDouble(3, pharmacy.getLatPharmacy());
            statement.setDouble(4, pharmacy.getLongPharmacy());
            statement.setString(5, pharmacy.getCodeCityPharmacy());
            statement.setString(6, pharmacy.getLogoPharmacy());
            statement.setInt(7, pharmacy.getIdPharmacy());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePharmacy(int idPharmacy) {
        String sql = "DELETE FROM pharmacy WHERE idfarmacy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPharmacy);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
