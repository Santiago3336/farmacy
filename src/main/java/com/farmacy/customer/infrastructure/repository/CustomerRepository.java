package com.farmacy.customer.infrastructure.repository;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CustomerRepository implements CustomerService {
    private Connection connection;

    public CustomerRepository() {
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

    public CustomerRepository(Connection connection2) {
    }

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (idcustomer, namecustomer, lastnamecustomer, codecitycustomer, emailcustomer, brrdate, latitud, longitud) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getIdCustomer());
            statement.setString(2, customer.getNameCustomer());
            statement.setString(3, customer.getLastNameCustomer());
            statement.setString(4, customer.getCodeCityCustomer());
            statement.setString(5, customer.getEmailCustomer());
            statement.setDate(6, new java.sql.Date(customer.getBrrDate().getTime()));
            statement.setDouble(7, customer.getLatitude());
            statement.setDouble(8, customer.getLongitude());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customer> readCustomer(String idCustomer) {
        String sql = "SELECT idcustomer, namecustomer, lastnamecustomer, codecitycustomer, emailcustomer, brrdate, latitud, longitud FROM customer WHERE idcustomer = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idCustomer);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Customer customer = new Customer(
                        resultSet.getString("idcustomer"),
                        resultSet.getString("namecustomer"),
                        resultSet.getString("lastnamecustomer"),
                        resultSet.getString("codecitycustomer"),
                        resultSet.getString("emailcustomer"),
                        resultSet.getDate("brrdate"),
                        resultSet.getDouble("latitud"),
                        resultSet.getDouble("longitud")
                    );
                    return Optional.of(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT idcustomer, namecustomer, lastnamecustomer, codecitycustomer, emailcustomer, brrdate, latitud, longitud FROM customer";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = new Customer(
                    resultSet.getString("idcustomer"),
                    resultSet.getString("namecustomer"),
                    resultSet.getString("lastnamecustomer"),
                    resultSet.getString("codecitycustomer"),
                    resultSet.getString("emailcustomer"),
                    resultSet.getDate("brrdate"),
                    resultSet.getDouble("latitud"),
                    resultSet.getDouble("longitud")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET namecustomer = ?, lastnamecustomer = ?, codecitycustomer = ?, emailcustomer = ?, brrdate = ?, latitud = ?, longitud = ? WHERE idcustomer = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getNameCustomer());
            statement.setString(2, customer.getLastNameCustomer());
            statement.setString(3, customer.getCodeCityCustomer());
            statement.setString(4, customer.getEmailCustomer());
            statement.setDate(5, new java.sql.Date(customer.getBrrDate().getTime()));
            statement.setDouble(6, customer.getLatitude());
            statement.setDouble(7, customer.getLongitude());
            statement.setString(8, customer.getIdCustomer());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String idCustomer) {
        String sql = "DELETE FROM customer WHERE idcustomer = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idCustomer);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
