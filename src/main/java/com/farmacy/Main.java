package com.farmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.farmacy.country.application.CreateCountryUseCase;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.country.infrastructure.controller.CountryController;
import com.farmacy.country.infrastructure.repository.CountryRepository;

import com.farmacy.region.application.CreateRegionUseCase;
import com.farmacy.region.domain.service.RegionService;
import com.farmacy.region.infrastructure.controller.RegionController;
import com.farmacy.region.infrastructure.repository.RegionRepository;

import com.farmacy.unitmeasurement.application.CreateUnitMeasurementUseCase;
import com.farmacy.unitmeasurement.domain.service.UnitMeasurementService;
import com.farmacy.unitmeasurement.infrastructure.controller.UnitMeasurementController;
import com.farmacy.unitmeasurement.infrastructure.repository.UnitMeasurementRepository;

import com.farmacy.medicine.application.CreateMedicineUseCase;
import com.farmacy.medicine.domain.service.MedicineService;
import com.farmacy.medicine.infrastructure.controller.MedicineController;
import com.farmacy.medicine.infrastructure.repository.MedicineRepository;

import com.farmacy.customer.application.CreateCustomerUseCase;
import com.farmacy.customer.domain.service.CustomerService;
import com.farmacy.customer.infrastructure.controller.CustomerController;
import com.farmacy.customer.infrastructure.repository.CustomerRepository;

import com.farmacy.pharmacy.application.CreatePharmacyUseCase;
import com.farmacy.pharmacy.domain.service.PharmacyService;
import com.farmacy.pharmacy.infrastructure.controller.PharmacyController;
import com.farmacy.pharmacy.infrastructure.repository.PharmacyRepository;

import com.farmacy.pharmacymedicine.application.CreatePharmacyMedicineUseCase;
import com.farmacy.pharmacymedicine.domain.service.PharmacyMedicineService;
import com.farmacy.pharmacymedicine.infrastructure.controller.PharmacyMedicineController;
import com.farmacy.pharmacymedicine.infrastructure.repository.PharmacyMedicineRepository;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/your_database";
            String user = "your_user";
            String password = "your_password";
            connection = DriverManager.getConnection(url, user, password);

            CountryService countryService = new CountryRepository(connection);
            RegionService regionService = new RegionRepository(connection);
            UnitMeasurementService unitMeasurementService = new UnitMeasurementRepository(connection);
            MedicineService medicineService = new MedicineRepository(connection);
            CustomerService customerService = new CustomerRepository(connection);
            PharmacyService pharmacyService = new PharmacyRepository(connection);
            PharmacyMedicineService pharmacyMedicineService = new PharmacyMedicineRepository(connection);

            CreateCountryUseCase createCountryUseCase = new CreateCountryUseCase(countryService);
            CreateRegionUseCase createRegionUseCase = new CreateRegionUseCase(regionService);
            CreateUnitMeasurementUseCase createUnitMeasurementUseCase = new CreateUnitMeasurementUseCase(unitMeasurementService);
            CreateMedicineUseCase createMedicineUseCase = new CreateMedicineUseCase(medicineService);
            CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerService);
            CreatePharmacyUseCase createPharmacyUseCase = new CreatePharmacyUseCase(pharmacyService);
            CreatePharmacyMedicineUseCase createPharmacyMedicineUseCase = new CreatePharmacyMedicineUseCase(pharmacyMedicineService);
            
            CountryController countryController = new CountryController(createCountryUseCase);
            RegionController regionController = new RegionController(createRegionUseCase);
            UnitMeasurementController unitMeasurementController = new UnitMeasurementController(createUnitMeasurementUseCase);
            MedicineController medicineController = new MedicineController(createMedicineUseCase);
            CustomerController customerController = new CustomerController(createCustomerUseCase);
            PharmacyController pharmacyController = new PharmacyController(createPharmacyUseCase);
            PharmacyMedicineController pharmacyMedicineController = new PharmacyMedicineController(createPharmacyMedicineUseCase);

            /*Ejemplo de uso */
            countryController.addCountry("US", "United States");
            regionController.addRegion("NY", "New York", "US");
            unitMeasurementController.addUnitMeasurement(1, "Liter");
            medicineController.addMedicine(1, "Paracetamol", "HealthReg123", "Desc", "CodeComp", 1, 1, 1, "Role");
            customerController.addCustomer("C001", "John", "Doe", "NYC", "john.doe@example.com", java.sql.Date.valueOf("1990-01-01"), 40.7128, -74.0060);
            pharmacyController.addPharmacy(1, "Pharmacy1", "123 Main St", 40.7128, -74.0060, "NYC", "logo.png");
            pharmacyMedicineController.addPharmacyMedicine(1, 1, 12.99);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
