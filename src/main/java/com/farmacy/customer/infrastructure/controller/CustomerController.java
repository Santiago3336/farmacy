package com.farmacy.customer.infrastructure.controller;

import java.sql.Date;

import com.farmacy.customer.application.CreateCustomerUseCase;
import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService createCustomerUseCase) {
        this.customerService = createCustomerUseCase;
    }

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.customerService = null;
    }

    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }

    public Customer getCustomer(String idCustomer) {
        return customerService.readCustomer(idCustomer).orElse(null);
    }

    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    public void deleteCustomer(String idCustomer) {
        customerService.deleteCustomer(idCustomer);
    }

    public void addCustomer(String string, String string2, String string3, String string4, String string5, Date valueOf,
            double d, double e) {
        throw new UnsupportedOperationException("Unimplemented method 'addCustomer'");
    }
}
