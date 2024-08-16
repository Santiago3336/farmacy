package com.farmacy.activeprinciple.infrastructure.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.farmacy.activeprinciple.domain.service.ActivePrincipleService;

public class ActivePrincipleRepository implements ActivePrincipleService {
    private Connection connection;

    public ActivePrincipleRepository() {
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

    public ActivePrincipleRepository(Connection connection2) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void createActivePrinciple(ActivePrinciple activePrinciple) {
        String sql = "INSERT INTO activeprinciple (nameap) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, activePrinciple.getNameAp());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    activePrinciple.setIdAp(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ActivePrinciple> readActivePrinciple(int idAp) {
        String sql = "SELECT idap, nameap FROM activeprinciple WHERE idap = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idAp);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ActivePrinciple activePrinciple = new ActivePrinciple(
                        resultSet.getInt("idap"),
                        resultSet.getString("nameap")
                    );
                    return Optional.of(activePrinciple);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ActivePrinciple> getAllActivePrinciples() {
        List<ActivePrinciple> activePrinciples = new ArrayList<>();
        String sql = "SELECT idap, nameap FROM activeprinciple";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ActivePrinciple activePrinciple = new ActivePrinciple(
                    resultSet.getInt("idap"),
                    resultSet.getString("nameap")
                );
                activePrinciples.add(activePrinciple);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activePrinciples;
    }

    @Override
    public void updateActivePrinciple(ActivePrinciple activePrinciple) {
        String sql = "UPDATE activeprinciple SET nameap = ? WHERE idap = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, activePrinciple.getNameAp());
            statement.setInt(2, activePrinciple.getIdAp());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteActivePrinciple(int idAp) {
        String sql = "DELETE FROM activeprinciple WHERE idap = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idAp);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
