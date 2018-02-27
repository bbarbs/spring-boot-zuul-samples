package com.customer.service.impl;

import com.customer.exception.CustomerNotFoundException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import io.reactivex.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Maybe<List<Customer>> getAllCustomer() {
        return Maybe.fromCallable(() -> {
            List<Customer> customers = this.customerRepository.getAllCustomers();
            return customers;
        });
    }

    @Override
    public Maybe<Customer> getCustomerById(Integer customerId) {
        return Maybe.fromCallable(() -> {
            Customer customer = customerRepository.getCustomerById(customerId);
            if (customer == null) {
                throw new CustomerNotFoundException("Customer not found");
            }
            return customer;
        });
    }
}
