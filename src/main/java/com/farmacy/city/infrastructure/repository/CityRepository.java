package com.farmacy.city.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository() {
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
    public void createCity(City city){
        String sql = "INSER INTO city (codecity,namecity, codereg) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city.getCodeCity());
            statement.setString(2, city.getNameCity());
            statement.setString(3, city.getCodeReg());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<City> readCity (String codeCity) {
        String sql = "SELECT codecity,namecity,codereg FROM city WHERE codecity = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codeCity);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    City city = new City(
                        resultSet.getString("codecity"), 
                        resultSet.getString("namecity"),
                        resultSet.getString("codereg")
                    );
                    return Optional.of(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT codecitu, namecity, codereg FROM city";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                City city = new City(
                    resultSet.getString("codecity"), 
                    resultSet.getString("namecity"), 
                    resultSet.getString("codereg")
                );
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void updateCity(City city) {
        String sql = "UPDATE city SET namecity = ?, codereg = ? WHERE codecity = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city.getNameCity());
            statement.setString(2, city.getCodeReg());
            statement.setString(3, city.getCodeCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String codeCity) {
        String sql = "DELETE FROM city WHERE codecity = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codeCity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
