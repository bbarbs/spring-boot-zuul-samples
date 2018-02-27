package com.customer.repository;

import com.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository {

    /**
     * Get list of customers.
     *
     * @return
     */
    List<Customer> getAllCustomers();

    /**
     * Get customer by id.
     *
     * @param customerId
     * @return
     */
    Customer getCustomerById(Integer customerId);
}
