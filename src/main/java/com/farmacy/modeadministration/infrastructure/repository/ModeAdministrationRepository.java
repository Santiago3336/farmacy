package com.farmacy.modeadministration.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.modeadministration.domain.entity.ModeAdministration;
import com.farmacy.modeadministration.domain.service.ModeAdministrationService;

public class ModeAdministrationRepository implements ModeAdministrationService {
    private final Connection connection;

    public ModeAdministrationRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createModeAdministration(ModeAdministration modeAdministration) {
        String sql = "INSERT INTO modeadministration (descriptionmode) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, modeAdministration.getDescriptionMode());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    modeAdministration.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ModeAdministration> readModeAdministration(int id) {
        String sql = "SELECT * FROM modeadministration WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ModeAdministration modeAdministration = new ModeAdministration(
                        resultSet.getInt("id"),
                        resultSet.getString("descriptionmode")
                    );
                    return Optional.of(modeAdministration);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ModeAdministration> getAllModeAdministrations() {
        List<ModeAdministration> modeAdministrations = new ArrayList<>();
        String sql = "SELECT * FROM modeadministration";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ModeAdministration modeAdministration = new ModeAdministration(
                    resultSet.getInt("id"),
                    resultSet.getString("descriptionmode")
                );
                modeAdministrations.add(modeAdministration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modeAdministrations;
    }

    @Override
    public void updateModeAdministration(ModeAdministration modeAdministration) {
        String sql = "UPDATE modeadministration SET descriptionmode = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, modeAdministration.getDescriptionMode());
            statement.setInt(2, modeAdministration.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteModeAdministration(int id) {
        String sql = "DELETE FROM modeadministration WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
