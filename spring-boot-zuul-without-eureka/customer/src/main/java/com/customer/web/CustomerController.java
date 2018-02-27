package com.customer.web;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import io.reactivex.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * Get list of customers.
     *
     * @return
     */
    @GetMapping(
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Maybe<List<Customer>> getAllCustomer() {
        return this.customerService.getAllCustomer();
    }

    /**
     * Get customer by id.
     *
     * @param customerId
     * @return
     */
    @GetMapping(
            value = "/{customerId}",
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Maybe<Customer> getCustomerById(@PathVariable(name = "customerId") Integer customerId) {
        return this.customerService.getCustomerById(customerId);
    }
}
