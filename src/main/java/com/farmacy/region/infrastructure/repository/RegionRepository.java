package com.farmacy.region.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;

public class RegionRepository implements RegionService {
    private final Connection connection;

    public RegionRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRegion(Region region) {
        String sql = "INSERT INTO region (codereg, namereg, codecountry) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, region.getCodeRegion());
            statement.setString(2, region.getNameRegion());
            statement.setString(3, region.getCodeCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Region> readRegion(String codeRegion) {
        String sql = "SELECT * FROM region WHERE codereg = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codeRegion);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Region region = new Region(
                        resultSet.getString("codereg"),
                        resultSet.getString("namereg"),
                        resultSet.getString("codecountry")
                    );
                    return Optional.of(region);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Region> getAllRegions() {
        List<Region> regions = new ArrayList<>();
        String sql = "SELECT * FROM region";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Region region = new Region(
                    resultSet.getString("codereg"),
                    resultSet.getString("namereg"),
                    resultSet.getString("codecountry")
                );
                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public void updateRegion(Region region) {
        String sql = "UPDATE region SET namereg = ?, codecountry = ? WHERE codereg = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, region.getNameRegion());
            statement.setString(2, region.getCodeCountry());
            statement.setString(3, region.getCodeRegion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegion(String codeRegion) {
        String sql = "DELETE FROM region WHERE codereg = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codeRegion);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
