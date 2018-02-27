package com.customer.repository.impl;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static Map<Integer, Object> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Sam", "Smith"));
        customers.put(2, new Customer(2, "Juan", "Cruz"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        for(Map.Entry<Integer, Object> map : customers.entrySet()) {
            list.add((Customer) map.getValue());
        }
        return list;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Customer customer = null;
        for(Map.Entry<Integer, Object> map : customers.entrySet()) {
            if(map.getKey().equals(customerId)) {
                customer = (Customer) map.getValue();
            }
        }
        return customer;
    }
}
