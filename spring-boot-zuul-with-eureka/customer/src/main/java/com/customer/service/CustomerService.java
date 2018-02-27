package com.customer.service;

import com.customer.model.Customer;
import io.reactivex.Maybe;

import java.util.List;

public interface CustomerService {

    /**
     * Get list of customers.
     *
     * @return
     */
    Maybe<List<Customer>> getAllCustomer();

    /**
     * Get customer by id.
     *
     * @param customerId
     * @return
     */
    Maybe<Customer> getCustomerById(Integer customerId);
}
