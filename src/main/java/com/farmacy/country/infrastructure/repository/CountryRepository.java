package com.farmacy.country.infrastructure.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class CountryRepository implements CountryService {
    private Connection connection;

    public CountryRepository() {
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
    public void createCountry(Country country) {
        String sql = "INSERT INTO country (codecountry, namecountry) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, country.getCodeCountry());
            statement.setString(2, country.getNameCountry());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    country.setCodeCountry(generatedKeys.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Optional<Country> readCountry(String countryCode) {
        String query = "SELECT codecountry, namecountry FROM country WHERE codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, countryCode);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Country country = new Country(
                        resultSet.getString("codecountry"),
                        resultSet.getString("namecountry")
                    );
                    return Optional.of(country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return Optional.empty();
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        String sql = "SELECT codecountry, namecountry FROM country";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Country country = new Country(
                    resultSet.getString("codecountry"),
                    resultSet.getString("namecountry")
                );
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return countries;
    }

    @Override
    public void updateCountry(Country country) {
        String sql = "UPDATE country SET namecountry = ? WHERE codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, country.getNameCountry());
            statement.setString(2, country.getCodeCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void deleteCountry(String countryCode) {
        String sql = "DELETE FROM country WHERE codecountry = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, countryCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    // Método para cerrar la conexión
    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
