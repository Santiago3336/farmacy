package com.farmacy.laboratory.infrastructure.repository;

import com.farmacy.laboratory.domain.entity.Laboratory;
import com.farmacy.laboratory.domain.service.LaboratoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class LaboratoryRepository implements LaboratoryService {
    private Connection connection;

    public LaboratoryRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createLaboratory(Laboratory laboratory) {
        String sql = "INSERT INTO laboratory (namelab, codereg) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, laboratory.getNameLab());
            statement.setString(2, laboratory.getCodeReg());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    laboratory.setIdLab(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Laboratory> readLaboratory(int idLab) {
        String sql = "SELECT idlab, namelab, codereg FROM laboratory WHERE idlab = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLab);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Laboratory laboratory = new Laboratory(
                        resultSet.getInt("idlab"),
                        resultSet.getString("namelab"),
                        resultSet.getString("codereg")
                    );
                    return Optional.of(laboratory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Laboratory> getAllLaboratories() {
        List<Laboratory> laboratories = new ArrayList<>();
        String sql = "SELECT idlab, namelab, codereg FROM laboratory";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Laboratory laboratory = new Laboratory(
                    resultSet.getInt("idlab"),
                    resultSet.getString("namelab"),
                    resultSet.getString("codereg")
                );
                laboratories.add(laboratory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laboratories;
    }

    @Override
    public void updateLaboratory(Laboratory laboratory) {
        String sql = "UPDATE laboratory SET namelab = ?, codereg = ? WHERE idlab = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, laboratory.getNameLab());
            statement.setString(2, laboratory.getCodeReg());
            statement.setInt(3, laboratory.getIdLab());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLaboratory(int idLab) {
        String sql = "DELETE FROM laboratory WHERE idlab = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLab);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
